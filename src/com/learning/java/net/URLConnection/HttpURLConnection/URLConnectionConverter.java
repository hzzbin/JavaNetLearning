package com.learning.java.net.URLConnection.HttpURLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class URLConnectionConverter {

    public static void main(String[] args) {
        try {
            URL u = new URL("http://lesswrong.com/");
            URLConnection uc = u.openConnection();
            HttpURLConnection http = (HttpURLConnection) uc;
            http.setRequestMethod("HEAD");
        } catch (IOException ex) {

        }
    }
}
