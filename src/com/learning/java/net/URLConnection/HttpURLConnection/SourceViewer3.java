package com.learning.java.net.URLConnection.HttpURLConnection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class SourceViewer3 {

    public static void main(String[] args) {

        for (int i=0; i < args.length; i++) {
            try {
                URL u = new URL(args[i]);
                HttpURLConnection uc = (HttpURLConnection) u.openConnection();
                int code = uc.getResponseCode();
                String response = uc.getResponseMessage();

                System.out.println("HTTP/1.x " + code + " " + response);
                for (int j = 1;; j++) {
                    String header = uc.getHeaderField(j);
                    String key = uc.getHeaderFieldKey(j);
                    if (header == null || key == null) {
                        break;
                    }
                    System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
                }
                System.out.println();

                try (InputStream in = new BufferedInputStream(uc.getInputStream())) {
                    Reader r = new InputStreamReader(in);
                    int c;
                    while((c = r.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
