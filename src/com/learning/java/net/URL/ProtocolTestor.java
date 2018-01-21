package com.learning.java.net.URL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by binzhang213309 on 2017/11/29.
 */
public class ProtocolTestor {

    public static void main(String[] args) {

        // http
        testProtocol("http://www.adc.org");

        // https
        testProtocol("https://www.amazon.com/exec/obidos/order2/");

        // ftp
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");

        // 简单邮件传输协议
        testProtocol("mailto:elharo@ibiblio.org");

        // telnet
        testProtocol("telnet://dibner.poly.edu/");

        // file
        testProtocol("file:///etc/passwd");

        // gopher
        testProtocol("gopher://gopher.anc.org.za/");

        // 轻量组目录访问协议
        testProtocol("ldap://ldap.itd.umich,edu/o=University%20of%20Michigan,c=US?postalAddress");

        // JAR
        testProtocol(
                "jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
                + "/com/macfaq/io/StreamCopier.class");

        // NFS, 网络文件系统
        testProtocol("nfs://utopia.poly.edu/usr/tmp/");

        // JDBC的定制协议
        testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");

        // rmi,远程方法调用的定制协议
        testProtocol("rmi://ibiblio.org/RenderEngine");

        // HotJava的定制协议
        testProtocol("doc:/UsersGuide/release.html");
        testProtocol("netdoc:/UsersGuide/release.html");
        testProtocol("systemresource://www.adc.org/+/index.html");
        testProtocol("verbatim:http://www.adc.org/");

        try {
            URL u = new URL("http", "www.eff.org", "/blueribbon.html#intro");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("shouldn't happen; all VMs recognize http");
        }

        try {
            URL u = new URL("http", "fourier.dur.ac.uk", 8000,"/~dma3mjh/jsci/");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("shouldn't happen; all VMs recognize http");
        }

        try {
            URL u1= new URL("http://www.ibiblio.org/javafaq/index.html");
            URL u2= new URL(u1, "mailinglists.html");
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }

    }

    public static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException ex) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }
}
