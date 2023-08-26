package org.example.tasks2508;

public class Task3 extends Thread {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Another thread");
        });

        t.start();
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Main thread");
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
