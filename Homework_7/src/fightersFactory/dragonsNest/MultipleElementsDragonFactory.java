package fightersFactory.dragonsNest;

import fighters.Dragon;
import fighters.base.ElementPower;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class MultipleElementsDragonFactory implements DragonsFactory {

    ElementPower.Elements[] elements;
    boolean isOneElemental;
    RandomName randomName;
    BoundedRandomInt randomInt;
    BoundedRandomDouble randomDouble;

    public MultipleElementsDragonFactory(ElementPower.Elements[] elements, boolean isOneElemental) {
        this.elements = elements;
        this.isOneElemental = isOneElemental;
    }

    @Override
    public Dragon createDragon() {
        return createRandomDragon();
    }

    @Override
    public Dragon createRandomDragon() {
        return new Dragon(randomName.setRandomName(),randomInt.generate(100,200), randomInt.generate(15,25), randomDouble.generate(0.1,1), elements);
    }
}
