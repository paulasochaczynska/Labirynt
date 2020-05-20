package org.example.model;

import java.awt.*;

public class Player extends GameObject{


    public Player(int x, int y) {
        super(x, y, Color.RED);
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}
