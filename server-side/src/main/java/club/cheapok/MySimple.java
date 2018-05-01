package club.cheapok;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MySimple {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Listening for connection on port 8888 i ....");
        while (true) {
            //receving
            Socket clientSocket = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line = reader.readLine();
            while (line!=null && !line.isEmpty()) {
                if(line.contains("GET"))
                System.out.println(line);
                line = reader.readLine();
            }
            //response
            BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter additional info: ");
            String serverAdditionalInfo = systemIn.readLine();
            StringBuilder stringBuilder = new StringBuilder("HTTP/1.1 200 OK\r\n\r\n <html><body><h1>Hello WebServices!</h1>");
            stringBuilder.append("<h2>" + serverAdditionalInfo + "</h2>");
            stringBuilder.append("</body></html>");
            OutputStream outputStream = clientSocket.getOutputStream();
            clientSocket.getOutputStream().write(stringBuilder.toString().getBytes("UTF-8"));
            clientSocket.close();
//            clientSocket.getOutputStream().write("<html><h1>Hello World!</h1></html>".getBytes());
        }

    }
}
