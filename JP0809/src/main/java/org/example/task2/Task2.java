package org.example.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

//Задача 2.
//
//     Вам требуется спроектировать класс, который занимается запуском задач для определенных типов данных.
//
//     TypeProcessor typeProcessor = new TypeProcessor();
//
//     typeProcessor.configureProcess(Car.class, car -> {
//        System.out.println(car);
//     });
//
//     typeProcessor.configureProcess(Dog.class, dog -> {
//        System.out.println(dog);
//     });
//
//     Dog dog = new Dog();
//
//     Future<Void> taskResult = typeProccssor.runProcessAsync(dog); // запускает задачу асинхронно
//     Future<Void> taskResult = typeProccssor.runProcessAsync(dog2); // запускает задачу асинхронно
//
//     taskResult.get();
//
//
//     Car car = new Car();
//     typeProcessor.rynProcessSync(car); // запускает задачу в текущем потоке
//     **/
public class Task2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TypeProcessor typeProcessor = new TypeProcessor(2);

        typeProcessor.configureProcess(Car.class, car -> {
            System.out.println("car = " + Thread.currentThread().getName() + " " + car);
        });

        typeProcessor.configureProcess(Dog.class, dog -> {
            System.out.println("dog = " + Thread.currentThread().getName() + " " + dog);
            //throw new RuntimeException();
        });

        Dog dog = new Dog();
        Car car = new Car();

        Future<Void> taskResult = typeProcessor.runProcessAsync(dog); // запускает задачу асинхронно

        taskResult.get();

        typeProcessor.runSync(car); // запускает задачу в текущем потоке*/

        typeProcessor.serviceShutdown();
        Thread.sleep(2000);
    }
}
    class TypeProcessor {
        private final Map<Class<?>, Consumer<?>> consumerMap = new HashMap<>();
        private final ExecutorService service;

        public TypeProcessor(int numberOfThreads) {
            service = Executors.newFixedThreadPool(numberOfThreads);
        }
        public <T> void configureProcess(Class<T> cls, Consumer<T> consumer) {
            consumerMap.put(cls, consumer);
        }

        public Future<Void> runProcessAsync(Object o) {
            return (Future<Void>) service.submit(() -> {
                runSync(o);
            });
        }

        public void runSync(Object o) {
            Consumer<Object> consumer = (Consumer<Object>) consumerMap.get(o.getClass());
            consumer.accept(o);
        }

        public void serviceShutdown() {
            service.shutdown();
        }
    }

