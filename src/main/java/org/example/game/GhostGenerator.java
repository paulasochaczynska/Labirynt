package org.example.game;

import org.example.model.Ghost;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GhostGenerator {

    private Mediator mediator;
    private int lvlNr;

    public GhostGenerator(Mediator mediator, int lvlNr) {
        this.mediator = mediator;
        this.lvlNr = lvlNr;
    }

    public List<Ghost> generateGhosts(){
        List<Ghost> ghosts = new ArrayList<>();
        addGhost(ghosts);
        return ghosts;
    }

    private void addGhost( List<Ghost> ghosts ){
        Random random = new Random();
        for (int i = 0; i < lvlNr/3 +1; i++) {
            int y = random.nextInt(Game.fieldCount -2)+1;
            int x = random.nextInt(Game.fieldCount);
            ghosts.add(new Ghost(x,y,mediator));
        }
    }

}
