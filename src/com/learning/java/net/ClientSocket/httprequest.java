package com.learning.java.net.ClientSocket;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class httprequest {

    public static void main(String[] args) {
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        fieldMap.put("Accept-Encoding", "gzip, deflate, br");
        fieldMap.put("Accept-Language", "zh-CN,zh;q=0.9");
        fieldMap.put("Cache-Control", "max-age=0");
        fieldMap.put("Connection","keep-alive");
        fieldMap.put("Host","www.baidu.com");
        fieldMap.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        StringBuilder headers = new StringBuilder();
        for(Map.Entry<String, String> entry : fieldMap.entrySet()) {
            headers.append(entry.getKey() + ":" + entry.getValue() + "\r\n");
        }
        // Java 7
        try (Socket connection = new Socket("www.baidu.com", 80)) {
            Writer out = new OutputStreamWriter(
                    connection.getOutputStream(), "UTF-8");
            //out.write("GET / HTTP/1.0\r\n" + headers.toString() + "\r\n");
            out.write("GET / HTTP/1.0\r\n\r\n");
            out.flush();
            connection.shutdownOutput();
            System.out.println("Send Success");

            // 读取响应...
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            for (String line = reader.readLine();line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
