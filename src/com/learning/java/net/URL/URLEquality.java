package com.learning.java.net.URL;

import javax.xml.bind.DatatypeConverter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2017/12/1.
 */
public class URLEquality {

    public static void main(String[] args) {
        try{
            URL www = new URL("http://www.ibiblio.org/");
            URL ibiblio = new URL("http://ibiblio.org/");
            InetAddress a1 = InetAddress.getByName("www.ibiblio.org");
            InetAddress a2 = InetAddress.getByName("ibiblio.org");

            System.out.println(www + " ip:" + a1.getHostAddress());
            System.out.println(ibiblio + " ip:" + a2.getHostAddress());

            if (ibiblio.equals(www)) {
                System.out.println(ibiblio + " is the same as " + www);
            } else {
                System.out.println(ibiblio + " is not the same as " + www);
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        }
    }

}
