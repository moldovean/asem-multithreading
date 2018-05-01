package club.cheapok;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MySimpleResponse {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            Socket clientSocket = server.accept();

            Date today = new Date();
//            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
//            clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
//            clientSocket.close();

            String s = "HTTP/1.1 200 OK\r\n\r\n Hello World!";
            clientSocket.getOutputStream().write(s.getBytes("UTF-8"));
            clientSocket.close();


        }

    }
}
