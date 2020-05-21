package org.example.model;

import java.awt.*;

public class Wall extends GameObject {

    public Wall(int x, int y) {
        super(x, y, Color.GRAY);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x * width, y * height, width, height);
    }
}
