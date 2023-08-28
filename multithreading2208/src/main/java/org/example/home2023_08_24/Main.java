package org.example.home2023_08_24;

public class Main {
    public static void main(String[] args) {
            Warehouse warehouse = new Warehouse(8, 0);
            Producer producer = new Producer(warehouse);
            Consumer consumer = new Consumer(warehouse);

            Thread threadProducer = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
                producer.produceItems(20);
            });
            Thread threadConsumer = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
                consumer.consumeItems(15);
            });

            threadProducer.start();
            threadConsumer.start();
        }
    }

