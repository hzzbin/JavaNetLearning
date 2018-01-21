package com.learning.java.net.NetworkInterface;

import java.net.InetAddress;
import java.util.concurrent.Callable;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class LookupTask implements Callable<String> {

    private String line;

    public LookupTask(String line) {
        this.line = line;
    }

    @Override
    public String call() {
        try {
            // 分解IP地址
            int index = line.indexOf(' ');
            String address = line.substring(0, index);
            String theRest = line.substring(index);
            String hostname = InetAddress.getByName(address).getHostName();
            return hostname + " " + theRest;
        } catch (Exception ex) {
            return line;
        }
    }
}
