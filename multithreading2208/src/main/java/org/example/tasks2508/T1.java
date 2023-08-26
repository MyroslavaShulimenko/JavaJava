package org.example.tasks2508;
// Задача 1:
// Требуется создать поток, который будет писать сообщение на экран раз в секунду.
// Поток Main должен стартануть этот поток, подождать 10 секунд, остановить созданный поток и подождать пока
// он завершится.

// * напишите тест, чтобы проверить работу этой задачи.

// Задача 2:
// Требуется создать потокобезопасный класс, который отвечает за счётчик с суммой. Предложите две реализации.
// Методы: increment()/decrement()/getOperationsCount()/getValue()

// Задача 3:
// Рассмотрим такой код:
// Thread t = new Thread(() -> {
//     System.out.println("Another thread");
// });

// t.start(); до start тоже ничего нельзя писать
// System.out.println("Main thread");
// t.join();

// Как можно его изменить таким образом, чтобы гарантированно выводить сообщение на печать из потока до того,
// как будет напечатано сообщение из Main треда? Операцию "t.join()" нельзя переносить куда-либо.
public class T1 extends Thread {
    private static boolean f1 = true;
    public static void main(String[] args) {
        T1 t1=new T1();
        t1.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        f1=false;
//        t1.interrupt();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        int counter = 1;
        while (f1) {
            System.out.println("Thread sleep " + counter++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
