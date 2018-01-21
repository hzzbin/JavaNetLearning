package com.learning.java.net.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class OReillyByName {

    public static void main(String[] args) {
        String hostName = "dongfangju.online" ;
        String host2 = "www.baidu.com";
        String host2Ip = "61.135.169.125";
        String ip = "123.56.216.11";
        String ip2 = "127.0.0.1";

        byte[] host2IpByte = {61, (byte) 135, (byte) 169, 125};
        try{
            InetAddress address = InetAddress.getByName(ip2);
            InetAddress address1 = InetAddress.getByAddress(host2IpByte);
            System.out.println(address.getCanonicalHostName());


//            InetAddress[] addresses = InetAddress.getAllByName(host2);
//            for (InetAddress a : addresses) {
//                System.out.println(a);
//            }

//            InetAddress me = InetAddress.getLocalHost();
//            System.out.println(me);

        } catch (UnknownHostException ex) {
            System.out.println("Could not find " + hostName);
        }

    }
}
