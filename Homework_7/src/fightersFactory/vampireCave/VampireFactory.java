package fightersFactory.vampireCave;

import fighters.Vampire;

public interface VampireFactory {
    Vampire createVampire();
    Vampire createRandomVampire();
}
