package com.learning.java.net.SecureSocket;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Arrays;

/**
 * Created by binzhang213309 on 2017/12/25.
 */
public class SecureOrderTaker {

    public final static int PORT = 7000;
    public final static String algorithm = "SSL";

    public static void main(String[] args) {
        try {
            SSLContext context = SSLContext.getInstance(algorithm);

            // 参考实现只支持X.509密钥
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

            // Oracle的默认密钥库类型
            KeyStore ks = KeyStore.getInstance("JKS");

            // 由于安全考虑，每个密钥库都必须用口令短语加密
            // 在从磁盘加载前必须提供这个口令。口令短语以char[]
            // 数组形式存储，所以可以很快的从内存中擦除，而不是
            // 等待垃圾回收
            //char[] password = System.console().readPassword();
            char[] password = {'1','2','3','4','5','6'};
            ks.load(new FileInputStream("jnp4e.keys"), password);
            kmf.init(ks, password);
            context.init(kmf.getKeyManagers(), null, null);

            // 擦除口令
            Arrays.fill(password, '0');

            SSLServerSocketFactory factory = context.getServerSocketFactory();

            SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(PORT);

            // 增加匿名（未认证）密码组
            String[] supported = server.getSupportedCipherSuites();
            String[] anonCipherSuitesSupported = new String[supported.length];
            int numAnonCipherSuitesSupported = 0;
            for (int i = 0; i < supported.length; i++) {
                if (supported[i].indexOf("_anon_") > 0) {
                    anonCipherSuitesSupported[numAnonCipherSuitesSupported++] = supported[i];
                }
            }

            String[] oldEnabled = server.getEnabledCipherSuites();
            String[] newEnabled = new String[oldEnabled.length + numAnonCipherSuitesSupported];
            System.arraycopy(oldEnabled, 0, newEnabled, 0, oldEnabled.length);
            System.arraycopy(anonCipherSuitesSupported, 0, newEnabled, oldEnabled.length, numAnonCipherSuitesSupported);

            server.setEnabledCipherSuites(newEnabled);

            while (true) {
                try (Socket theConnection = server.accept()) {
                    InputStream in = theConnection.getInputStream();
                    int c;
                    while ((c = in.read()) != -1) {
                        System.out.write(c);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException
                | CertificateException | UnrecoverableKeyException ex) {
            ex.printStackTrace();
        }

    }
}
