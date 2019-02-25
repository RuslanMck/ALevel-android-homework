package com.Ruslan.ALevel.tournament;

import com.Ruslan.ALevel.ConsoleOutput;
import com.Ruslan.ALevel.league.BaseLeague;
import com.Ruslan.ALevel.league.LeagueFactory;
import com.Ruslan.ALevel.league.Leagues;
import com.Ruslan.ALevel.player.BasePlayer;

import java.util.ArrayList;

public class Tournament {

    private LeagueFactory leagueFactory = new LeagueFactory();
    private Match match = new Match();
    private ArrayList<GamesResult> leagueResults = new ArrayList<>();
    private ArrayList<BasePlayer> tournamentResults = new ArrayList<>();
    private ConsoleOutput output = new ConsoleOutput();
    private Statistics statistics = new Statistics();

    private BaseLeague bronzeLeague = leagueFactory.createLeague(Leagues.BRONZE, 6);
    private BaseLeague silverLeague = leagueFactory.createLeague(Leagues.SILVER, 6);
    private BaseLeague goldLeague = leagueFactory.createLeague(Leagues.GOLD, 6);

    public void startTournament() {

        startLeague(bronzeLeague);
        startLeague(silverLeague);
        startLeague(goldLeague);
        getStatistics();
    }

    private void startLeague(BaseLeague league) {
        int matchNumb = 1;
        output.startLeague(league);
        for (int i = 0; i < league.getPlayers().size(); i++) {
            for (int f = i + 1; f < league.getPlayers().size(); f++) {
                output.startMatch(matchNumb, league.getPlayers().get(i), league.getPlayers().get(f));
                matchNumb++;
                leagueResults.add(match.startMatch(league.getPlayers().get(i), league.getPlayers().get(f), league));
            }
        }
        tournamentResults.addAll(league.getPlayers());
    }

    private void getStatistics() {
        statistics.getStatistics(bronzeLeague.getPlayers(), 3, bronzeLeague.getLeagueType());
        statistics.getStatistics(silverLeague.getPlayers(), 3, silverLeague.getLeagueType());
        statistics.getStatistics(goldLeague.getPlayers(), 3, goldLeague.getLeagueType());
        statistics.getStatistics(tournamentResults, 5, Leagues.ALL);
    }
}
