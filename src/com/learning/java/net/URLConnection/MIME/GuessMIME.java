package com.learning.java.net.URLConnection.MIME;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class GuessMIME {

    public static void main(String[] args) {
        try {
            String filename = "test.xml";
            URL url = new URL("http://www.baidu.com");
            URLConnection uc = url.openConnection();

            System.out.println(URLConnection.guessContentTypeFromName(filename));

            System.out.println(URLConnection.guessContentTypeFromStream(uc.getInputStream()));

        } catch (IOException ex) {

        }

    }
}
