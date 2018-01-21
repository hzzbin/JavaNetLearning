package com.learning.java.net.NetworkInterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class InterfaceLister {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while(interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);

            Enumeration addresses = ni.getInetAddresses();
            while(addresses.hasMoreElements()) {
                System.out.print(" " + addresses.nextElement());
            }
            System.out.println(" ");
        }
    }
}
