package com.learning.java.net.thread.objwait;

import java.io.InputStream;

/**
 * Created by binzhang213309 on 2017/11/27.
 */
public class JarThread extends Thread {

    private ManifestFile m;
    private InputStream in;

    public JarThread(ManifestFile m, InputStream in) {
        this.m = m;
        this.in = in;
    }

    @Override
    public void run() {
        synchronized (m) {
            // 从流in读入清单文件
            m.notify();
        }
        // 读取流的其余部分。。。
    }
}
