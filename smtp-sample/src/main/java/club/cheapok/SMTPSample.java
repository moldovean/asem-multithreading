package club.cheapok;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SMTPSample {

    public static void main(String[] args) throws IOException {
        InetAddress iakaMail = InetAddress.getByName("smtp.gmail.com");
        System.out.println(iakaMail.getHostAddress());

        Socket clientSocket = new Socket(iakaMail, 25);
        InputStream inputStream = clientSocket.getInputStream();
        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String s;
        while (null != (s = bufferedReader.readLine())) {
            System.out.println("SERVER: " + s);
            if (s.contains("220")) {
                break;
            }
        }

        System.out.println("HELO " + InetAddress.getLocalHost().getHostAddress());
        pw.println("HELO " + InetAddress.getLocalHost().getHostAddress());
//            bufferedWriter.write("HELO cheapok.club");
//            bufferedWriter.flush();

        while (null != (s = bufferedReader.readLine())) {
            System.out.println("SERVER: " + s);
            if (s.contains("250")) {
                break;
            }
        }

        pw.println("MAIL From: iaka@iaka.net");
        while (null != (s = bufferedReader.readLine())) {
            System.out.println("SERVER: " + s);
            if (s.contains("250")) {
                break;
            }
        }

        pw.println("RCPT TO: mr.vrabie@gmail.com");
        while (null != (s = bufferedReader.readLine())) {
            System.out.println("SERVER: " + s);
            if (s.contains("250")) {
                break;
            }
        }

        pw.println("DATA");
        while (null != (s = bufferedReader.readLine())) {
            System.out.println("SERVER: " + s);
            if (s.contains("354")) {
                break;
            }
        }

        //email-body
        pw.println("From: iaka@iaka.net");
        pw.println("To: mr.vrabie@gmail.com");
        pw.println("Subject: Iaka Test email");
        pw.println();
        pw.println("Subject: Iaka Test email");
        pw.println("This is a test message");
        pw.println("Thanks");
        pw.println();
        pw.println(".");

        while (null != (s = bufferedReader.readLine())) {
            System.out.println("SERVER: " + s);
            if (s.contains("250")) {
                break;
            }
        }

        pw.println("QUIT");
        while (null != (s = bufferedReader.readLine())) {
            System.out.println("SERVER: " + s);
            if (s.contains("221")) {
                break;
            }
        }

        System.out.println("E-mail was sent, horray!");

        inputStream.close();
        outputStream.close();
        clientSocket.close();

    }

}
