package fightersFactory.knightsKastle;

import fighters.HollyKnight;
import fighters.Knight;

public interface KnightsFactory {
    Knight createKnight();
    Knight createRandomKnight();
}
