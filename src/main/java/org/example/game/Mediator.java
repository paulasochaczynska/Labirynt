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

    public boolean canMoveTo(int x, int y) {
        GameObject found = findGameObjectByCords(x, y);
        if (found != null && found.isSolid()) {
            return false;
        }
        return true;
    }

    public void playerMoved(Player player) {
        GameObject found = findGameObjectByCords(player.getX(), player.getY());
        if (found != null) {
            found.reactToPlayer(player);
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
        game.winGame();
    }

    public void loseGame(){
        game.loseGame();
    }
}
