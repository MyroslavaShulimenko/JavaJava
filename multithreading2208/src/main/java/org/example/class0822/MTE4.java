package org.example.class0822;

public class MTE4 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Run1 : " + i);
            }
        }).start();
    }
}
