package club.cheapok;

public class Main {
    public static void main(String[] args) {
        MySingleton myIaka = MySingleton.init();
        System.out.println(myIaka.getName());

    }
}
