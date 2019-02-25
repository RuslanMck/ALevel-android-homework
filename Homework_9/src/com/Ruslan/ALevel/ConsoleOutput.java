package com.Ruslan.ALevel;

import com.Ruslan.ALevel.league.BaseLeague;
import com.Ruslan.ALevel.league.Leagues;
import com.Ruslan.ALevel.player.BasePlayer;
import com.Ruslan.ALevel.tournament.GamesResult;

import java.util.ArrayList;

public class ConsoleOutput {

    public void ageStatistics(ArrayList<BasePlayer> players, int number, Leagues leagues) {
        System.out.println("\nTop " + number + " of youngest players in " + leagues + " league:");
        for (int i = 0; i < number; i++) {
            System.out.println(players.get(i).getName() + " " + players.get(i).getAge() + " years;");
        }
    }

    public void scoreStatistics(ArrayList<BasePlayer> players, int number, Leagues leagues) {
        System.out.println("\nTop " + number + " scores in " + leagues + " league:");
        for (int i = 0; i < number; i++) {
            if (players.get(i).getScore() > 0) {
                System.out.println(players.get(i).getName() + " " + players.get(i).getScore() + " points;");
            }
        }
    }

    public void matchResultWinner(BasePlayer player) {
        System.out.println("In this game " + player.getName() + " won.");
    }

    public void matchResultNoWinner() {
        System.out.println("In this game we have draw.");
    }

    public void printResult(ArrayList<GamesResult> arrayList) {
        for (GamesResult res : arrayList) {
            System.out.println("Winner: " + res.getWinner() + " (score " + res.getWinnersScore() + "); Loser: "
                    + res.getLoser() + " (score " + res.getLosersScore() + ")");
        }
    }

    public void startLeague(BaseLeague league) {
        System.out.println("\nWe start a tournament of " + league.getName() + " league.");
    }

    public void startMatch(int gameNumber, BasePlayer firstPlayer, BasePlayer secondPlayer) {
        System.out.println("We start a " + gameNumber + " game. Opponents: " + firstPlayer.getName() + "; " + secondPlayer.getName() + ".");
    }

}
