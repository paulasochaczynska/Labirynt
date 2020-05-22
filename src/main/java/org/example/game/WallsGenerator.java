package org.example.game;

import org.example.model.Wall;

import java.util.ArrayList;
import java.util.List;

public class WallsGenerator {
    private Mediator mediator;

    public WallsGenerator(Mediator mediator) {
        this.mediator = mediator;
    }

    public List<Wall> createWallsForLever(int levelNumber){
        List<Wall> walls = new ArrayList<>();
        Wall wall = new Wall(4, levelNumber, mediator);
        walls.add(wall);
        return walls;
    }
}
