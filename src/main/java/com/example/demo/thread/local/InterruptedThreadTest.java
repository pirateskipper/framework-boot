package com.example.demo.thread.local;

/**
 * @author blindskipper
 */
public class InterruptedThreadTest extends Thread{

    public InterruptedThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 3; ++i) {
            System.out.println(true == Thread.interrupted());
            Thread.currentThread().interrupt();
            if (Thread.interrupted()) {
                System.out.println("Is thread" + Thread.currentThread().getName() + " has been interrupted and status is set to " + " " + Thread.interrupted());
            } else {
                System.out.println("This thread has not been interrupted@" + Thread.currentThread().getName() + "@@" + Thread.interrupted());
            }
        }
    }
    public static void main(String args[]) {
        InterruptedThreadTest it1 = new InterruptedThreadTest("it1---");
        InterruptedThreadTest it2 = new InterruptedThreadTest("it2---");

        it2.start();
        it2.interrupt();
        it1.start();
    }
}
