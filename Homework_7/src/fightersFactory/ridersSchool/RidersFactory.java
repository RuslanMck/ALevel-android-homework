package fightersFactory.ridersSchool;

import fighters.DragonRider;

public interface RidersFactory {
    DragonRider createRider();
    DragonRider createRandomRider();
}
