package org.example.model;

import org.example.game.Game;
import org.example.game.Mediator;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject {
    private int levelScores;
    private int allScores;

    public Player(Mediator mediator) {
        super(0,0, Color.RED, mediator);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x * width, y * height, width, height);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void reactToPlayer(Player player) {
    }

    public void move(int keyCode) {
        int newX = x;
        int newY = y;

        if (KeyEvent.VK_RIGHT == keyCode) {
            newX = moveRight();
        }
        if (KeyEvent.VK_LEFT == keyCode) {
            newX = moveLeft();
        }
        if (KeyEvent.VK_UP == keyCode) {
            newY = moveUp();
        }
        if (KeyEvent.VK_DOWN == keyCode) {
            newY = moveDown();
        }

        if(newX < 0 || newX > Game.FIELD_COUNT - 1){
            return;
        }

        if(newY < 0 || newY > Game.FIELD_COUNT - 1){
            return;
        }

        if(!mediator.canMoveTo(newX, newY)){
               return;
        }

        x = newX;
        y = newY;

        mediator.playerMoved(this);
        updateScore();
    }

    private void updateScore(){
        levelScores --;
        if(levelScores<=0){
            mediator.loseGame();
        }
    }

    private int moveRight() {
        return x+1;
    }

    private int moveLeft() {
        return x-1;
    }

    private int moveUp() {
        return y-1;
    }

    private int moveDown() {
        return y+1;
    }

    public void score(){
        allScores = allScores + levelScores;
    }

    public int getLevelScores() {
        return levelScores;
    }

    public void setLevelScores(int levelScores) {
        this.levelScores = levelScores;
    }

    public int getAllScores() {
        return allScores;
    }
}
