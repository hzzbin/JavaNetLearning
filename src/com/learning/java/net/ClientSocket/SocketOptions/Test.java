package com.learning.java.net.ClientSocket.SocketOptions;

import java.net.Socket;
import java.net.SocketException;

/**
 * Created by binzhang213309 on 2017/12/19.
 */
public class Test {

    public static void main(String[] args) {
        // 对于客户端Socket，Socket的原生socket配置选项如下：
        // TCP_NODELAY
        // SO_BINDADDR
        // SO_TIMEOUT
        // SO_LINGER
        // SO_SNDBUF
        // SO_RCVBUF
        // SO_KEEPALIVE
        // OOBINLINE
        // IP_TOS

        Socket socket = new Socket();
        try {
            // TCP_NODELAY
            // 设置TCP准备好后立即发送出去
            socket.setTcpNoDelay(true);
            // SO_LINGER
            // 设置Socket关闭时对剩余数据的处理
            if (socket.getSoLinger() == -1) { // 返回-1表示选项禁用
                socket.setSoLinger(true, 240);
            }

            // SO_TIMEOUT
            // 设置读取Socket流时的最长阻塞时间，超过最长阻塞时间抛出
            // InterruptedIOException, 但Socket没有关闭，仍然可以读取
            if (socket.getSoTimeout() == 0) { // 默认无限超时
                socket.setSoTimeout(180000);
            }

            // SO_RCVBUF、SO_SNDBUF
            // 设置TCP使用的缓冲区大小
            socket.setSendBufferSize(128*1024);// 128KB
            socket.setReceiveBufferSize(64*1024); // 64KB

            // SO_KEEPALIVE
            // Socket心跳测试（一般两小时一次）
            // 尝试连接的时间11分钟
            if (socket.getKeepAlive()) {
                socket.setKeepAlive(false);
            }

            // OOBINLINE
            // 发送和接受“紧急数据”
            // Java不区分紧急数据和非紧急数据
            if (!socket.getOOBInline()) {
                socket.setOOBInline(true);
            }

            // SO_REUSEADDR
            // 是否允许另一个Socket重用当前Socket的端口号
            socket.setReuseAddress(true);

            // IP_TOS服务类型
            // 服务类型存储在IP首部：名为IP_TOS的8位字段
            socket.setTrafficClass(0xB8); // 10111000

            // 设置连接时间、延迟、带宽三者优先级
            socket.setPerformancePreferences(2,1, 3);

        } catch (SocketException ex) {

        } catch (IllegalArgumentException ex) {

        }
    }
}
