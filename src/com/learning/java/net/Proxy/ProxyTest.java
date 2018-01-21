package com.learning.java.net.Proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;

/**
 * Created by binzhang213309 on 2017/12/4.
 */
public class ProxyTest {

    public static void main(String[] args) {
        SocketAddress address  = new InetSocketAddress("proxy.example.com", 80);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
    }

}
