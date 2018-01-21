package com.learning.java.net.thread.join;

/**
 * Created by binzhang213309 on 2017/11/27.
 */
public class ThreadJoin {

    double[] array = new double[10000];

    public ThreadJoin() {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
    }
    public void getMinMedMaxNum() {
        SortThread t = new SortThread(array);
        t.start();
        try {
            t.join();
            System.out.println("Minimum: " + array[0]);
            System.out.println("Median: " + array[array.length/2]);
            System.out.println("Maximum: " + array[array.length-1]);
        } catch (InterruptedException ex) {

        }
    }

}
