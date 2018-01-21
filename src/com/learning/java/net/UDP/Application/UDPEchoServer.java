package com.learning.java.net.UDP.Application;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by binzhang213309 on 2018/1/21.
 */
public class UDPEchoServer extends UDPServer {

    public final static int DEFAULT_PORT = 7;

    public UDPEchoServer() {
        super(DEFAULT_PORT);
    }

    @Override
    public void respond(DatagramSocket socket, DatagramPacket packet)
        throws IOException {
        DatagramPacket outgoing = new DatagramPacket(packet.getData(),
                packet.getLength(), packet.getAddress(), packet.getPort());
        socket.send(outgoing);
    }

    public static void main(String[] args) {
        UDPServer server = new UDPEchoServer();
        Thread t = new Thread(server);
        t.start();
    }
}
