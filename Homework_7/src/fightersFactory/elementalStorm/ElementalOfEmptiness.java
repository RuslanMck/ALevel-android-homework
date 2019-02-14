package fightersFactory.elementalStorm;

import fighters.Elemental;
import fighters.base.ElementPower;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class ElementalOfEmptiness implements ElementalFactory {
    ElementPower.Elements elements;
    RandomName randomName = new RandomName();
    BoundedRandomInt randomInt = new BoundedRandomInt();
    BoundedRandomDouble randomDouble= new BoundedRandomDouble();

    public ElementalOfEmptiness(ElementPower.Elements elements) {
        this.elements = elements;
    }

    @Override
    public Elemental createElemental() {
        return createRandomElemental();
    }

    @Override
    public Elemental createRandomElemental() {
        return new Elemental(randomName.setRandomName(), randomInt.generate(1000,2000), randomInt.generate(25,30),
                randomDouble.generate(0.1,1), new ElementPower.Elements[]{elements});
    }
}
