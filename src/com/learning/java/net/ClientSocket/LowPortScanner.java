package com.learning.java.net.ClientSocket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2017/12/18.
 */
public class LowPortScanner {

    public static void main(String[] args) {

        String host = args.length > 0 ? args[0] : "localhost";

        for (int i = 1; i < 1024; i++) {
            try {
                Socket s = new Socket(host, i);
                s.setSoTimeout(200);
                System.out.println("There is a TCP Server on port " + i + " of " + host);
                s.close();
            } catch (UnknownHostException ex) {
                System.err.println(ex);
                break;
            } catch (IOException ex) {
                // 这个端口上不支持TCP连接
                //System.out.println("The port " + i + " can not establish TCP connection");
            }
        }
    }
}
