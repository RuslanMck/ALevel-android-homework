package fightersFactory.knightsKastle;

import fighters.HollyKnight;
import fighters.Knight;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class HollyKastle implements KnightsFactory {

    boolean isHolly;
    RandomName randomName;
    BoundedRandomDouble randomDouble;
    BoundedRandomInt randomInt;

    public HollyKastle(boolean isHolly) {
        this.isHolly = isHolly;
    }

    @Override
    public Knight createKnight() {
        if (isHolly) return createRandomHollyKnight();
        else return createRandomKnight();
    }

    @Override
    public Knight createRandomKnight() {
        return new Knight(randomName.setRandomName(), randomInt.generate(100, 120), randomInt.generate(15, 20), randomDouble.generate(0.1, 1),
                randomDouble.generate(0.1, 1));
    }

    public Knight createRandomHollyKnight() {
        return new HollyKnight(randomName.setRandomName(), randomInt.generate(100, 120), randomInt.generate(15, 20), randomDouble.generate(0.1, 1),
                randomDouble.generate(0.1, 1), randomInt.generate(10,20));
    }
}
