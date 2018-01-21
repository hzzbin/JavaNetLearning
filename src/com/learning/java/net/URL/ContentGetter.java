package com.learning.java.net.URL;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/1.
 */
public class ContentGetter {

    public static void main(String[] args) {

        if (args.length > 0) {
            try {
                URL u = new URL(args[0]);
                Object o = u.getContent();
                System.out.println("I got a " + o.getClass().getName());
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        try {
            URL u = new URL("http://admin@www.ibiblio.org/javafaq/javafaq.html#xtocid1902914");
            System.out.println("url.port:" + u.getPort());
            System.out.println("url.defaultPort:" + u.getDefaultPort());
            System.out.println("url.file:" + u.getFile());
            System.out.println("url.authority:" + u.getAuthority());
            System.out.println("url.getHost:" + u.getHost());
            Class<?>[] types = new Class[3];
            types[0] = String.class;
            types[1] = Reader.class;
            types[2] = InputStream.class;
            Object o = u.getContent(types);

            if (o instanceof String) {
                System.out.println(o);
            } else if (o instanceof Reader) {
                int c;
                Reader r = (Reader) o;
                while(( c = r.read()) != -1) {
                    System.out.write(c);
                }
                r.close();
            } else if (o instanceof InputStream) {
                int c;
                InputStream in = (InputStream) o;
                while (( c = in.read()) != -1) {
                    System.out.write(c);
                }
                in.close();
            } else {
                System.out.println("Error: unexpected type " + o.getClass());
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
