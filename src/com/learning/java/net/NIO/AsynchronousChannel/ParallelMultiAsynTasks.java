package com.learning.java.net.NIO.AsynchronousChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by binzhang213309 on 2018/1/14.
 */
public class ParallelMultiAsynTasks {

    public static void main(String[] args) throws IOException,
            InterruptedException, ExecutionException {
        int port = 80;
        SocketAddress address = new InetSocketAddress(args[0], port);
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<Void> connected = client.connect(address);

        ByteBuffer buffer = ByteBuffer.allocate(74);

        // 等待连接完成
        connected.get();

        // 从连接中读取
        Future<Integer> future = client.read(buffer);

        // 做其他工作...\

        // 等待读取完成
        future.get();

        // 回绕并排空缓冲区
        buffer.flip();
        WritableByteChannel out = Channels.newChannel(System.out);
        out.write(buffer);
    }
}
