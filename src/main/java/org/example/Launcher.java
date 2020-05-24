package org.example;

import org.example.game.Game;
import org.example.game.Menu;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu menu = new Menu();
            }
        });
    }
}