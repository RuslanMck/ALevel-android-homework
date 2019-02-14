package fightersFactory.randomizer;

import fightersFactory.FighterType;

import java.util.Random;

public class RandomFighter {
    FighterType[] fighters = new FighterType[]{FighterType.Dragon, FighterType.Knight, FighterType.Vampire, FighterType.Rider, FighterType.Elemental};

    public FighterType getRandomFighter(){
        Random random = new Random();
        int rnd = random.nextInt(fighters.length );
        return fighters[rnd];
    }
}
