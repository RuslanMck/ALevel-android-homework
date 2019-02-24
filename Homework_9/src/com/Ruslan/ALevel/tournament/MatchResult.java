package com.Ruslan.ALevel.tournament;

import com.Ruslan.ALevel.league.BaseLeague;

public class MatchResult {
    private String winner;
    private String loser;
    private BaseLeague league;

    public MatchResult(String winner, String loser, BaseLeague league) {
        this.winner = winner;
        this.loser = loser;
        this.league = league;
    }

    public String getWinner() {
        return winner;
    }

    public String getLoser() {
        return loser;
    }

}
