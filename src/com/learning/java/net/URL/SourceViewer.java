package com.learning.java.net.URL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/1.
 */
public class SourceViewer {

    public static void main (String[] args) {

        if (args.length > 0) {
            InputStream in = null;
            try {
                URL u = new URL(args[0]);
                in = u.openStream();
                in = new BufferedInputStream(in);
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read()) != -1) {
                    System.out.print((char) c);
                }

            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        //忽略
                    }
                }
            }
        }
    }
}
