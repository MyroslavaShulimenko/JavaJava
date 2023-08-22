package org.example.class0822;

public class Sums {
    public static class SumTask implements Runnable {
        private int start;
        private int stop;

        private int sum;

        public SumTask(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public void run() {
            for (int i = start; i <= stop; i++) {
                sum += i;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SumTask task0 = new SumTask(0, 2500);
        SumTask task1 = new SumTask(2501, 5000);
        SumTask task2 = new SumTask(5001, 7500);
        SumTask task3 = new SumTask(7501, 10000);

        Thread thread0 = new Thread(task0);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(task0.sum + task1.sum + task2.sum + task3.sum);
        System.out.println((10000 * 10001) / 2);
    }
}
