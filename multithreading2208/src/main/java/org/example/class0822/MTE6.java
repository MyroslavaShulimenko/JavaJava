package org.example.class0822;

public class MTE6 implements Runnable {
    public static void main(String[] args) {
       Thread thread=new Thread(new  MTE6());
       thread.start();
        System.out.println("run().Tre name:" +Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run().Tre name:" +Thread.currentThread().getName());
    }
}
