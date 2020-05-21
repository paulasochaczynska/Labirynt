package org.example.model;

import org.example.game.Game;
import org.example.game.Mediator;

import java.awt.*;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
