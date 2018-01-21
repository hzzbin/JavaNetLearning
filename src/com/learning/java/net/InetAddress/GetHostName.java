package com.learning.java.net.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class GetHostName {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("180.87.64.212");
        System.out.println(ia.getHostName());
    }


}
