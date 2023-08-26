package org.example.tasks2508;
// Требуется создать потокобезопасный класс, который отвечает за счётчик с суммой. Предложите две реализации.
// Методы: increment()/decrement()/getOperationsCount()/getValue()

import static org.example.tasks2508.Main.f1;

public class T2 {
    private int count = 0;
    private int sum = 0;


    public synchronized void increment() {
        sum++;
        count++;
    }

    public synchronized void decrement() {
        sum--;
        count++;
    }

    public synchronized int getOperationCount() {
        return count;
    }

    public synchronized int getValue() {
        return sum;
    }

}

class Tread1 extends Thread {
    T2 t1 = new T2();

    @Override
    public void run() {
        int counter = 1;
        while (f1) {
            t1.increment();
            System.out.println("Thread sleep " + t1.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class Tread2 extends Thread {
    T2 t1 = new T2();

    @Override
    public void run() {
        int counter = 1;
        while (f1) {
            t1.decrement();
            System.out.println("Thread sleep " + t1.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class Main {
    static boolean f1 = true;

    public static void main(String[] args) {
        Tread1 tread1 = new Tread1();
        Tread2 tread2 = new Tread2();
        tread1.start();
        tread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        f1 = false;
    }


}