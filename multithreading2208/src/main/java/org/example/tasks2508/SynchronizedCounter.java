public class SynchronizedCounter {

    /*
    // Задача 2:
    // Требуется создать потокобезопасный класс, который отвечает за счётчик с суммой. Предложите две реализации.
    // Методы: increment()/decrement()/getOperationsCount()/getValue()
     */
    private static int sum = 0;
    private int operationCount = 0;

    public synchronized void increment() {
        sum++;
        operationCount++;
    }

    public synchronized void decrement() {
        sum--;
        operationCount++;
    }

    public synchronized int getOperationsCount() {
        return operationCount;
    }

    public synchronized int getValue() {
        return sum;
    }
}

class Tread1 extends Thread {
    SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

    @Override
    public void run() {
        while (Main.flag) {
            synchronizedCounter.increment();
            System.out.println("Counter: " + synchronizedCounter.getOperationsCount() + " | "
                    + "Thread name -> " + Thread.currentThread().getName() + " | " + synchronizedCounter.getValue());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Tread2 extends Thread {
    SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

    @Override
    public void run() {
        while (Main.flag) {
            synchronizedCounter.decrement();
            System.out.println("Counter: " + synchronizedCounter.getOperationsCount() + " | "
                    + "Thread name -> " + Thread.currentThread().getName() + " | " + synchronizedCounter.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Main {
    public static volatile boolean flag = true;

    public static void main(String[] args) {

        Tread1 t1 = new Tread1();
        Tread2 t2 = new Tread2();

        t1.start();
        t2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        flag = false;

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}