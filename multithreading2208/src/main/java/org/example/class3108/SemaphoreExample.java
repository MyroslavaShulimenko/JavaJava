package org.example.class3108;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        new Emp("Olga",semaphore);
        new Emp("Mark",semaphore);
        new Emp("Olga",semaphore);
        new Emp("Roman",semaphore);
        new Emp("Eva",semaphore);
        new Emp("Sara",semaphore);
    }
}
class Emp extends Thread {
    String name;
    private Semaphore semaphore;

    public Emp(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.setName("Tread----   "+name);
        this.start();
    }
    @Override
    public void run(){
        System.out.println("weit  "+name+"    "+Thread.currentThread().getName());
        try {
            semaphore.acquire(2);
            Thread.sleep(3000);
            System.out.println( name+"   is weiting fo...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release(2);
        }
    }
}