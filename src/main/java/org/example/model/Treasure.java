package org.example.model;

import org.example.game.Mediator;
import java.awt.*;

public class Treasure extends GameObject{

    public Treasure(int x, int y, Mediator mediator) {
        super(x, y, Color.YELLOW, mediator);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x * width, y * height, width, height);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
