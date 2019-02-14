package tournament;

import fighters.base.BaseFighter;
import fightersFactory.GreatFightersFactory;
import fightersFactory.RegularFightersFactory;
import fightersFactory.randomizer.RandomFighter;

import java.util.Random;

public class FightersCreator {

    GreatFightersFactory greatFightersFactory = new GreatFightersFactory();
    RegularFightersFactory regularFightersFactory = new RegularFightersFactory();
    RandomFighter randomFighter = new RandomFighter();

    public BaseFighter[] createFighters() {

        BaseFighter[] fighters = new BaseFighter[16];
        Random random = new Random();

        for (int i = 0; i < fighters.length; i++) {
            int rnd = random.nextInt(2);
            if (rnd == 0) {
                fighters[i] = greatFightersFactory.createFighter(randomFighter.getRandomFighter());
            } else if (rnd == 1) {
                fighters[i] = regularFightersFactory.createFighter(randomFighter.getRandomFighter());
            }
        }
        return fighters;
    }
}