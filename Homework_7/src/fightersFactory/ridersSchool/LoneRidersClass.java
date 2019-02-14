package fightersFactory.ridersSchool;

import fighters.DragonRider;
import fightersFactory.dragonsNest.DragonsFactory;
import fightersFactory.randomizer.BoundedRandomDouble;
import fightersFactory.randomizer.BoundedRandomInt;
import fightersFactory.randomizer.RandomName;

public class LoneRidersClass implements RidersFactory {

    RandomName randomName = new RandomName();
    BoundedRandomInt randomInt = new BoundedRandomInt();
    BoundedRandomDouble randomDouble= new BoundedRandomDouble();

    public LoneRidersClass() {
    }

    @Override
    public DragonRider createRider() {
        return createRandomRider();
    }

    @Override
    public DragonRider createRandomRider() {
        return new DragonRider(randomName.setRandomName(), randomInt.generate(100, 120), randomInt.generate(10,15),
                randomDouble.generate(0.1,1), null);
    }
}
