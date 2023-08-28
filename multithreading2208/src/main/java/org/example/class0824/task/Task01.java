package org.example.class0824.task;

//Этот класс будет создавать потоки и организовывать взаимодействие между ними.
//
//В методе main создайте экземпляры классов Sender и Receiver.
//
//Создайте три потока:
//Первый поток (senderThread), который будет вызывать методы sendData и receiveData
//для отправки данных от отправителя к получателю.
//Второй поток (receiverThread), аналогично первому, отправляющий данные от
//отправителя к получателю.
//Третий поток (mainThread), который будет вызывать метод getReceivedData
//получателя и выводить принятые данные в главный поток.
//Запустите все три потока.
//Требования:
//
//Используйте ключевое слово volatile для обеспечения видимости данных между потоками.
//Используйте блоки synchronized для синхронизации выполнения методов в классах.
//Потоки должны быть корректно организованы и синхронизированы,
//чтобы данные правильно передавались от отправителя к получателю и обратно.
//Вывод данных должен быть четким и понятным, чтобы можно было отслеживать взаимодействие потоков.
public class Task01 {

    static Receiver receiver = new Receiver();
    static Sender sender = new Sender();
    static volatile int rez = 0;


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 30; i++) {
                sender.sendData(i);
                receiver.receiveData(sender.getDataToSend());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 30; i++) {
                sender.sendData(i);
                receiver.receiveData(sender.getDataToSend());}
        });

                Thread thread3 = new Thread(() -> {
                    for (int i = 0; i < 30; i++) {
                        System.out.println(Thread.currentThread().getName()
                                + " | Received : " + receiver.getReceivedData());}
                });


                        thread1.start();
                        thread2.start();
                        thread3.start();

                        try {
                            thread2.join();
                            thread3.join();
                            thread1.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }


                    }

//                    class S1 implements Runnable {
//
//                        @Override
//                        public void run() {
//                            for (int i = 1; i <= 5; i++) {
//                                sender.sendData(i);
//                                receiver.receiveData(sender.getDataToSend());
//                            }
//
//                        }
//
//                    }
//
//                    class R1 implements Runnable {
//                        @Override
//                        public void run() {
//                            for (int i = 1; i <= 3; i++) {
//                                sender.sendData(i);
//                                receiver.receiveData(sender.getDataToSend());
//                            }
//
//                        }
//                    }
//
//                     class T1 implements Runnable {
//                        @Override
//                        public void run() {
//
//                            System.out.println("T1main: " + receiver.getReceivedData());
//                        }
//
//                    }
//
                }

