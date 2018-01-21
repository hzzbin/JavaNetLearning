package com.learning.java.net.NetworkInterface;

import com.sun.org.apache.bcel.internal.classfile.Unknown;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class Weblog {

    public static void main(String[] args) {
        try (FileInputStream fin =  new FileInputStream(args[0]);
        Reader in = new InputStreamReader(fin);
        BufferedReader bin = new BufferedReader(in);) {

            for (String entry = bin.readLine();
                    entry != null;
                    entry = bin.readLine()) {
                //分解IP地址
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                // 想DNS请求主机名并显示
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    System.err.println(entry);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
