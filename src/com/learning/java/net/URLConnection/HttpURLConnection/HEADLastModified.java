package com.learning.java.net.URLConnection.HttpURLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class HEADLastModified {

    public static void main(String[] args) {
        for (int i=0; i < args.length; i++) {
            try {
                URL u = new URL(args[i]);
                HttpURLConnection http = (HttpURLConnection) u.openConnection();
                http.setRequestMethod("HEAD");
                System.out.println(u + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        was last modified at " + new Date(http.getLastModified()) );
            } catch (IOException ex) {
                System.err.println(ex);
            }

            System.out.println();
        }
    }
}
