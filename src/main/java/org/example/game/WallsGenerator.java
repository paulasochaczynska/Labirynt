package org.example.game;

import org.example.model.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WallsGenerator {
    private Mediator mediator;

    public WallsGenerator(Mediator mediator) {
        this.mediator = mediator;
    }

    public List<Wall> createWallsForLever(int levelNumber) {
        List<Wall> walls = new ArrayList<>();
        addHorizontalWalls(walls);
        addDoors(walls);
        addSpecialWalls(walls);
        return walls;
    }

    public void addHorizontalWalls(List<Wall> walls) {
        for (int y = 0; y < Game.FIELD_COUNT; y++) {
            if (y % 2 == 1) {
                for (int x = 0; x < Game.FIELD_COUNT; x++) {
                    walls.add(new Wall(x, y, mediator));
                }
            }
        }
    }

    public void addDoors(List<Wall> walls) {
        for (int y = 0; y < Game.FIELD_COUNT; y++) {
            if (y % 2 == 1) {
                for (int i = 0; i < 2; i++) {
                    Random random = new Random();
                    walls.remove(new Wall(random.nextInt(Game.FIELD_COUNT), y, mediator));
                }
            }
        }
    }

    public void addSpecialWalls(List<Wall> walls) {
        for (int y = 0; y < Game.FIELD_COUNT; y++) {
            if (y % 2 == 0) {
                Random random = new Random();
                walls.add(new Wall(random.nextInt(Game.FIELD_COUNT), y, mediator));
            }
        }
    }
}
