package com.learning.java.net.UDP.Application;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by binzhang213309 on 2018/1/20.
 */
public class UDPPoke {

    private int bufferSize; // 单位为字节
    private int timeout; //单位为毫秒
    private InetAddress host;
    private int port;

    public UDPPoke(InetAddress host, int port, int bufferSize, int timeout) {
        this.bufferSize = bufferSize;
        this.host = host;
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("Port out of range");
        }

        this.port = port;
        this.timeout = timeout;
    }

    public UDPPoke(InetAddress host, int port, int bufferSize) {
        this(host, port, bufferSize, 30000);
    }

    public UDPPoke(InetAddress host, int port) {
        this(host, port, 8192, 30000);
    }

    public byte[] poke() {
        try (DatagramSocket socket = new DatagramSocket(0)) {
            DatagramPacket outgoing = new DatagramPacket(new byte[1], 1, host, port);
            socket.connect(host, port);
            socket.setSoTimeout(timeout);
            socket.send(outgoing);
            DatagramPacket incoming = new DatagramPacket(new byte[bufferSize], bufferSize);
            // 下一行阻塞， 知道接收到响应
            socket.receive(incoming);

            int numBytes = incoming.getLength();
            byte[] response = new byte[numBytes];
            System.arraycopy(incoming.getData(), 0, response, 0, numBytes);
            return response;
        } catch (IOException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        InetAddress host;
        int port;
        try {
            host = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
        } catch (RuntimeException | UnknownHostException ex) {
            System.out.println("Usage: java UDPPoke host port");
            return;
        }

        try {
            UDPPoke poker = new UDPPoke(host, port);
            byte[] response = poker.poke();
            if (response == null) {
                System.out.println("No response within allotted time");
                return;
            }
            String result = new String(response, "US-ASCII");
            System.out.println(result);
        } catch (UnsupportedEncodingException ex) {
            // 实际上不会发生
            ex.printStackTrace();
        }
    }
}
