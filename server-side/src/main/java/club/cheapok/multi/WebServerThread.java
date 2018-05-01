package club.cheapok.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class WebServerThread implements Runnable {
    private Socket clientSocket;

    public WebServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line = reader.readLine();
            while (line!=null && !line.isEmpty()) {
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
            outputStream.write(stringBuilder.toString().getBytes("UTF-8"));
            outputStream.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
