package org.example.game;

import org.example.model.RankingData;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Ranking extends JFrame {
    private JPanel panel = new JPanel(new FlowLayout());
    private JList<RankingData> rankingList = new JList<>();
    private DefaultListModel<RankingData> listModel = new DefaultListModel<>();

    public Ranking() throws HeadlessException {
        setUpFrame();
        setUpList();
    }

    public void setUpFrame(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Ranking");
        add(panel);
        setSize(250, 400);
        setResizable(false);
    }

    public void setUpList(){
        panel.add(rankingList);
        rankingList.setModel(listModel);
        RankingManager rankingManager = new RankingManager();
        List<RankingData> loadedRanking = rankingManager.getRanking();
        listModel.addAll(loadedRanking);

    }

}
