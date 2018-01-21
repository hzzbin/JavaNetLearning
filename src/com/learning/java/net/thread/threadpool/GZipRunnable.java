package com.learning.java.net.thread.threadpool;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class GZipRunnable implements Runnable {

    private final File input;

    public GZipRunnable(File input) {
        this.input = input;
    }

    @Override
    public void run() {
        //不压缩已经压缩的文件
        if (!input.getName().endsWith(".gz")) {
            File output = new File(input.getParent(), input.getName() + ".gz");
            if (!output.exists()) {
                try ( // with resources java 7
                    InputStream in = new BufferedInputStream(new FileInputStream(input));
                    OutputStream out = new BufferedOutputStream(
                            new GZIPOutputStream(
                                    new FileOutputStream(output)));
                ) {
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                    }
                    out.flush();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }
    }
}
