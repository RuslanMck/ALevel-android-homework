package fightersFactory.dragonsNest;

import fighters.Dragon;
import fighters.base.ElementPower;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class OneElementDragonFactory implements DragonsFactory {

    ElementPower.Elements elements;
    RandomName randomName = new RandomName();
    BoundedRandomInt randomInt = new BoundedRandomInt();
    BoundedRandomDouble randomDouble= new BoundedRandomDouble();

    public OneElementDragonFactory(ElementPower.Elements elements) {
        this.elements = elements;
    }

    @Override
    public Dragon createDragon() {
        return createRandomDragon();
    }

    @Override
    public Dragon createRandomDragon() {
        return new Dragon(randomName.setRandomName(),randomInt.generate(100,200), randomInt.generate(15,25), randomDouble.generate(0.1,1),
                new ElementPower.Elements[]{elements});
    }

}

