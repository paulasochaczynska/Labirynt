package org.example.game;

import org.example.model.GameObject;
import org.example.model.Player;

import java.util.List;

public class Mediator {
    private List<GameObject> objects;
    private Game game;


    public Mediator(List<GameObject> objects, Game game) {
        this.objects = objects;
        this.game = game;
    }

    public boolean canMoveTo(int x, int y){
        for(GameObject object : objects){
            if(object.getX() == x && object.getY() == y){
                if(object.isSolid()){
                    return false;
                }
            }
        }
        return true;
    }

    public void playerMoved(Player player){
        for(GameObject object : objects){
            if(object.getX() == player.getX() && object.getY() == player.getY()){
                object.reactToPlayer(player);
            }
        }
    }

    public void winGame(){
        game.winGame();
    }
}
