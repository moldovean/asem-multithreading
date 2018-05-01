package club.cheapok;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static boolean isListening = true;

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            System.out.println("Server up...");
            serverSocket = new ServerSocket(8080);
            Socket socket = null;
            BufferedReader bufferedReader = null;
            PrintWriter out = null;
            String line2="";

            while (isListening) {
                socket = serverSocket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = bufferedReader.readLine();
                while (!line.isEmpty()) {
                    System.out.println("iaka : "+line);
                    line2 = line.toUpperCase()+'\n';
                    line = bufferedReader.readLine();
                }
            }

            out = new PrintWriter(socket.getOutputStream(), true);
            out.print(line2);
            socket.close();
            bufferedReader.close();
            out.close();



            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
