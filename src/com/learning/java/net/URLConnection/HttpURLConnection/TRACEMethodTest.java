package com.learning.java.net.URLConnection.HttpURLConnection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class TRACEMethodTest {

    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.baidu.com/");
            HttpURLConnection http = (HttpURLConnection) u.openConnection();

            http.setRequestMethod("GET");

            // http header
            System.out.println("HTTP header------------------------------------------------------->");
            Map<String, List<String>> headers = http.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }

            try (InputStream in = new BufferedInputStream(http.getInputStream())) {
                // http body
                System.out.println("HTTP body------------------------------------------------------->");
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read()) != -1) {
                    System.out.print((char) c);
                }
            }

        } catch (IOException ex) {

        }
    }
}
