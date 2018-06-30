package club.cheapok.entity;

import club.cheapok.control.Diesel;
import club.cheapok.entity.Color;
import club.cheapok.entity.EngineType;

import javax.inject.Inject;

public class Specification {
    @Inject
    private Color color;
    @Inject
    @Diesel
    private EngineType engineType;

    public Specification() {
    }

    public Specification(final EngineType engineType) {
        this.engineType = engineType;
    }

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

    public Specification setColor(final Color color) {
        this.color = color;
        return this;
    }

    public Specification setEngineType(final EngineType engineType) {
        this.engineType = engineType;
        return this;
    }
}
