package org.example.class2908;

public class Inter {
    public static void main(String[] args) {
        System.out.println("Main Start");
        ITread tread = new ITread();

        tread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        tread.interrupt();
        try {
            tread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main End");

    }
}

class ITread extends Thread {
    double d = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("isInterrupted()   "+isInterrupted()+" i= "+i);
            if (isInterrupted()){
                System.out.println("The Tread stopted" + "33"+isInterrupted());
               return;
            }
            d += Math.sqrt(i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(isInterrupted() );
                System.out.println("Tread end i =  "+i+"     " +d);
                interrupt();
            }
        }
        System.out.println("  = "+d);
    }
}