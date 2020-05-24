package org.example.game;

import org.example.model.GameObject;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    private List<GameObject> objects;
    private Game game;


    public Mediator(List<GameObject> objects, Game game) {
        this.objects = objects;
        this.game = game;
    }

    public boolean canMoveTo(int x, int y) {
        GameObject found = findGameObjectByCords(x, y);
        if (found != null && found.isSolid()) {
            return false;
        }
        return true;
    }

    public void reactToPlayerCollision(Player player) {
        GameObject found = findGameObjectByCords(player.getX(), player.getY());
        if (found != null) {
            found.reactToPlayerCollision(player);
        }
    }

    public GameObject findGameObjectByCords(int x, int y) {
        for (GameObject object : objects) {
            if (object.getX() == x && object.getY() == y) {
                return object;
            }
        }
        return null;
    }

    public void winGame() {
        game.winLevel();
    }

    public void loseGame() {
        game.loseGame();
    }

    public void detonateBomb(int x, int y) {
        clearField(x - 1, y);
        clearField(x, y - 1);
        clearField(x + 1, y);
        clearField(x, y + 1);
    }

    public void clearField(int x, int y) {
        if (x < 0 || x >= Game.fieldCount) {
            return;
        }
        if (y < 0 || y >= Game.fieldCount) {
            return;
        }
        List<GameObject> toRemove = new ArrayList<>();
        for(GameObject object : objects){
            if (object.getX() == x && object.getY() == y){
                toRemove.add(object);
            }
        }
        objects.removeAll(toRemove);
    }

    public void reactBeforePlayerAct(){
        for (GameObject object : objects) {
            object.reactToPlayerMoved();
        }
    }
}
