package com.example.demo.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author blindskipper
 */
public class PipedInputStreamTest {

    public static void main(String[] args) throws IOException {
        Sender sender=new Sender();
        PipedOutputStream out=sender.getOut();

        Receiver0 receiver = new Receiver0();
        Receiver1 receiver1 = new Receiver1();

        PipedInputStream in = receiver.getIn();
        PipedInputStream in1 = receiver1.getIn();

        in.connect(out);

        /**
         * Already connected
         */
        in1.connect(out);

        new Thread(sender,"sender").start();
        new Thread(receiver,"receiver").start();
    }

    static class Receiver0 implements Runnable{

        private PipedInputStream in = new PipedInputStream();

        @Override
        public void run() {
            readMessageOnce();
        }

        public void readMessageOnce() {
            byte[] bytes = new byte[2048];
            try {
                int len = in.read(bytes);
                System.out.printf("%s --receive this message: %s \n", Thread.currentThread().getName(), new String(bytes, 0, len));
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public PipedInputStream getIn() {
            return in;
        }
    }

    static class Receiver1 implements Runnable{

        private PipedInputStream in = new PipedInputStream();

        @Override
        public void run() {
            readMessageOnce();
        }

        public void readMessageOnce() {
            byte[] bytes = new byte[2048];
            try {
                int len = in.read(bytes);
                System.out.printf("%s --receive this message: %s \n", Thread.currentThread().getName(), new String(bytes, 0, len));
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public PipedInputStream getIn() {
            return in;
        }
    }

    static class Sender implements Runnable {

        private PipedOutputStream out = new PipedOutputStream();

        @Override
        public void run() {
            writeLongMessage();
        }

        public PipedOutputStream getOut() {
            return out;
        }

        public void writeLongMessage() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 102; i++) {
                sb.append("0123456789");
            }
            sb.append("abcdefghijklmnopqrstuvwxyz");
            String str = "sb.toString()";
            try {
                out.write(str.getBytes(StandardCharsets.UTF_8));
                out.close();
            } catch (IOException e) {

            }
        }
    }
}
