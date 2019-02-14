package fightersFactory.vampireCave;

import fighters.SupremeVampire;
import fighters.Vampire;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class SupremeVampireTomb implements VampireFactory {

    RandomName randomName = new RandomName();
    BoundedRandomInt randomInt = new BoundedRandomInt();
    BoundedRandomDouble randomDouble= new BoundedRandomDouble();

    public SupremeVampireTomb() {
    }

    @Override
    public Vampire createVampire() {
        return createRandomVampire();
    }

    @Override
    public Vampire createRandomVampire() {
        return new SupremeVampire(randomName.setRandomName(), randomInt.generate(50,75),randomInt.generate(10,15),randomDouble.generate(0.1, 1));
    }
}
