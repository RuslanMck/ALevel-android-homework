package league;

import player.PlayesrCreator;

public class LeagueFacroty {

    private PlayesrCreator playesrCreator = new PlayesrCreator();

    public BaseLeague createLeague(Leagues leagues) {
        switch (leagues) {
            case BRONZE:
                return new BaseLeague("Bronze league.", Leagues.BRONZE, playesrCreator.createPlayers(Leagues.BRONZE), 5);
            case SILVER:
                return new BaseLeague("Silver league.", Leagues.SILVER, playesrCreator.createPlayers(Leagues.SILVER), 10);
            case GOLD:
                return new BaseLeague("Gold league.", Leagues.GOLD, playesrCreator.createPlayers(Leagues.GOLD), 15);
        }
        return null;
    }
}
