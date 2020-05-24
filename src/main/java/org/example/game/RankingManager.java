package org.example.game;

import org.example.model.RankingData;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingManager {
    private List<RankingData> ranking = new ArrayList<>();
    private String filePath = "ranking.bin";

    public RankingManager() {
        loadRankingFromFile();
        Collections.sort(ranking);
    }

    public void save (RankingData rankingData){
        ranking.add(rankingData);
        saveRankingToFile();
    }
    private void saveRankingToFile(){
        File file = new File(filePath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ranking);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRankingFromFile(){
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ranking = (List<RankingData>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Brak pliku");
        }
    }

    public List<RankingData> getRanking() {
        return ranking;
    }
}
