package com.learning.java.net.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by binzhang213309 on 2018/1/17.
 */
public class UDPDiscardClient {

    public final static int PORT = 9;

    public static void main(String[] args) {

        String hostname = args.length > 0 ? args[0] : "localhost";

        try (DatagramSocket theSocket = new DatagramSocket();DatagramSocket reSocket = new DatagramSocket(PORT)) {
            InetAddress server = InetAddress.getByName(hostname);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            Thread reThread = new ReceiveThread(reSocket);
            reThread.start();

            while (true) {
                String theLine = userInput.readLine();
                System.out.println("Input:" + theLine);
                if (theLine.equals(".")) {
                    break;
                }
                byte[] data = theLine.getBytes();
                DatagramPacket theOutput = new DatagramPacket(data, data.length, server, PORT);
                theSocket.send(theOutput);

            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static class ReceiveThread extends Thread {
        private DatagramSocket socket;
        private byte[] receBuffer;
        private DatagramPacket input;

        ReceiveThread(DatagramSocket socket) {
            this.socket = socket;
            this.receBuffer = new byte[7];
            this.input = new DatagramPacket(receBuffer, receBuffer.length);
        }

        @Override
        public void run() {
            if (socket != null) {
                System.out.println("Receiving thread is running......");
                try {
                    socket.setSoTimeout(100000);
                    while (true) {
                        socket.receive(input);
                        System.out.println("Receiving-->" + new String(input.getData(), input.getOffset(), input.getLength()));
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
