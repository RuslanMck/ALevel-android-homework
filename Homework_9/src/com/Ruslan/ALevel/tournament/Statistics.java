package com.Ruslan.ALevel.tournament;

import com.Ruslan.ALevel.ConsoleOutput;
import com.Ruslan.ALevel.league.Leagues;
import com.Ruslan.ALevel.player.BasePlayer;

import java.util.ArrayList;
import java.util.Comparator;

public class Statistics {

    ConsoleOutput output = new ConsoleOutput();


    public ArrayList topAge(ArrayList<BasePlayer> arrayList) {
        arrayList.sort(new Comparator<BasePlayer>() {
            @Override
            public int compare(BasePlayer p1, BasePlayer p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });
        return null;
    }

    public ArrayList topScore(ArrayList<BasePlayer> arrayList) {
        arrayList.sort(new Comparator<BasePlayer>() {
            @Override
            public int compare(BasePlayer p1, BasePlayer p2) {
                return Integer.compare(p2.getScore(), p1.getScore());
            }
        });
        return null;
    }

    public void getStatistics(ArrayList<BasePlayer> players, int places, Leagues leagues) {
        topAge(players);
        output.ageStatistics(players, places, leagues);
        topScore(players);
        output.scoreStatistics(players, places, leagues);
    }
}
