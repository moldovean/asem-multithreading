package club.cheapok;

public class MySingleton {

    public static MySingleton myIaka;

    private String name;

    private MySingleton(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static MySingleton init() {
        if (myIaka  == null) {
            synchronized (myIaka) {
                if (myIaka == null) {
                    myIaka = new MySingleton("Victor");
                }
                return myIaka;
            }
        } else {
            return myIaka;
        }
    }
}
