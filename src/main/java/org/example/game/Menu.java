package org.example.game;

import org.example.model.Player;
import org.example.model.Treasure;
import org.example.model.Wall;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JPanel panel = new JPanel();

    public Menu() throws HeadlessException {
        setUpFrame();
        setUpComponents();
    }

    public void setUpFrame(){
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu");
        add(panel);
    }

    public void setUpComponents(){

    }
}
