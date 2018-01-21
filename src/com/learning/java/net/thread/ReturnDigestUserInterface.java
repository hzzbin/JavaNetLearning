package com.learning.java.net.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by binzhang213309 on 2017/11/25.
 */
public class ReturnDigestUserInterface {

    public static void main(String[] args) {
        for (String filename : args) {
            //计算摘要
            ReturnDigest dr = new ReturnDigest(filename);
            dr.start();

            // 现在显示结果
            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            byte[] digest = dr.getDigest();
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        }
    }
}
