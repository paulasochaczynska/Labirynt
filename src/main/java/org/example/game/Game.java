package org.example.game;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() throws HeadlessException {
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Labirynt");
    }
}
