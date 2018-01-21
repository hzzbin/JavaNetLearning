package com.learning.java.net.ServerSocket.config;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by binzhang213309 on 2017/12/21.
 */
public class LocalPortScanner {

    public static void main(String[] args) {

        for (int port = 1; port <= 65535; port++) {
            try {
                ServerSocket server = new ServerSocket(port);
            } catch (IOException ex) {
                System.out.println("There is a server on port " + port + ".");
            }
        }
    }
}
