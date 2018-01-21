package com.learning.java.net.URLConnection;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by binzhang213309 on 2017/12/12.
 */
public class SourceViewer2 {

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                // 打开URLConnection进行读取
                URL u = new URL(args[0]);
                URLConnection uc = u.openConnection();
                try (InputStream raw = uc.getInputStream()) { //自动关闭
                    InputStream buffer = new BufferedInputStream(raw);
                    // 将InputStream串链到一个Reader
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while ((c = reader.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.out.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
