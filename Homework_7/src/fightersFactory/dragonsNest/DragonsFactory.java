package fightersFactory.dragonsNest;

import fighters.Dragon;

public interface DragonsFactory {
    Dragon createDragon();
    Dragon createRandomDragon();
}
