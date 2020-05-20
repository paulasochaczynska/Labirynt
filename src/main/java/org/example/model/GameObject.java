package org.example.model;

import org.example.game.Game;

import java.awt.*;

public abstract class GameObject {
    int x;
    int y;
    int width = Game.FIELD_SIZE;
    int height = Game.FIELD_SIZE;
    Color color;

    public GameObject(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public abstract void draw(Graphics g);
}
