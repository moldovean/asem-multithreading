package club.cheapok;

import static club.cheapok.Main.counter;
import static club.cheapok.Main.matrix;

public class MyThread extends Thread {
    private int row;

    public MyThread(final int row) {
        this.row = row;
    }

    @Override
    public void run() {
        System.out.println("I am number: "+(row));
        int[] matrix = Main.matrix[row];
        int[] matrixNew = new int[matrix.length];
        matrixNew[0]=0; matrixNew[matrix.length-1]=0;
        for (int col = 1; col <matrix.length-1 ; col++) {
            matrixNew[col] = calculate(row, col);
            System.out.println(calculate(row,col));
        }
        synchronized (Main.harness) {
            try {
                counter++;
                System.out.println("Thread "+row+ " is going to sleep");
                Main.harness.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread has been waked up: "+ row);
        System.arraycopy(matrixNew,0,Main.matrix[row],0,matrixNew.length);

//        System.out.println(Arrays.toString(matrix));
    }

    public static int calculate(int row, int col) {
        int[] directions = new int[]{-1, 0, 1};
        int sum = 0;
        for (int i : directions) {
            for (int j : directions) {
                sum += matrix[row + i][col + j];
            }
        }
        return sum;
    }
}
