import league.BaseLeague;
import player.BasePlayer;
import randomizer.BoundedRandomInt;

public class Match {

    BoundedRandomInt randomInt = new BoundedRandomInt();

    public void startMatch(BasePlayer playerFirst, BasePlayer playerSecond, BaseLeague league) {

        countSkill(playerFirst);
        countSkill(playerSecond);
        compareSkill(playerFirst, playerSecond, league);
    }

    private void compareSkill(BasePlayer playerFirst, BasePlayer playerSecond, BaseLeague league) {
        if (playerFirst.getSkillPoints() > playerSecond.getSkillPoints()) {
            plusScore(playerFirst, league);
            minusScore(playerSecond, league);
        } else if (playerFirst.getSkillPoints() < playerSecond.getSkillPoints()) {
            plusScore(playerSecond, league);
            minusScore(playerFirst, league);
        }
    }

    private void countSkill(BasePlayer player) {
        int rnd = randomInt.generate(-10, 10);
        player.setSkillPoints(player.getSkillPoints() + rnd);
    }

    private void plusScore(BasePlayer player, BaseLeague league) {
        player.setScore(player.getScore() + league.getWinPoints());
    }

    private void minusScore(BasePlayer player, BaseLeague league) {
        player.setScore(player.getScore() - league.getWinPoints());
    }
}
