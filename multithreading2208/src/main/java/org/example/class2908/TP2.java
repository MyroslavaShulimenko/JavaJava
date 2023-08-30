package org.example.class2908;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TP2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ERun());
        }

        executorService.shutdown();
        System.out.println("Main End");
    }

}

class ERun2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "=====Start");
        try {
            Thread.sleep(5100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "=====End");

    }
}