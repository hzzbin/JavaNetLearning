package com.learning.java.net.thread.join;

import com.learning.java.net.thread.ReturnDigest;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by binzhang213309 on 2017/11/27.
 */
public class JoinDigestUserInterface {

    public static void main(String[] args) {

        ReturnDigest[] digestThreads = new ReturnDigest[args.length];

        for (int i = 0; i < args.length; i++) {
            digestThreads[i] = new ReturnDigest(args[i]);
            digestThreads[i].start();
        }

        for (int i = 0; i < args.length; i++) {
            try {
                digestThreads[i].join();
                // 现在显示结果
                StringBuffer result = new StringBuffer(args[i]);
                result.append(": ");
                byte[] digest = digestThreads[i].getDigest();
                result.append(DatatypeConverter.printHexBinary(digest));
                System.out.println(result);
            } catch (InterruptedException ex) {
                System.err.println("Thread Interrupted before completion");
            }
        }
    }
}
