package com.Ruslan.ALevel.league;

import com.Ruslan.ALevel.player.PlayersCreator;

public class LeagueFactory {

    private PlayersCreator playersCreator = new PlayersCreator();

    public BaseLeague createLeague(Leagues leagues) {
        switch (leagues) {
            case BRONZE:
                return new BaseLeague("Bronze", Leagues.BRONZE, playersCreator.createPlayers(Leagues.BRONZE), 5);
            case SILVER:
                return new BaseLeague("Silver", Leagues.SILVER, playersCreator.createPlayers(Leagues.SILVER), 10);
            case GOLD:
                return new BaseLeague("Gold", Leagues.GOLD, playersCreator.createPlayers(Leagues.GOLD), 15);
        }
        return null;
    }
}
