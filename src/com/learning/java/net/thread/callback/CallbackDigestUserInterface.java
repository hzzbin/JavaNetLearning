package com.learning.java.net.thread.callback;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by binzhang213309 on 2017/11/26.
 */
public class CallbackDigestUserInterface {

    public static void receiveDigest(byte[] digest, String name) {
        StringBuilder result = new StringBuilder(name);
        result.append(": ");
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
    }

    public static void main(String[] args) {
        for (String filename : args) {
            CallbackDigest cb = new CallbackDigest(filename);
            Thread t = new Thread(cb);
            t.start();
        }
    }
}
