package player;

import league.Leagues;

import java.util.ArrayList;

public class PlayesrCreator {

    private PlayersFactory playersFactory = new PlayersFactory();

    public ArrayList<BasePlayer> createPlayers(Leagues leagues) {
        ArrayList<BasePlayer> players = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            players.add(playersFactory.createPlayer(leagues));
        }
        return players;
    }
}
