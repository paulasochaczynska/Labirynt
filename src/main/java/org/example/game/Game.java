package org.example.game;

import org.example.model.GameObject;
import org.example.model.Player;
import org.example.model.Treasure;
import org.example.model.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {
    private static final int MENU_BAR_HEIGHT = 25;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800 + MENU_BAR_HEIGHT;
    private static final int RELATIVE_GAME_HEIGHT = GAME_HEIGHT - MENU_BAR_HEIGHT;

    public static final int FIELD_COUNT = 8;
    public static final int FIELD_SIZE = GAME_WIDTH / FIELD_COUNT;

    private GraphicPanel panel = new GraphicPanel();
    private Keyboard keyboard;
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
        Mediator mediator = new Mediator(objects);
        Player player = new Player(1, 0, mediator);
        Treasure treasure = new Treasure(0, 0, mediator);
        Wall wall = new Wall(4, 4, mediator);
        objects.add(player);
        objects.add(treasure);
        objects.add(wall);
        keyboard = new Keyboard(player);
        addKeyListener(keyboard);
    }


    class GraphicPanel extends JPanel implements ActionListener {
        private Timer timer = new Timer(1000/60, this);

        public GraphicPanel() {
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //   g.drawLine(0, 0, GAME_WIDTH, RELATIVE_GAME_HEIGHT);
            for(GameObject object : objects){
                object.draw(g);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
