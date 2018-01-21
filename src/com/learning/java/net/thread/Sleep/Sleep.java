package com.learning.java.net.thread.Sleep;

/**
 * Created by binzhang213309 on 2017/11/27.
 */
public class Sleep {
    //依赖计算机实际计时器的精度（毫秒、微妙）,实际的睡眠时间可能有偏差
    //public static void sleep(long milliseconds) throws InterruptedException
    //public static void sleep(long milliseconds, int nanoseconds) throws InterruptedException

    public void run() {
        while (true) {
            if (!getPage("http://www.ibiblio.org/")) {
                mailError("wenmaster@ibiblio.org");
            }
            try {
                Thread.sleep(300000);
            } catch (InterruptedException ex) {
                break;
            }

        }
    }

    public boolean getPage(String url) {
        return false;
    }

    public void mailError(String mail) {

    }
}
