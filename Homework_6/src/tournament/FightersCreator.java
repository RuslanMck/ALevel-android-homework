package tournament;

import fighters.*;
import fighters.base.BaseFighter;
import fighters.base.ElementPower;

public class FightersCreator {

    public BaseFighter[] createFighters() {

        Elemental elemental1 = new Elemental("Elemental1", 100, 15, 0.1, new ElementPower.Elements[]{ElementPower.Elements.WATER});
        Vampire vampire1 = new Vampire("Vampire1", 50, 10, 0.1);
        SupremeVampire supremeVampire1 = new SupremeVampire("supremeVampire1", 55, 10, 0.3);
        Knight knight2 = new Knight("knight2", 100, 20, 0.2, 0.3);
        HollyKnight holly2 = new HollyKnight("holly2", 100, 30, 0.3, 15);
        DarkKnight dark3 = new DarkKnight("dark3", 100, 35, 0.4);
        Vampire vampire2 = new Vampire("Vampire2", 53, 5, 0.1);
        DarkKnight dark4 = new DarkKnight("dark4", 100, 35, 0.4);
        DragonRider rider1 = new DragonRider("rider1", 100, 20, 0.2);
        Dragon dragon1 = new Dragon("dragon1", 100, 20, 0.2, new ElementPower.Elements[]{ElementPower.Elements.WATER, ElementPower.Elements.FIRE});
        Dragon dragon2 = new Dragon("dragon2", 100, 25, 0.2, new ElementPower.Elements[]{ElementPower.Elements.WATER, ElementPower.Elements.FIRE, ElementPower.Elements.EARTH});
        HollyKnight holly1 = new HollyKnight("holly1", 100, 20, 0.2, 5);
        DarkKnight dark1 = new DarkKnight("dark1", 100, 30, 0.2);
        Knight knight1 = new Knight("knight1", 100, 15, 0.2, 0.1);
        Dragon dragon3 = new Dragon("dragon3", 100, 27, 0.2, new ElementPower.Elements[]{ElementPower.Elements.WATER, ElementPower.Elements.FIRE});
        DarkKnight dark2 = new DarkKnight("dark2", 100, 25, 0.2);

        BaseFighter[] fighters = {dragon2, rider1, elemental1, supremeVampire1,  dragon1, vampire2, dark3, vampire1, holly1, dark1, knight1, dark4, dragon3, dark2, knight2, holly2};
        return fighters;
    }
}