package player;

import league.Leagues;
import randomizer.BoundedRandomInt;
import randomizer.RandomName;

public class PlayersFactory {

    BoundedRandomInt randomInt = new BoundedRandomInt();
    RandomName randomName = new RandomName();

    public BasePlayer createPlayer(Leagues leagues){
        switch (leagues) {
            case BRONZE:
                return new BasePlayer (randomName.setRandomName(), randomInt.generate(18,35), randomInt.generate(5,15));
            case SILVER:
                return new BasePlayer (randomName.setRandomName(), randomInt.generate(18,35), randomInt.generate(16,25));
            case GOLD:
                return new BasePlayer (randomName.setRandomName(), randomInt.generate(18,35), randomInt.generate(26,35));
        }
        return null;
    }

}
