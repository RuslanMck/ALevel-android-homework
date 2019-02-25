package com.Ruslan.ALevel.tournament;

import com.Ruslan.ALevel.ConsoleOutput;
import com.Ruslan.ALevel.league.Leagues;
import com.Ruslan.ALevel.player.BasePlayer;

import java.util.ArrayList;
import java.util.Comparator;

public class Statistics {

    ConsoleOutput output = new ConsoleOutput();


    private ArrayList topAge(ArrayList<BasePlayer> arrayList) {
        arrayList.sort(new Comparator<BasePlayer>() {
            @Override
            public int compare(BasePlayer p1, BasePlayer p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });
        return null;
    }

    private ArrayList topScore(ArrayList<BasePlayer> arrayList) {
        arrayList.sort(new Comparator<BasePlayer>() {
            @Override
            public int compare(BasePlayer p1, BasePlayer p2) {
                return Integer.compare(p2.getScore(), p1.getScore());
            }
        });
        return null;
    }

    private ArrayList mostWin(ArrayList<BasePlayer> arrayList){
        arrayList.sort(new Comparator<BasePlayer>() {
            @Override
            public int compare(BasePlayer p1, BasePlayer p2) {
                return Integer.compare(p2.getWinCount(), p1.getWinCount());
            }
        });
        return null;
    }

    public void getStatistics(ArrayList<BasePlayer> players, int places, Leagues leagues) {
        topAge(players);
        output.ageStatistics(players, places, leagues);
        topScore(players);
        output.scoreStatistics(players, places, leagues);
        mostWin(players);
        output.winStatistics(players,places,leagues);

    }
}
