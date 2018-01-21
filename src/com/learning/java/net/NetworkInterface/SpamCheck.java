package com.learning.java.net.NetworkInterface;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class SpamCheck {

    public static final String BLACKHOLE = "sb1.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {
        for (String arg: args) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spammer.");
            } else {
                System.out.println(arg + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String arg) {
        try{
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException ex) {
            return false;
        }
    }
}
