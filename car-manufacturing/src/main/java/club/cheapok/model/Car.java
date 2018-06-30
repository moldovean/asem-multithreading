package club.cheapok.entity;

public class Car {
    private String id;
    private Color color;
    private EngineType engineType;

    public Car() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(final EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Iaka Car{" +
                "id='" + id + '\'' +
                ", color=" + color +
                ", engineType=" + engineType +
                '}';
    }
}
