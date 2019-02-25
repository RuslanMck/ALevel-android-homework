package com.Ruslan.ALevel.tournament;

import com.Ruslan.ALevel.league.BaseLeague;
import com.Ruslan.ALevel.player.BasePlayer;
import com.Ruslan.ALevel.statistics.ConsoleOutput;
import com.Ruslan.ALevel.statistics.Statistics;

public class PlayersTransfer {

    private Statistics statistics = new Statistics();
    private ConsoleOutput output = new ConsoleOutput();

    public void checkTransferUp(BaseLeague firstLeague, BaseLeague secondLeague) {
        BasePlayer player;
        statistics.topScore(firstLeague.getPlayers());
        statistics.topScore(secondLeague.getPlayers());

        for (int i = 0; i < firstLeague.getPlayers().size(); i++) {
            if (firstLeague.getPlayers().get(i).getScore() > firstLeague.getWinPoints() * 3) {
                player = firstLeague.getPlayers().get(i);
                secondLeague.getPlayers().add(player);
                firstLeague.getPlayers().remove(i);
                i = 0;
                output.playerTransfer(player, secondLeague);
            }
        }
    }

    public void checkTransferDown(BaseLeague firstLeague, BaseLeague secondLeague) {
        BasePlayer player;
        statistics.topScore(firstLeague.getPlayers());
        statistics.topScore(secondLeague.getPlayers());
        for (int i = 0; i < firstLeague.getPlayers().size(); i++) {
            if (firstLeague.getPlayers().get(i).getScore() < firstLeague.getWinPoints()) {
                player = firstLeague.getPlayers().get(i);
                secondLeague.getPlayers().add(player);
                firstLeague.getPlayers().remove(i);
                output.playerTransfer(player, secondLeague);
            }
        }
    }
}
