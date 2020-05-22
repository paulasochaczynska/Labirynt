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
    private Mediator mediator = new Mediator(objects, this);
    private Player player = new Player(mediator);

    private int levelNumber = 1;

    public Game() throws HeadlessException {
        setUpFrame();
        setUpComponents();
        loadLevel(levelNumber);
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
        keyboard = new Keyboard(player);
        addKeyListener(keyboard);
    }

    public void winGame(){
        showWinMessage();
        levelNumber++;
        loadLevel(levelNumber);
    }

    public void showWinMessage(){
        JOptionPane.showMessageDialog(this, "Ukończyłeś poziom " + levelNumber);
    }

    public void loadLevel(int levelNumber){
        objects.clear();
        WallsGenerator wallsGenerator = new WallsGenerator(mediator);
        List<Wall> walls = wallsGenerator.createWallsForLever(levelNumber);
        objects.addAll(walls);
        Treasure treasure = new Treasure(0, 0, mediator);
        objects.add(player);
        objects.add(treasure);
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
