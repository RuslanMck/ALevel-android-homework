package com.Ruslan.ALevel.tournament;

import com.Ruslan.ALevel.ConsoleOutput;
import com.Ruslan.ALevel.league.BaseLeague;
import com.Ruslan.ALevel.league.LeagueFactory;
import com.Ruslan.ALevel.league.Leagues;

import java.util.ArrayList;

public class Tournament {

    LeagueFactory leagueFactory = new LeagueFactory();
    Match match = new Match();
    ArrayList<MatchResult> results = new ArrayList<>();
    ConsoleOutput output = new ConsoleOutput();

    public void startTournament(){
        BaseLeague bronzeLeague = leagueFactory.createLeague(Leagues.BRONZE);
        startLeague(bronzeLeague);
    }

    private void startLeague(BaseLeague league){
        output.startLeague(league);
        for(int i = 0; i < league.getPlayers().size(); i++){
            for (int f = i + 1; f < league.getPlayers().size(); f++){
                output.startMatch(f, league.getPlayers().get(i), league.getPlayers().get(f) );
                results.add(match.startMatch(league.getPlayers().get(i), league.getPlayers().get(f), league));
            }
        }
    }

}
