package com.example.demo.thread.local;

/**
 * @author blindskipper
 */
public class IsInterruptedThreadTest extends Thread {


    public IsInterruptedThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 3; ++i) {

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Is the thread @:" + Thread.currentThread().getName() + "has been interrupted: " +  Thread.currentThread().isInterrupted());
            } else {
                System.out.println("Is the thread #:" + Thread.currentThread().getName() + "has been interrupted: " +  Thread.currentThread().isInterrupted());
            }
        }
    }
    public static void main(String args[]) {
        IsInterruptedThreadTest it1 = new IsInterruptedThreadTest("it1---");
        IsInterruptedThreadTest it2 = new IsInterruptedThreadTest("it2---");

        it2.start();
        it2.interrupt();
        it1.start();
    }
}
