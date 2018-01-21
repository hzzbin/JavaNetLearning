package com.learning.java.net.URLConnection.Post;

import com.learning.java.net.URI.QueryString;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by binzhang213309 on 2017/12/17.
 */
public class FormPoster {

    private URL url;

    private QueryString query = new QueryString();

    public FormPoster (URL url) {
        if (!(url.getProtocol().toLowerCase().startsWith("http") || url.getProtocol().toLowerCase().startsWith("https"))) {
            throw new IllegalArgumentException(
                    "Posting only works for http/https URLs");
        }
        this.url = url;
    }

    public void add(String name, String value) {
        query.add(name, value);
    }

    public URL getURL() {
        return this.url;
    }

    public InputStream post() throws IOException {

        // 打开连接，准备POST
        URLConnection uc = url.openConnection();
        uc.setDoOutput(true);
        try (OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream(), "UTF-8")) {

            // POST行、Content-type首部和Content-length首部
            // 由URLConnection发送
            // 我们只需发送数据
            out.write(query.toString());
            out.write("\r\n");
            out.flush();
            // 刷新输出流并关闭流
            // 如果输出流没有关闭，则不会发送任何数据
        }

        // 返回响应
        return uc.getInputStream();
    }

    public static void main(String[] args) {
        URL url;
        if (args.length > 0) {
            try {
                url = new URL(args[0]);
            } catch (MalformedURLException ex) {
                System.err.println("Usage: java FormPoster url");
                return;
            }
        } else {
            try {
                url = new URL(
                        "http://www.cafeaulait.org/books/jnp4/postquery.phtml");
            } catch (MalformedURLException ex) {
                System.err.println(ex);
                return;
            }
        }

        FormPoster poster = new FormPoster(url);
        poster.add("name", "Elliotte Rusty Marold");
        poster.add("email", "elharo@ibiblio.org");

        try (InputStream in = poster.post()) {
            // 读取响应
            Reader r = new InputStreamReader(in);
            int c;
            while((c = r.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
