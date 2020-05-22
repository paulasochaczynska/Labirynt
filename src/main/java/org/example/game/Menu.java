package org.example.game;

import org.example.model.Player;
import org.example.model.Treasure;
import org.example.model.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel panel = new JPanel(new FlowLayout());
    private JButton startButton = new JButton("Start");
    private JButton quitButton = new JButton("Quit");

    public Menu() throws HeadlessException {
        setUpFrame();
        setUpComponents();
        addButtonsActions();
    }

    public void setUpFrame(){
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu");
        add(panel);
        setSize(200, 80);
    }

    public void setUpComponents(){
        panel.add(startButton);
        panel.add(quitButton);
    }

    public void addButtonsActions(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                dispose();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
