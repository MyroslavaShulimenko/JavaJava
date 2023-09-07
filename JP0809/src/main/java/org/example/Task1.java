package org.example;

import java.io.File;

public class Task1 {
    //Распределение задач для многопоточной обработки данных. Предположим у вас есть текстовый файл, который
    //            содержит записи в каждой строке. Ваш нужно написать класс, который выглядит так:
    //
    //            public class FileProcessor {
    //
    //                void processFile(File file, Processor processor) {};
    //            }
    //
    //            interface Processor {
    //                void process(String line);
    //            }
    //FileProcessor fileProcessor = new FileProcessor();
    //            fileProcessor.processFile("src/main/resources/emails.txt", (email) -> System.out.println("Send email to " + email));
    //
    //            При этом реализация интерфейса Processor предполагает, что каждая строка может обрабатываться долго.
    //            Предложите решение для организации параллельной обработки строк файла в классе FileProcessor. Помните, что
    //            количество созданных Thread в реальных системах ограничено ресурсами комьютера. Как можно их ограничить?
    //
    //            Напишите тесты для вашего решения.
//    public static void main(String[] args) {
//        FileProcessor fileProcessor = new FileProcessor(3);
//          fileProcessor.processFile("JP0809/src/main/java/org/emails.txt", (email) -> System.out.println("Send email to " + email));
//    }
    public static void main(String[] args) throws Exception {
        try (FileProcessor fileProcessor = new FileProcessor(2)) {
            fileProcessor.processFile(new File("emails.txt"), email -> {
                System.out.println("Send email to from " + Thread.currentThread().getName() + " " + email);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            fileProcessor.processFile(new File("emails.txt"), email -> {
                System.out.println("Send email to from " + Thread.currentThread().getName() + " " + email);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
}
