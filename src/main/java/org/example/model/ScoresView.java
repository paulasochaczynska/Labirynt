package org.example.model;

import org.example.game.Game;

import java.awt.*;

public class ScoresView {
    private Player player;

    public ScoresView(Player player) {
        this.player = player;
    }

    public void render(Graphics g){
        int allScores = player.getAllScores();
        int levelScores = player.getLevelScores();
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        g.drawString("all scores: " + allScores, Game.GAME_WIDTH - 160, 25);
        g.drawString("level score: " + levelScores, 25, 25);
    }
}
