package com.learning.java.net.thread.callback;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by binzhang213309 on 2017/11/26.
 */
public class InstanceCallbackDigest implements Runnable {

    private String filename;

    private InstanceCallbackDigestUserInterface callback;

    public InstanceCallbackDigest(String filename,
                                  InstanceCallbackDigestUserInterface callback) {
        this.filename = filename;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read() != -1) ;
            din.close();
            byte[] digest = sha.digest();
            callback.receiveDigest(digest);
        } catch (IOException | NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }
}
