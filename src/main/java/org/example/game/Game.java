package org.example.game;

import org.example.model.GameObject;
import org.example.model.Player;
import org.example.model.Treasure;
import org.example.model.Wall;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {
    private static final int MENU_BAR_HEIGHT = 25;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800 + MENU_BAR_HEIGHT;
    private static final int RELATIVE_GAME_HEIGHT = GAME_HEIGHT - MENU_BAR_HEIGHT;

    private static final int FIELD_COUNT = 8;
    public static final int FIELD_SIZE = GAME_WIDTH / FIELD_COUNT;

    private GraphicPanel panel = new GraphicPanel();
    private List<GameObject> objects = new ArrayList<>();

    public Game() throws HeadlessException {
        setUpFrame();
        setUpComponents();
    }

    public void setUpFrame(){
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Labirynt");
        add(panel);
    }

    public void setUpComponents(){
        Player player = new Player(1, 0);
        Treasure treasure = new Treasure(0, 0);
        Wall wall = new Wall(4, 4);
        objects.add(player);
        objects.add(treasure);
        objects.add(wall);
    }


    class GraphicPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //   g.drawLine(0, 0, GAME_WIDTH, RELATIVE_GAME_HEIGHT);
            for(GameObject object : objects){
                object.draw(g);
            }
        }
    }
}
