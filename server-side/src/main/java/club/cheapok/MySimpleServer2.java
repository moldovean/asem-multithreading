package club.cheapok;

import club.cheapok.multi.WebServerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySimpleServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Listening for connection on port 8888 i ....");
        while (true) {
            //receving
            Socket clientSocket = server.accept();
            WebServerThread wst = new WebServerThread(clientSocket);
            Thread t1 = new Thread(wst);
            t1.start();
//            clientSocket.getOutputStream().write("<html><h1>Hello World!</h1></html>".getBytes());
        }

    }
}
