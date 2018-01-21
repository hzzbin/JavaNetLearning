package com.learning.java.net.thread.objwait;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by binzhang213309 on 2017/11/27.
 */
public class MultiThreads {

    private List<String> entries;

    private Thread[] threads;

    public void processEntry() {
        synchronized (entries) { //必须对等待的对象同步
            while (entries.isEmpty()) {
                try {
                    entries.wait();
                    //停止等待，因为entries.size()变为非零
                    //但是我们不知道它仍然是非零，
                    //所以在此通过循环检查他现在的状态
                } catch (InterruptedException ex) {
                    // 如果被中断，则最后一项已经处理过，所以返回
                    return;
                }
            }
            String entry = entries.remove(entries.size() -1);
            //处理这一项。。。
        }
    }

    public void readLogFile() {
        while (true) {
            //String entry = log.getNextEntry();
            String entry = "";
            if (entry == null) {
                //没有跟多项要添加到列表，
                //所以中断所有扔在等待的线程
                //否则，他们将永远等待下去
                for (Thread thread : threads) {
                    thread.interrupt();
                }
                break;
            }
            synchronized (entries) {
                entries.add(0, entry);
                entries.notifyAll();
            }
        }
    }
}
