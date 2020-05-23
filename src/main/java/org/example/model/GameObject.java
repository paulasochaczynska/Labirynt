package org.example.model;

import org.example.game.Game;
import org.example.game.Mediator;

import java.awt.*;
import java.util.Objects;

public abstract class GameObject {
    int x;
    int y;
    int width = Game.FIELD_SIZE;
    int height = Game.FIELD_SIZE;
    Color color;
    Mediator mediator;

    public GameObject(int x, int y, Color color, Mediator mediator) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.mediator = mediator;
    }
    public abstract void draw(Graphics g);

    public abstract boolean isSolid();

    public abstract void reactToPlayer(Player player);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject object = (GameObject) o;
        return x == object.x &&
                y == object.y &&
                width == object.width &&
                height == object.height &&
                Objects.equals(color, object.color) &&
                Objects.equals(mediator, object.mediator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height, color, mediator);
    }
}
