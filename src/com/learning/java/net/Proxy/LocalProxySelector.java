package com.learning.java.net.Proxy;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by binzhang213309 on 2017/12/4.
 */
public class LocalProxySelector extends ProxySelector {

    private List<URI> failed = new ArrayList<URI>();

    @Override
    public List<Proxy> select(URI uri) {

        List<Proxy> result = new ArrayList<Proxy>();
        if (failed.contains(uri) || !"http".equalsIgnoreCase(uri.getScheme())) {
            result.add(Proxy.NO_PROXY);
        } else {
            SocketAddress proxyAddress = new InetSocketAddress("proxy.example.com", 8000);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
            result.add(proxy);
        }

        return result;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress address, IOException ex) {
        failed.add(uri);
    }


    public static void main(String[] args) {
        ProxySelector selector = new LocalProxySelector();
        ProxySelector.setDefault(selector);
    }

}
