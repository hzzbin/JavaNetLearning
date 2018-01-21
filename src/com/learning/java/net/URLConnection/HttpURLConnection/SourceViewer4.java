package com.learning.java.net.URLConnection.HttpURLConnection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class SourceViewer4 {

    public static void main (String[] args) {
        try {
            URL u = new URL("http://www.verysource.com/");
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            uc.setRequestMethod("OPTIONS");
            try (InputStream raw = uc.getInputStream()) {
                //System.out.println("Response----------------->" + uc.getResponseCode() + uc.getResponseMessage());
                //printFromStream(raw);
            } catch (IOException ex) {
                System.out.println("Response----------------->" + uc.getResponseCode() + uc.getResponseMessage());
                System.err.println(ex);
                printFromStream(uc.getErrorStream());
            }
        } catch (MalformedURLException ex) {
            System.err.println(args[0] + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void printFromStream(InputStream raw) throws IOException {
        try (InputStream buffer = new BufferedInputStream(raw)) {
            Reader reader = new InputStreamReader(buffer);
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
