package com.learning.java.net.URLConnection.ConfigRequestHeaders;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by binzhang213309 on 2017/12/17.
 */
public class SetUserAgentHeader {

    public static void main(String[] args) {
        String myUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";
        String myCookie = "";
        try {
            URL u = new URL("http://www.baidu.com/");
            URLConnection uc = u.openConnection();
            uc.setRequestProperty("User-Agent", myUserAgent);
            uc.setRequestProperty("Cookie", myCookie);
            try (InputStream in = new BufferedInputStream(uc.getInputStream())) {
                Reader r = new InputStreamReader(in);
                int c;
                while((c = r.read()) != -1) {
                    System.out.print((char)c);
                }
            }
            Map<String, List<String>> responseHeaders = uc.getHeaderFields();
            System.out.println(responseHeaders);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
