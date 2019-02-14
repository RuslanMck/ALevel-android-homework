package fightersFactory.elementalStorm;

import fighters.Elemental;
import fighters.base.ElementPower;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class NatureElemental implements ElementalFactory {

    ElementPower.Elements elements;
    RandomName randomName;
    BoundedRandomInt randomInt;
    BoundedRandomDouble randomDouble;

    public NatureElemental(ElementPower.Elements elements) {
        this.elements = elements;
    }

    @Override
    public Elemental createElemental() {
        return createRandomElemental();
    }

    @Override
    public Elemental createRandomElemental() {
        return new Elemental(randomName.setRandomName(), randomInt.generate(100,120), randomInt.generate(20,30),
                randomDouble.generate(0.1, 1), new ElementPower.Elements[]{elements});
    }
}
