package com.learning.java.net.URI;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by binzhang213309 on 2017/12/2.
 */
public class ResolveURI {

    public static void main(String[] args)
    throws URISyntaxException {

        URI absolute = new URI("http://www.example.com/");
        URI relative = new URI("//images/logo.png");
        URI relative2 = new URI("images/logo.png");
        URI resolved = absolute.resolve(relative);

        //System.out.println(resolved);

        URI absolute2 = new URI("http://www.example.com/images/logo.png");
        URI top = new URI("http://www.example2.com/");
        URI relative3 = top.relativize(absolute2);

        System.out.println(relative3);

    }
}
