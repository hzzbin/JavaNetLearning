package com.learning.java.net.ClientSocket;

import java.net.Socket;

/**
 * Created by binzhang213309 on 2017/12/19.
 */
public class IsConnected {

    public static void main(String[] args) {
        Socket s = new Socket();

        // 要查看一个Socket当前是否打开，需要同时检查isConnected和isClosed
        // 检测打开状态
        boolean connected = s.isConnected() && ! s.isClosed();

        // isBound()检测当前Socket是否成功绑定到本地系统的某个出站端口。
        boolean isBound = s.isBound();
    }
}
