package fightersFactory.knightsKastle;

import fighters.Knight;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class DarkCastle implements KnightsFactory {

    boolean isDark;
    RandomName randomName;
    BoundedRandomInt randomInt;
    BoundedRandomDouble randomDouble;

    public DarkCastle(boolean isDark) {
        this.isDark = isDark;
    }

    @Override
    public Knight createKnight() {
        if (isDark) return createRandomDarkKnight();
        else return createRandomKnight();
    }

    @Override
    public Knight createRandomKnight() {
        return new Knight(randomName.setRandomName(), randomInt.generate(100, 120), randomInt.generate(15, 20), randomDouble.generate(0.1, 1),
                randomDouble.generate(0.1, 1));
    }

    public Knight createRandomDarkKnight() {
        return new Knight(randomName.setRandomName(), randomInt.generate(90, 100), randomInt.generate(10, 15), randomDouble.generate(0.1, 1),
                randomDouble.generate(0.1, 1));
    }
}
