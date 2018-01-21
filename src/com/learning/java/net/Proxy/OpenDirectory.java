package com.learning.java.net.Proxy;

import com.learning.java.net.URI.QueryString;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/4.
 */
public class OpenDirectory {

    public static void main(String[] args) {

        String target = "";
        for (int i = 0; i < args.length; i++) {
            target += args[i] + " ";
        }
        target = target.trim();

        QueryString query = new QueryString();
        query.add("q", target);
        try {
            URL u = new URL("http://www.dmoz.org/search/q?" + query);
            try (InputStream in = new BufferedInputStream(u.openStream()) ) {
                InputStreamReader theHTML = new InputStreamReader(in);
                int c;
                while((c = theHTML.read()) != -1) {
                    System.out.println((char) c);
                }
            } catch (MalformedURLException ex) {
                System.err.println(ex);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
