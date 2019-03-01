package com.Ruslan.ALevel.league;

import com.Ruslan.ALevel.player.BasePlayer;

import java.util.ArrayList;

public class BaseLeague {

    private String name;
    private Leagues leagueType;
    private ArrayList<BasePlayer> players;
    private int winPoints;

    public BaseLeague(String name, Leagues leagueType, ArrayList<BasePlayer> players, int winPoints) {
        this.name = name;
        this.leagueType = leagueType;
        this.players = players;
        this.winPoints = winPoints;
    }

    public Leagues getLeagueType() {
        return leagueType;
    }

    public String getName() {
        return name;
    }

    public ArrayList<BasePlayer> getPlayers() {
        return players;
    }

    public int getWinPoints() {
        return winPoints;
    }
}