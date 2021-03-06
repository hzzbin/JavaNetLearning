package com.learning.java.net.thread.excutor;

import java.util.concurrent.*;

/**
 * Created by binzhang213309 on 2017/11/26.
 */
public class MultithreadedMaxFinder {

    public static int max(int[] data) throws InterruptedException, ExecutionException {

        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        //将任务分解为两部分
        FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
        FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);

        //创建两个线程
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        return Math.max(future1.get(), future2.get());
    }
}
