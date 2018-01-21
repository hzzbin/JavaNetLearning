package com.learning.java.net.NetworkInterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class GetNetworkInterface {

    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getByName("10.0.76.199");
            NetworkInterface ni = NetworkInterface.getByInetAddress(local);
            if (ni == null) {
                System.out.println("That's weird, No local loopback address.");
            } else {
                System.out.println(ni);
            }


        } catch (SocketException ex) {

        } catch (UnknownHostException ex) {

        }
    }
}
