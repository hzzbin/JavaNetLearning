package com.learning.java.net.HTTP;

import java.net.*;

/**
 * Created by binzhang213309 on 2017/12/12.
 */
public class NoGovermentCookies implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        //拒绝接受域名或域后缀为.gov的服务器发来的cookie
        if (uri.getAuthority().toLowerCase().endsWith(".gov")
                || cookie.getDomain().toLowerCase().endsWith(".gov")) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        //安装CookieManager, 实现自动存储和发送cookie
        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(new NoGovermentCookies());
        CookieHandler.setDefault(manager);
    }
}
