package club.cheapok;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Iaka {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        InetAddress localHost = InetAddress.getLocalHost();
        byte[] address = localHost.getAddress();
        System.out.println((byte)address[0]);
    }
}
