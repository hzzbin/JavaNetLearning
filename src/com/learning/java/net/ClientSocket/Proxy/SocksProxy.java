package com.learning.java.net.ClientSocket.Proxy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by binzhang213309 on 2017/12/19.
 */
public class SocksProxy {

    public static void main(String[] args) {
        SocketAddress proxyAddress = new InetSocketAddress("myproxy.example.com", 1080);
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
        // Socket s = new Socket(proxy);

        SocketAddress remoteHost = new InetSocketAddress("login.ibiblio.org", 25);

        try( Socket s = new Socket(proxy)) {

            s.connect(remoteHost);
        } catch (IOException ex) {

            System.err.println(ex);
        }
    }
}
