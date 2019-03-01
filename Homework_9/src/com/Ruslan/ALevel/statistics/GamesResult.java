package com.Ruslan.ALevel.statistics;

import com.Ruslan.ALevel.league.BaseLeague;

import java.util.ArrayList;

public class GamesResult {
    private String winner;
    private String loser;
    private int winnersScore;
    private int losersScore;
    private BaseLeague league;

    public GamesResult(String winner, String loser, int winnersScore, int losersScore, BaseLeague league) {
        this.winner = winner;
        this.loser = loser;
        this.winnersScore = winnersScore;
        this.losersScore = losersScore;
        this.league = league;
    }

    public String getWinner() {
        return winner;
    }

    public String getLoser() {
        return loser;
    }

    public int getWinnersScore() {
        return winnersScore;
    }

    public int getLosersScore() {
        return losersScore;
    }

    public BaseLeague getLeague() {
        return league;
    }
}
