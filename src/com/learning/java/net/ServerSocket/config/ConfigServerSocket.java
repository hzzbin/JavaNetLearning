package com.learning.java.net.ServerSocket.config;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by binzhang213309 on 2017/12/21.
 */
public class ConfigServerSocket {

    public static void main(String[] args) throws IOException{
        // SO_TIMEOUT
        // ServerSocket.accept()等待入站连接超时时间
        try (ServerSocket server = new ServerSocket(80))  {
            server.setSoTimeout(30000); // 阻塞不超过30秒
            try {
                Socket s = server.accept();
                // 处理连接
                // ...
            } catch (IOException ex) {
                System.err.println("No connection within 30 seconds");
            }



        } catch (IOException ex) {
            System.err.println("Unexpected IOException: " + ex);
        }

        // SO_REUSEADDR
        // 是否允许新的Socket绑定到之前使用过的端口上
        ServerSocket ss = new ServerSocket(10240);
        System.out.println("Resuable: " + ss.getReuseAddress());

        // SO_RCVBUF
        // 设置服务器Socket接受客户端Socket默认接收缓冲区大小
        ServerSocket ss2 = new ServerSocket();
        int receiveBufferSize = ss2.getReceiveBufferSize();
        if (receiveBufferSize < 131072) {
            ss2.setReceiveBufferSize(131072);
        }
        ss2.bind(new InetSocketAddress(8000));
        // ...
    }
}
