package org.example.class3108;

import java.util.concurrent.CountDownLatch;

public class CDL {
    //CountDownLatch - любое ол-во потоков будет ждать пока не выполнится определенное колво операций
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void doService() {
        try {
            Thread.sleep(444);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Everything cleand up (1)");
        countDownLatch.countDown();
        System.out.println("CDL = " + countDownLatch.getCount());
    }

    private static void chekSMTH() {
        try {
            Thread.sleep(444);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Everything cleand up (2)");
        countDownLatch.countDown();
        System.out.println("CDL = " + countDownLatch.getCount());
    }

    private static void getReady() {
        try {
            Thread.sleep(444);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Everything cleand up (3)");
        countDownLatch.countDown();
        System.out.println("CDL = " + countDownLatch.getCount());
    }

    public static void main(String[] args) {
new Employee("Mark",countDownLatch);
new Employee("Olga",countDownLatch);
new Employee("Ivan",countDownLatch);
new Employee("Eva",countDownLatch);
new Employee("John",countDownLatch);
doService();
chekSMTH();
getReady();
    }
}

class Employee extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Employee(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + "     start to work.....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}