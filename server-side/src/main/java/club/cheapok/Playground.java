package club.cheapok;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Playground {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet = InetAddress.getLocalHost();
        System.out.println(inet.getHostAddress());
        System.out.println(inet.getAddress());
        System.out.println(inet.getCanonicalHostName());

        InetAddress inet2 = InetAddress.getByName("google.com");
        System.out.println(inet2.getHostAddress());
        System.out.println(inet2.getAddress());
        System.out.println(inet2.getCanonicalHostName());

    }
}
