package club.cheapok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderSample {
    public static void main(String[] args) {
        String s = null;
        try (BufferedReader in = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            System.out.println("Type xyz");
            s = in.readLine();
            while (s != null) {
                System.out.println("READ: "+s.trim());
                if (s.equals("xyz")) {
                    System.exit(0);
                } else {
                    s = in.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
