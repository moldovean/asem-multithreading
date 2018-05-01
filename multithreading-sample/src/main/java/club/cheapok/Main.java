package club.cheapok;

import java.util.Arrays;

public class Main {
    public static final Object harness = new Object();
    public static volatile int counter = 0;


    public static int[][] matrix = new int[][]{
            {0, 0, 0, 0, 0, 0},
            {0, 2, 2, 1, 0, 0},
            {0, 1, 2, 5, 2, 0},
            {0, 6, 5, 9, 1, 0},
            {0, 1, 1, 0, 4, 0},
            {0, 5, 4, 8, 9, 0},
            {0, 0, 0, 0, 0, 0}
    };

    public static void main(String[] args) throws InterruptedException {
        Thread workingHorse;
        for (int iter=0; iter<3; iter++) {
            for (int i = 1; i < 6; i++) {
                workingHorse = new MyThread(i);
                workingHorse.start();
            }
            while (counter < 5) {
                Thread.sleep(10);
            }

            while (counter>0) {
                System.out.println("Releasing the next thread");
                synchronized (harness) {
                    harness.notify();
                }
                counter--;
                Thread.sleep(1000);
            }

            Thread.sleep(10);
            System.out.println(Arrays.deepToString(matrix));
        }
    }
}
