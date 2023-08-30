package org.example.class2908;

public class DE {
    public static void main(String[] args) {

    }
}
class UT extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"  isDaemon() - "+isDaemon());
        for (char i = 'A'; i < 'Z'; i++) {
            try {
                Thread.sleep(600);
                System.out.println("i= "+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
        }
class DT extends Thread {


    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"  isDaemon() - "+isDaemon());
        for (char i = 'A'; i < 'Z'; i++) {
            try {
                Thread.sleep(600);
                System.out.println("i= "+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}