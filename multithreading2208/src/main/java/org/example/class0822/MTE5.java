package org.example.class0822;

public class MTE5 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        TR tr=new TR();
//        tr.run();
        tr.setPriority(Thread.MAX_PRIORITY);
        tr.start();
        tr.setName("TREAD TR");
        System.out.println("Name: "+tr.getName());
    }
}
class TR extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("TR : " + i);
        }

    }
}
