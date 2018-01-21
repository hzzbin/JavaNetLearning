package com.learning.java.net.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/1.
 */
public class CloseURLStream {

    public static void main(String[] args) {

        //Java 6
        InputStream in = null;
        try {
            URL u = new URL("http://www.baidu.com");
            in = u.openStream();
            int c;
            while((c = in.read()) != -1) {
                System.out.write(c);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // 忽略
            }
        }

        // Java 7 用 try-with-resources 自动关闭流
        try {
            URL u = new URL("http://www.baidu.com");
            try (InputStream in2 = u.openStream()) {
                int c;
                while ((c = in2.read()) != -1) {
                    System.out.write(c);
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
