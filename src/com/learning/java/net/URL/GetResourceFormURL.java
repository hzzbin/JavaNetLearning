package com.learning.java.net.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/1.
 */
public class GetResourceFormURL {

    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.baidu.com");
            InputStream in = u.openStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.write(c);
            }
            in.close();

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
