package org.example.task0109;

public class SimpleExchangerExample {
    public static void main(String[] args) {
        SimpleExchanger<String> simpleExchanger = new SimpleExchanger<>();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 printed: " + simpleExchanger.exchange("null"));
        });
        thread1.setName("Ferst");
        thread1.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Thread thread2 = new Thread(() -> {

            System.out.println("Thread 2 printed: " + simpleExchanger.exchange("Msg from thread 2"));
        });
        thread2.setName("Second");
        thread2.start();
    }
}

