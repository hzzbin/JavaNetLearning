package com.learning.java.net.ClientSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 * Created by binzhang213309 on 2017/12/19.
 */
public class Constructors {

    public static void main(String[] args) {
        // 位创建连接
        Socket s1 = new Socket();

        Proxy proxy = null;
        Socket s2 = new Socket(proxy);

//        SocketImpl impl = null;
//        Socket s3 = new Socket(impl);

        /////////////////////
        try {
            InetAddress inward = InetAddress.getByName("router");
            Socket socket = new Socket("mail", 25, inward, 0);

        } catch (IOException ex) {
            System.err.println(ex);
        }

        //////////////////////
        try {
            Socket socket = new Socket();
            // 填入socket选项
            SocketAddress address = new InetSocketAddress("time.nist.gov", 13);
            //发起连接并设置超时时间 15000ms
            socket.connect(address, 15000);
            // 使用socket...
        } catch (IOException ex) {
            System.err.println(ex);
        }


        //////////////////////
        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress("www.baidu.com", 80);
        try {
            socket.connect(address);
            //使用socket...
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                // 忽略
            }
        }

    }
}
