package org.example.model;

import java.io.Serializable;

public class RankingData implements Serializable, Comparable<RankingData> {
    private int scores;
    private String name;

    public RankingData(int scores, String name) {
        this.scores = scores;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + scores;
    }

    @Override
    public int compareTo(RankingData o) {
        return scores-o.scores;
    }
}
