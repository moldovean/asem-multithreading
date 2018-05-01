package club.cheapok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class IakaServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8422);
        while (true) {
            System.out.println("Server is about to Start");
            Socket accept = serverSocket.accept();
            System.out.println("Hello, someone has connected");
            InputStream inputStream = accept.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            serverSocket.close();
        }
    }
}
