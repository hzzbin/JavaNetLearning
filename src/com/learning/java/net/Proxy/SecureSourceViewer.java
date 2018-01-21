package com.learning.java.net.Proxy;

import java.io.*;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/4.
 */
public class SecureSourceViewer {

    public static void main(String[] args) {

        Authenticator.setDefault(new DialogAuthenticator());

        for (int i = 0; i < args.length; i++) {
            try {
                // 打开URL进行读取
                URL u = new URL(args[i]);
                try (InputStream in = new BufferedInputStream(u.openStream())) {
                    // 将InputStream串链到一个Reader
                    Reader r = new InputStreamReader(in);
                    int c;
                    while((c = r.read()) != -1) {
                        System.out.println((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }


            System.out.println();
        }

        // 由于使用了AWT，必须显式退出
        System.exit(0);
    }
}
