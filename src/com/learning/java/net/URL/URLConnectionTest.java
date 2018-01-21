package com.learning.java.net.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by binzhang213309 on 2017/12/1.
 */
public class URLConnectionTest {

    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.baidu.com");
            try {
                URLConnection uc = u.openConnection();
                InputStream in = uc.getInputStream();
                // 从连接读取...

            } catch (IOException ex) {

            }
        } catch (MalformedURLException ex) {

        }

        try {
            URL u = new URL("http://www.baidu.com");
            Object o = u.getContent();
            // 将Object 强制类型转换为适当的对象
            // 处理这个Object...
        } catch (IOException ex) {

        }




    }

}
