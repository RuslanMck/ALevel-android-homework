package fightersFactory.vampireCave;

import fighters.Vampire;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class VampireTomb implements VampireFactory {
    RandomName randomName = new RandomName();
    BoundedRandomInt randomInt = new BoundedRandomInt();
    BoundedRandomDouble randomDouble= new BoundedRandomDouble();

    public VampireTomb() {
    }

    @Override
    public Vampire createVampire() {
        return createRandomVampire();
    }

    @Override
    public Vampire createRandomVampire() {
        return new Vampire(randomName.setRandomName(), randomInt.generate(100,115), randomInt.generate(15,25), randomDouble.generate(0.1, 1));
    }
}
