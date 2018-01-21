package com.learning.java.net.thread.threadpool;

import java.io.File;
import java.util.concurrent.*;

/**
 * Created by binzhang213309 on 2017/11/28.
 */
public class GZipAllFiles {

    public final static int THREAD_COUNT = 4;

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
//        ExecutorService pool = new ThreadPoolExecutor(THREAD_COUNT, THREAD_COUNT,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());

        for (String filename : args) {
            File f = new File(filename);
            if (f.exists()) {
                if (f.isDirectory()) {
                    File[] files = f.listFiles();

                    for (int i = 0; i < files.length; i++) {
                        if (!files[i].isDirectory()) {
                            Runnable task = new GZipRunnable(files[i]);
                            pool.submit(task);
                        }
                    }
                } else {
                    Runnable task = new GZipRunnable(f);
                    pool.submit(task);
                }
            }
        }

        pool.shutdown();
    }
}
