package com.learning.java.net.UDP;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by binzhang213309 on 2018/1/17.
 */
public class UDPPortScanner {

    public static void main(String[] args) {
        for (int port = 0; port <= 65535; port++) {
            try {
                // 如果已经有服务器在端口运行
                // 下一行会失败并进入catch块
                DatagramSocket server = new DatagramSocket(port);
                server.close();
            } catch (SocketException ex) {
                System.out.println("There is a server on port " + port + ".");
            }
        }
    }
}
