package com.learning.java.net.UDP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * Created by binzhang213309 on 2018/1/16.
 */
public class DatagramExample {

    public static void main(String[] args) {
        String s = "This is a test.";

        try {
            byte[] data = s.getBytes("UTF-8");
            InetAddress ia = InetAddress.getByName("www.ibiblio.org");
            int port = 7;
            DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
            System.out.println("This packet is addressed to "
            + dp.getAddress() + " on port " + dp.getPort());
            System.out.println("There are " + dp.getLength()
            + " bytes of data in the packet");
            System.out.println(
                    new String(dp.getData(), dp.getOffset(), dp.getLength(), "UTF-8"));
        } catch (UnknownHostException | UnsupportedEncodingException ex) {
            System.err.println(ex);
        }

        // 发送大数组，一个包放不下的
        // 可以重用DatagramPacket对象
        int offset = 0;
        byte[] bigarray = new byte[2018];
        DatagramPacket dp = new DatagramPacket(bigarray, offset, 512);
        int bytesSent = 0;
        try (DatagramSocket socket = new DatagramSocket(0)) {
            while (bytesSent < bigarray.length) {
                socket.send(dp);
                bytesSent += dp.getLength();
                int bytesToSend = bigarray.length - bytesSent;
                int size = (bytesToSend > 512) ? 512 : bytesToSend;
                dp.setData(bigarray, bytesSent, size);
            }
        } catch (IOException ex) {

        }

        // setAddress()
        try (DatagramSocket socket = new DatagramSocket(0)) {

            String ss = "Really Important Message";
            byte[] data = ss.getBytes("UTF-8");
            DatagramPacket dp2 = new DatagramPacket(data, data.length);
            dp2.setPort(2000);
            String network = "128.238.5.";
            for (int host = 1; host < 255; host++) {
                try {
                    InetAddress remote = InetAddress.getByName(network + host);
                    dp2.setAddress(remote);
                    socket.send(dp);
                } catch (IOException ex) {
                    // 忽略，继续处理
                }
            }
        } catch (SocketException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
}
