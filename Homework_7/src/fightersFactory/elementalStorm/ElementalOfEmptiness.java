package fightersFactory.elementalStorm;

import fighters.Elemental;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class ElementalOfEmptiness implements ElementalFactory {

    RandomName randomName;
    BoundedRandomInt randomInt;
    BoundedRandomDouble randomDouble;

    public ElementalOfEmptiness() {
    }

    @Override
    public Elemental createElemental() {
        return createRandomElemental();
    }

    @Override
    public Elemental createRandomElemental() {
        return new Elemental(randomName.setRandomName(), randomInt.generate(1000,2000), randomInt.generate(25,30),
                randomDouble.generate(0.1,1), null);
    }
}
