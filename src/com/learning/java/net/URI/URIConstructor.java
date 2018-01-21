package com.learning.java.net.URI;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by binzhang213309 on 2017/12/2.
 */
public class URIConstructor {

    public static void main(String[] args) {
        try {
           URI voice = new URI("tel:+1-800-9988-9938");
           URI web = new URI("http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc");
           URI book = new URI("urn:isbn:1-565-92870-9");

           URI absolute = new URI("http", "//www.ibiblio.org", null);
           //相对URI
           URI relative = new URI(null, "/javafaq/index.html", "today");

           URI today = new URI("http", "www.ibiblio.org", "/javafaq/index.html", "today");
           URI today2 = new URI("http", "www.ibiblio.org", "/javafaq/index.html",
                   "referrer=cnet&date=2014-02-23", "today");

           URI styles = new URI("ftp","anonymous:elharo@ibiblio.org","ftp.oreilly",
                   21, "/pub/stylesheet", null, null);
         } catch (URISyntaxException ex) {
            System.err.println(ex);
        }

        //静态工厂方法实例化URI类
        URI styles2 = URI.create(
                "ftp://anonymous:elharo%40ibiblio.org@ftp.oreilly.com:21/pub.stylesheet");
    }
}
