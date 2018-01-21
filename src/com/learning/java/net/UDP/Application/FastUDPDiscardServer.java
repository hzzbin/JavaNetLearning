package com.learning.java.net.UDP.Application;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by binzhang213309 on 2018/1/21.
 */
public class FastUDPDiscardServer extends UDPServer {

    public final static int DEFAULT_PORT = 9;

    public FastUDPDiscardServer() {
        super(DEFAULT_PORT);
    }

    public static void main(String[] args) {
        UDPServer server = new FastUDPDiscardServer();
        Thread t =new Thread(server);
        t.start();
    }

    @Override
    public void respond(DatagramSocket socket, DatagramPacket request) {

    }
}
