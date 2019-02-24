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



    public MatchResult startMatch(BasePlayer playerFirst, BasePlayer playerSecond, BaseLeague league) {

        playerFirstSkill = countSkill(playerFirst);
        playerSecondSkill = countSkill(playerSecond);
        return compareSkill(playerFirst, playerSecond, league);
    }

    private MatchResult compareSkill(BasePlayer playerFirst, BasePlayer playerSecond, BaseLeague league) {
        if (playerFirstSkill > playerSecondSkill) {
            plusScore(playerFirst, league);
            minusScore(playerSecond, league);
            playerFirst.setSkillPoints(playerFirst.getSkillPoints() + 1);
            output.matchResultWinner(playerFirst);
            return new MatchResult(playerFirst.getName(),playerSecond.getName(),league);
        } else if (playerFirstSkill < playerSecondSkill) {
            plusScore(playerSecond, league);
            minusScore(playerFirst, league);
            playerSecond.setSkillPoints(playerSecond.getSkillPoints() + 1);
            output.matchResultWinner(playerSecond);
            return new MatchResult(playerSecond.getName(),playerFirst.getName(),league);
        } else if (playerFirstSkill == playerSecondSkill) {
            output.matchResultNoWinner();
            return new MatchResult("No winner", "No loser", league);
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
