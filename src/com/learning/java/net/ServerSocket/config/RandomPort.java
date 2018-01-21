package com.learning.java.net.ServerSocket.config;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by binzhang213309 on 2017/12/21.
 */
public class RandomPort {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(0);
            System.out.println("This server runs on port " + server.getLocalPort());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
