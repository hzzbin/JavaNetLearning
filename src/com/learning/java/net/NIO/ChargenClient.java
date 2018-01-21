package com.learning.java.net.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by binzhang213309 on 2017/12/25.
 */
public class ChargenClient {

    public static int DEFAULT_PORT = 19;

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java ChargenClient host [port");
            return;
        }

        int port;
        try {
            port = Integer.parseInt(args[1]);
        } catch (RuntimeException ex) {
            port = DEFAULT_PORT;
        }

        try {
            SocketAddress address = new InetSocketAddress(args[0], port);
            SocketChannel client = SocketChannel.open(address);

            ByteBuffer buffer = ByteBuffer.allocate(74);
            WritableByteChannel out = Channels.newChannel(System.out);

            // 默认是阻塞模式
            System.out.println("I/O Is Blocking : " + client.isBlocking());
            while (client.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
            //client.close();

            // 非阻塞版本的while
            client.configureBlocking(false);
            while (true) {
                // 把每次循环都要运行的代码都放在这里
                // 无论有没有读到数据
                int n = client.read(buffer);
                if (n > 0) {
                    buffer.flip();
                    out.write(buffer);
                    buffer.clear();
                } else if (n == -1) {
                    // 这不应该发生，除非服务器发生故障
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
