package com.learning.java.net.UDP.DatagramChannel;

import java.io.IOException;
import java.net.SocketOption;
import java.nio.channels.DatagramChannel;

/**
 * Created by binzhang213309 on 2018/1/21.
 */
public class DefaultSocketOptionValues {

    public static void main(String[] args) {
        try (DatagramChannel channel = DatagramChannel.open()) {
            for (SocketOption<?> option : channel.supportedOptions()) {
                System.out.println(option.name() + ": " + channel.getOption(option));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
