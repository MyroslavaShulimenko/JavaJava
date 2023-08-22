package org.example.class0822;

public class MTE8 {
    public static void main(String[] args) {
        System.out.println("main start");
   //     System.out.println(""+Thread.currentThread().getState());
        Thread t1=new Thread(new R1());
        System.out.println("T1:"+t1.getState());

        Thread t2=new Thread(new R2());
        System.out.println("T2:" + t2.getState());
       t1.start();
        System.out.println("T1:"+t1.getState());
 //       System.out.println(Thread.currentThread().getState());
        t2.start();
        System.out.println("T2:" + t2.getState());
        try {
         //   t1.join();
            System.out.println("T1:"+t1.getState());
            System.out.println(Thread.currentThread().getState());
            t2.join();
            System.out.println("T2:" + t2.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main end");
        System.out.println(""+Thread.currentThread().getState());
    }
}
class R1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("R1 : " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("R1 end +++++++++++++++++++++++++++++");
    }
}
class R2 implements Runnable {
    @Override
    public void run() {
        for (int i = 30; i >0; i--) {
            System.out.println("R2 : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
