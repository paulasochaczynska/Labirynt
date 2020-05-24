package org.example.model;

import org.example.game.Game;
import org.example.game.Mediator;

import java.awt.*;
import java.util.Random;

public class Ghost extends GameObject {

    private boolean movingUp;

    public Ghost(int x, int y, Mediator mediator) {
        super(x, y, Color.GRAY.brighter(), mediator);
        Random random = new Random();
        movingUp = random.nextBoolean();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int margin = width/8;
        g.fillOval(x *width + margin,y*height+margin,width/4 *3,height/4*3);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public void reactToPlayerCollision(Player player) {
        mediator.loseGame();
    }

    @Override
    public void reactToPlayerMoved() {
        if(movingUp){
            moveUp();
        }else {
            moveDown();
        }
    }

    private void moveUp(){
         y--;
         if(y == 0){
             movingUp = false;
         }
    }

    private void moveDown(){
        y++;
        if(y == Game.fieldCount -1){
            movingUp = true;
        }
    }

}
