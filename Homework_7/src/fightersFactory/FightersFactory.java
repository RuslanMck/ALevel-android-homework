package fightersFactory;

import fighters.base.BaseFighter;

public interface FightersFactory {
    BaseFighter createFighter(FighterType fighterType);
    BaseFighter getRandomFighter();
}
