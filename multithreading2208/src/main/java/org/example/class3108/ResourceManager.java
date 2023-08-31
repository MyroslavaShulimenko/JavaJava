package org.example.class3108;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Вы хотите ограничить количество потоков, которые могут одновременно
 * достучаться к определенному ресурсу (например, к базе данных).
 *
 * Создайте класс Resource (ресурс), представляющий некоторый общий ресурс, к которому потоки должны получать доступ.
 * Создайте класс ResourceManager, который будет ограничивать доступ к ресурсу с использованием Semaphore.
 * Реализуйте код, который запускает несколько потоков, пытающихся получить доступ к ресурсу.
 */
public class ResourceManager {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Resource resource = new Resource();
        resource.setBd(List.of("aaa", "vvv", "ggg"));
        new ReaderBd("Reader1", semaphore, resource);
        new ReaderBd("Reader2", semaphore, resource);
        new ReaderBd("Reader3", semaphore, resource);
        new ReaderBd("Reader4", semaphore, resource);
        new ReaderBd("Reader5", semaphore, resource);
        new ReaderBd("Reader6", semaphore, resource);

    }
}
class Resource {
    private List<String> bd = new ArrayList<>();

    public void setBd(List<String> bd) {
        this.bd = bd;
    }

    public List<String> getBd() {
        return bd;
    }
}
class ReaderBd extends Thread{
    private String id;
    private Semaphore semaphore;
    private Resource resource;

    public ReaderBd(String id, Semaphore semaphore, Resource resource) {
        this.id = id;
        this.semaphore = semaphore;
        this.start();
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (String s : resource.getBd()) {
                System.out.println(s + " id of Thread " + id);
                Thread.sleep(1000);
            }
            System.out.println(id + " ended");

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
