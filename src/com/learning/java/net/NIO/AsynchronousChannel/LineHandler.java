package com.learning.java.net.NIO.AsynchronousChannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.nio.channels.CompletionHandler;
import java.nio.channels.WritableByteChannel;

/**
 * Created by binzhang213309 on 2018/1/14.
 */
public class LineHandler implements CompletionHandler<Integer, ByteBuffer> {

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        buffer.flip();
        WritableByteChannel out = Channels.newChannel(System.out);
        try {
            out.write(buffer);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void failed(Throwable ex, ByteBuffer attachment) {
        System.err.println(ex.getMessage());
    }


    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(74);
        CompletionHandler<Integer, ByteBuffer> handler = new LineHandler();
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        channel.read(buffer, buffer, handler);
    }
}
