package com.learning.java.net.URLConnection.Config;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by binzhang213309 on 2017/12/17.
 */
public class Last24 {

    public static void main (String[] args) {

        // 用当前的时间初始化一个Date对象
        Date today = new Date();
        long millisecondsPerday = 24 * 60 * 60 * 1000;

        for (int i = 0; i < args.length; i++) {
            try {
                URL u = new URL(args[i]);
                URLConnection uc = u.openConnection();
                System.out.println("Original if modified since: "
                + new Date(uc.getIfModifiedSince()));
                uc.setIfModifiedSince((new Date(today.getTime()
                - millisecondsPerday)).getTime());
                System.out.println("Will retrieve file if it's modified since"
                + new Date(uc.getIfModifiedSince()));
                try (InputStream in = new BufferedInputStream(uc.getInputStream())) {
                    Reader r = new InputStreamReader(in);
                    int c;
                    while ((c = r.read()) != -1) {
                        System.out.print((char) c);
                    }
                    System.out.println();
                }
            } catch(IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
