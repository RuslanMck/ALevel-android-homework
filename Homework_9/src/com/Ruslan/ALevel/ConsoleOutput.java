package com.Ruslan.ALevel;

import com.Ruslan.ALevel.league.BaseLeague;
import com.Ruslan.ALevel.player.BasePlayer;

public class ConsoleOutput {

    public void matchResultWinner(BasePlayer player){
        System.out.println("In this game " + player.getName() + " won.");
    }
    public void matchResultNoWinner(){
        System.out.println("In this game we have draw.");
    }
    public void startLeague(BaseLeague league){
        System.out.println("We start a tournament of " + league.getName() + " league.");
    }
    public void startMatch(int gameNumber, BasePlayer firstPlayer, BasePlayer secondPlayer){
        System.out.println("We start a " + gameNumber + " game. Opponents: " + firstPlayer.getName() + "; " + secondPlayer.getName() + ".");
    }

}
