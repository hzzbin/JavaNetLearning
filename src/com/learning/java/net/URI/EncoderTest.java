package com.learning.java.net.URI;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by binzhang213309 on 2017/12/3.
 */
public class EncoderTest {

    public static void main(String[] args) {

        try {
            System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
            System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
            System.out.println(URLEncoder.encode("This%string%has%percent%signs","UTF-8"));
            System.out.println(URLEncoder.encode("This+string+has+pluses","UTF-8"));
            System.out.println(URLEncoder.encode("This/string/has/slashes","UTF-8"));
            System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks","UTF-8"));
            System.out.println(URLEncoder.encode("This:string:has:colons","UTF-8"));
            System.out.println(URLEncoder.encode("This~string~has~tildes","UTF-8"));
            System.out.println(URLEncoder.encode("This(string)has(parentheses)","UTF-8"));
            System.out.println(URLEncoder.encode("This.string.has.periods","UTF-8"));
            System.out.println(URLEncoder.encode("This=string=has=equals=signs","UTF-8"));
            System.out.println(URLEncoder.encode("This&string&has&ampersands","UTF-8"));
            System.out.println(URLEncoder.encode("This中string中has中non-ASCII characters","UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }


        try {
            String url = "https://www.google.com/search?h1=en&as_q=Java&as_epq=I/O";
            String query = URLEncoder.encode(url, "UTF-8");
            System.out.println(query);

            String url2 = "https://www.google.com/search?";
            url2 += URLEncoder.encode("h1", "UTF-8");
            url2 += "=";
            url2 += URLEncoder.encode("en", "UTF-8");
            url2 += "&";
            url2 += URLEncoder.encode("as_q", "UTF-8");
            url2 += "=";
            url2 += URLEncoder.encode("Java", "UTF-8");
            url2 += "&";
            url2 += URLEncoder.encode("as_epq", "UTF-8");
            url2 += "=";
            url2 += URLEncoder.encode("I/O", "UTF-8");

            System.out.println(url2);

        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
    }
}
