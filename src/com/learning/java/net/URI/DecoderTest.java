package com.learning.java.net.URI;

import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URLDecoder;

/**
 * Created by binzhang213309 on 2017/12/4.
 */
public class DecoderTest {

    public static void main(String[] args) {
        try {
            String input = "https://www.google.com/" +
                    "search?h1=en&as_q=Java&ad_epq=I%2FO";
            String output = URLDecoder.decode(input, "UTF-8");

            System.out.println(output);

        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }

    }
}
