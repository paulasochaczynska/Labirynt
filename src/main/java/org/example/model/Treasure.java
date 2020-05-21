package org.example.model;

import java.awt.*;

public class Treasure extends GameObject{

    public Treasure(int x, int y) {
        super(x, y, Color.YELLOW);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x * width, y * height, width, height);
    }
}
