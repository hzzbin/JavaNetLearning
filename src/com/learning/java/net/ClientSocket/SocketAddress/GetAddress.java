package com.learning.java.net.ClientSocket.SocketAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by binzhang213309 on 2017/12/19.
 */
public class GetAddress {

    public static void main(String[] args) {
        Socket socket = new Socket();
        InetSocketAddress address = new InetSocketAddress("www.baidu.com", 80);
        try {
            socket.connect(address);
            SocketAddress remoteAddress = socket.getRemoteSocketAddress();
            SocketAddress localAddress = socket.getLocalSocketAddress();
            System.out.println(address.getHostName() +  " Remote Address is " + remoteAddress.toString());;
            System.out.println("Local Address is " + localAddress.toString());
            socket.close();
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {

            }
        }


        //public InetSocketAddress(InetAddress address, int port)
        //public InetSocketAddress(String host, int port)
        //public InetSocketAddress(int port)

        // 使用静态工厂方法创建InetSocketAddress实例， 从而不在DNS中查找主机
        // public static InetSocketAddress createUnresolved(String host, int port);
        InetSocketAddress address1 = InetSocketAddress.createUnresolved("www.baidu.com", 80);
    }
}
