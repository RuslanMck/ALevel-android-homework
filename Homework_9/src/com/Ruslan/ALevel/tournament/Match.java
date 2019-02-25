package com.Ruslan.ALevel.tournament;

import com.Ruslan.ALevel.ConsoleOutput;
import com.Ruslan.ALevel.league.BaseLeague;
import com.Ruslan.ALevel.player.BasePlayer;
import com.Ruslan.ALevel.randomizer.BoundedRandomInt;

public class Match {

    BoundedRandomInt randomInt = new BoundedRandomInt();
    private int playerFirstSkill;
    private int playerSecondSkill;
    ConsoleOutput output = new ConsoleOutput();


    public GamesResult startMatch(BasePlayer playerFirst, BasePlayer playerSecond, BaseLeague league) {

        playerFirstSkill = countSkill(playerFirst);
        playerSecondSkill = countSkill(playerSecond);
        return compareSkill(playerFirst, playerSecond, league);
    }

    private GamesResult compareSkill(BasePlayer playerFirst, BasePlayer playerSecond, BaseLeague league) {
        if (playerFirstSkill > playerSecondSkill) {
            plusScore(playerFirst, league);
            minusScore(playerSecond, league);
            playerFirst.setSkillPoints(playerFirst.getSkillPoints() + 1);
            output.matchResultWinner(playerFirst);
            return new GamesResult(playerFirst.getName(), playerSecond.getName(), playerFirst.getScore(), playerSecond.getScore(), league);
        } else if (playerFirstSkill < playerSecondSkill) {
            plusScore(playerSecond, league);
            minusScore(playerFirst, league);
            playerSecond.setSkillPoints(playerSecond.getSkillPoints() + 1);
            output.matchResultWinner(playerSecond);
            return new GamesResult(playerSecond.getName(), playerFirst.getName(), playerSecond.getScore(), playerFirst.getScore(), league);
        } else if (playerFirstSkill == playerSecondSkill) {
            output.matchResultNoWinner();
            return new GamesResult("No winner", "No loser", 0, 0, league);
        }
        return null;
    }

    private int countSkill(BasePlayer player) {
        int rnd = randomInt.generate(-10, 10);
        return (player.getSkillPoints() + rnd);
    }

    private void plusScore(BasePlayer player, BaseLeague league) {
        player.setScore(player.getScore() + league.getWinPoints());
    }

    private void minusScore(BasePlayer player, BaseLeague league) {
        player.setScore(player.getScore() - league.getWinPoints());
    }
}
