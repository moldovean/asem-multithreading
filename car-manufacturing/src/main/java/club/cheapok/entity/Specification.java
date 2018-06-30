package club.cheapok.boundary;

import club.cheapok.entity.Color;
import club.cheapok.entity.EngineType;

public class Specification {
    private Color color;
    private EngineType engineType;

    public Specification(final Color color, final EngineType engineType) {
        this.color = color;
        this.engineType = engineType;
    }

    public Color getColor() {
        return color;
    }

    public EngineType getEngineType() {
        return engineType;
    }
}
