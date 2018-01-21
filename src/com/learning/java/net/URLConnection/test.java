package com.learning.java.net.URLConnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by binzhang213309 on 2017/12/12.
 */
public class test {

    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.overcomingbias.com/");
            URLConnection uc = u.openConnection();
            uc.connect();
            // 从URL读取...
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
