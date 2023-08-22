package org.example.class0822;

public class MTE10 {
    static long sum1;
    static long sum2;
    static long sum3;

    public static void main(String[] args) {
        System.out.println();
        SUm1 s1 = new SUm1();
        SUm2 s2 = new SUm2();
        SUm3 s3 = new SUm3();
        s1.start();
        s2.start();
        s3.start();
        try {
            s1.join();
            s2.join();
            s3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long sumSum = sum1 + sum2 + sum3;
        System.out.println("sum= " + sumSum);
    }

    static class SUm1 extends Thread {
        @Override
        public void run() {
            sum1 = 0;
            for (int i = 0; i < 4000; i++) {
                sum1 = sum1 + i;

            }
            System.out.println("sum1 = " + sum1);
        }
    }

    static class SUm2 extends Thread {
        @Override
        public void run() {
            sum2 = 0;
            for (int i = 4000; i < 8000; i++) {
                sum2 = sum2 + i;

            }
            System.out.println("sum2 = " + sum2);
        }
    }

    static class SUm3 extends Thread {
        @Override
        public void run() {
            sum3 = 0;
            for (int i = 8000; i <= 10000; i++) {

                sum3 = sum3 + i;
            }
            System.out.println("sum3 = " + sum3);
        }
    }

}













