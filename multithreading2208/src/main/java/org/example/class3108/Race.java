package org.example.class3108;

import java.util.concurrent.CountDownLatch;

/**
 * Вы хотите организовать соревнование, где несколько
 * участников будут стартовать одновременно, как только все они будут готовы.
 * <p>
 * Создайте класс Participant, представляющий участника.
 * Создайте класс Race, который будет организовывать соревнование с использованием CountDownLatch.
 * Реализуйте код, который создает участников и запускает соревнование.
 */
public class Race {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        //CountDownLatch countDownLatch = new CountDownLatch(3);
        new Participant(countDownLatch, "Nik");
        new Participant(countDownLatch, "Mick");
        new Participant(countDownLatch, "Pol");
        Thread.sleep(1000);

        getReadyToStart1();
        getReadyToStart2();
        start();
        System.out.println("Main ended");
    }

    private static void getReadyToStart1() {
        System.out.println("getReadyToStart1 run");
        countDownLatch.countDown();
    }

    private static void getReadyToStart2() {
        System.out.println("getReadyToStart2 run");
        countDownLatch.countDown();
    }

    private static void start() {
        System.out.println("start run");
        countDownLatch.countDown();
    }
}

class Participant extends Thread {
    private CountDownLatch countDownLatch;
    private String name;

    public Participant(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " start ");

            countDownLatch.await();
            Thread.sleep(300);
            System.out.println("Thread " + Thread.currentThread().getName() + " ended " + name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
