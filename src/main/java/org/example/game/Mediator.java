package org.example.game;

import org.example.model.GameObject;

import java.util.List;

public class Mediator {
    private List<GameObject> objects;

    public Mediator(List<GameObject> objects) {
        this.objects = objects;
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
}
