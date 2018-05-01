package club.cheapok;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Clinet side here...");
            Socket socket = new Socket("0.0.0.0", 1234);
//            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.write("Hello World!");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            dataOutputStream.write("hello there".getBytes());

            System.out.println("resp: "+bufferedReader.readLine());
            writer.close();
            bufferedReader.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("nt reachable");
            e.printStackTrace();
        }
    }
}
