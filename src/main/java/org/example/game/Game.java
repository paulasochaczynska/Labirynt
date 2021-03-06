package org.example.game;

import org.example.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends JFrame {
    private static final int MENU_BAR_HEIGHT = 25;
    public static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800 + MENU_BAR_HEIGHT;
    private static final int RELATIVE_GAME_HEIGHT = GAME_HEIGHT - MENU_BAR_HEIGHT;

    public static int fieldCount = 7;
    public static int fieldSize = GAME_WIDTH / fieldCount;

    private GraphicPanel panel = new GraphicPanel();
    private Keyboard keyboard;
    private List<GameObject> objects = new CopyOnWriteArrayList<>(); //To prevent concurrent modification.
    private Mediator mediator = new Mediator(objects, this);
    private Player player = new Player(mediator);
    private ScoresView scoresView = new ScoresView(player);
    private MusicPlayer musicPlayer;

    private int levelNumber = 1;
    private ImageIcon imageIcon = new ImageIcon("icon.png");

    public Game() throws HeadlessException {
        setUpFrame();
        setupMusic();
        addMinimizeListener();
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
        setIconImage(imageIcon.getImage());
        setResizable(false);
    }


    public void setupMusic() {
        musicPlayer = new MusicPlayer("sample.wav");
        musicPlayer.start();
    }

    public void addMinimizeListener() {
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED) {
                    musicPlayer.pause();
                } else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == 0) {
                    musicPlayer.start();
                }
            }
        });
    }



    public void setUpComponents(){
        keyboard = new Keyboard(player);
        addKeyListener(keyboard);
    }

    public void winLevel(){
        showWinMessage();
        checkLastLvl();
        levelNumber++;
        updateFieldCount();
        loadLevel(levelNumber);
    }

    private void checkLastLvl(){
        if(levelNumber == 15){
            winGame();
        }
    }


    private void updateFieldCount(){
        if(levelNumber == 5){
            fieldCount = 9;
            updateFieldSize();
        }
        if(levelNumber == 10){
            fieldCount = 13;
            updateFieldSize();
        }
    }

    private void updateFieldSize() {
        fieldSize = GAME_WIDTH/fieldCount;
        player.setWidth(fieldSize);
        player.setHeight(fieldSize);
    }

    public void loseGame(){
        JOptionPane.showMessageDialog(this, "Przegrałeś poziom " + levelNumber);
        saveScores();
        System.exit(0);
    }

    public void winGame(){
        player.score();
        JOptionPane.showMessageDialog(this, "Wygrałeś grę! ");
        saveScores();
        System.exit(0);
    }

    public void saveScores(){
        String name = JOptionPane.showInputDialog("Podaj imię, aby trafić do rankingu");
        if(name == null || name.isBlank()){
            return;
        }
        RankingData rankingData = new RankingData(player.getAllScores(), name);
        RankingManager rankingManager = new RankingManager();
        rankingManager.save(rankingData);
    }

    public void showWinMessage(){
        JOptionPane.showMessageDialog(this, "Ukończyłeś poziom " + levelNumber);
    }

    public void loadLevel(int levelNumber){
        objects.clear();
        WallsGenerator wallsGenerator = new WallsGenerator(mediator);
        List<Wall> walls = wallsGenerator.createWallsForLever(levelNumber);
        objects.addAll(walls);
        GhostGenerator ghostGenerator = new GhostGenerator(mediator, levelNumber);
        objects.addAll(ghostGenerator.generateGhosts());
        Treasure treasure = new Treasure( mediator);
        putElementInFreeSpace(treasure, 0);
        putElementInFreeSpace(player, fieldCount -1);
        setUpLevelPoints(player);
    }

    private void putElementInFreeSpace(GameObject element, int y){
        Random random = new Random();
        int randomX = random.nextInt(fieldCount);
        if (mediator.findGameObjectByCords(randomX,y) != null) {
            putElementInFreeSpace(element, y);
            return;
        }
        element.setX(randomX);
        element.setY(y);
        objects.add(element);
    }

    private void setUpLevelPoints(Player player){
        player.score();
        player.setLevelScores(4* fieldCount);
    }

    class GraphicPanel extends JPanel implements ActionListener {
        private Timer timer = new Timer(1000/60, this);

        public GraphicPanel() {
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(GameObject object : objects){
                object.draw(g);
            }
            scoresView.render(g);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

    }
}
