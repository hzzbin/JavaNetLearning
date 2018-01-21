package com.learning.java.net.thread.objwait;

import java.io.InputStream;

/**
 * Created by binzhang213309 on 2017/11/27.
 */
public class OneThread  extends Thread {
    private InputStream in;

    @Override
    public void run() {
        ManifestFile m = new ManifestFile();
        JarThread t = new JarThread(m, in);

        synchronized (m) {
            t.start();
            try {
                m.wait();
                //处理清单文件。。。
            } catch (InterruptedException ex) {
                //处理异常。。。
            }
        }
    }
}
