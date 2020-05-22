package org.example.model;

import org.example.game.Mediator;

import java.awt.*;

public class Wall extends GameObject {

    public Wall(int x, int y, Mediator mediator) {
        super(x, y, Color.GRAY, mediator);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x * width, y * height, width, height);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void reactToPlayer(Player player) {
    }
}
