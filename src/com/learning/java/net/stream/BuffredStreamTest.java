package com.learning.java.net.stream;

import java.io.*;

/**
 * Created by binzhang213309 on 2017/11/24.
 */
public class BuffredStreamTest {

    public static void main(String args[]) {
        char c =  'q';
        char c2 = '中';

        System.out.println("'q' binary:" + Integer.toBinaryString(c));
        System.out.println("'中' binary:" + Integer.toBinaryString(c2));
    }

    public static String getMacCyrillicString(InputStream in)
        throws IOException {
        Reader r = new InputStreamReader(in, "MacCyrillic");
        r = new BufferedReader(r, 1024);
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = r.read()) != -1)  {
            sb.append((char) c);
        }
        return sb.toString();
    }
}
