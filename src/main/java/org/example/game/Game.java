package org.example.game;

import org.example.model.Player;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private static final int MENU_BAR_HEIGHT = 25;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800 + MENU_BAR_HEIGHT;
    private static final int RELATIVE_GAME_HEIGHT = GAME_HEIGHT - MENU_BAR_HEIGHT;

    private static final int FIELD_COUNT = 8;
    public static final int FIELD_SIZE = GAME_WIDTH / FIELD_COUNT;

    private GraphicPanel panel = new GraphicPanel();

    public Game() throws HeadlessException {
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Labirynt");
        add(panel);
    }


    class GraphicPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //   g.drawLine(0, 0, GAME_WIDTH, RELATIVE_GAME_HEIGHT);
            Player player = new Player(0, 0);
            player.draw(g);
        }
    }
}
