package org.example.model;

import org.example.game.Mediator;
import java.awt.*;

public class Treasure extends GameObject{

    public Treasure(Mediator mediator) {
        super(0,0, Color.YELLOW, mediator);
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

    @Override
    public void reactToPlayerCollision(Player player) {
        mediator.winGame();
    }

    @Override
    public void reactToPlayerMoved() {

    }
}
