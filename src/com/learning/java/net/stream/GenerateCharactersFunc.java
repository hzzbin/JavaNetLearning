package com.learning.java.net.stream;

import java.io.*;

/**
 * Created by binzhang213309 on 2017/11/24.
 */
public class GenerateCharactersFunc {

    public static void  main(String args[]) {
        byte[] input = new byte[1024];
        byte[] data = {1, 2, 4, 8, 16, 32, 64, -128};
        InputStream in = new ByteArrayInputStream(data);

        int bytesRead = 0;
        try {
            bytesRead = in.read(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bytesRead);
    }

    public static void generateCharacters(OutputStream out)
        throws IOException {

        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;

        int start = firstPrintableCharacter;
        while(true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i ++) {
                out.write((
                        (i - firstPrintableCharacter) % numberOfPrintableCharacters)
                + firstPrintableCharacter);
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;
        }

    }

    public static void generateCharacters2(OutputStream out)
        throws IOException {

        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2];

        while(true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) ((i - firstPrintableCharacter)
                        % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte) '\r';
            line[73] = (byte) '\n';
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }


    /**
     *  关闭一个流，使用finally模块,
     *  通常被称为“释放模式”，
    */
    public static void CloseStream() {
        OutputStream out1 = null;
        try {
            out1 = new FileOutputStream("/tmp/data.txt");
            // 处理输出流...
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (out1 != null) {
                try {
                    out1.close();
                } catch (IOException ex) {
                    //忽略
                }
            }
        }

        // Java 7 中引入的“带资源的try” (try with resources)
        // 不需要Finally子句，Java会对try块参数表中声明的所有AutoCloseable对象
        // 自动调用close(); JavaMail Transport对象是例外，还需要显式释放
        try (OutputStream out2 = new FileOutputStream("/tmp/data.txt")) {
            //处理输出流...
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


    /**
     *  输入流 InputStream
     */
    public static void TestInputStream(InputStream in)
        throws IOException {
        byte[] input = new byte[10];
        for(int i = 0; i < input.length; i++) {
            int b = in.read();
            if (b == -1) break;
            input[i] = (byte) b;
        }
    }

    public static void TestInputStream2(InputStream in)
        throws IOException {
        int bytesRead = 0;
        int bytesToRead = 1024;
        byte[] input = new byte[bytesToRead];
        while (bytesRead < bytesToRead) {
            int result = in.read(input, bytesRead, bytesToRead - bytesRead);
            if (result == -1) break; //流结束
            bytesRead += result;
        }

        int bytesAvailable = in.available();
        byte[] input2 = new byte[bytesAvailable];
        int bytesRead2 = in.read(input2, 0, bytesAvailable);
        //立即继续执行程序的其他部分...
    }

    //过滤器流串链在一起
    public static void FilterStreamTest()
        throws IOException {
        FileInputStream fin = new FileInputStream("data.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);

        //第二种流串链写法
        InputStream in = new FileInputStream("data.txt");
        in = new BufferedInputStream(in);

        //第三种流串链写法
        DataOutputStream dout = new DataOutputStream(
                                new BufferedOutputStream(
                                new FileOutputStream("Data.txt")
                                )
        );
    }


















}
