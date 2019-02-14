package fightersFactory;

import fighters.base.BaseFighter;
import fightersFactory.dragonsNest.DragonsFactory;
import fightersFactory.dragonsNest.MultipleElementsDragonFactory;
import fightersFactory.elementalStorm.ElementalFactory;
import fightersFactory.elementalStorm.ElementalOfEmptiness;
import fightersFactory.knightsKastle.DarkCastle;
import fightersFactory.knightsKastle.HollyCastle;
import fightersFactory.knightsKastle.KnightsFactory;
import fightersFactory.randomizer.RandomElements;
import fightersFactory.randomizer.RandomFighter;
import fightersFactory.ridersSchool.DragonRidersClass;
import fightersFactory.ridersSchool.RidersFactory;
import fightersFactory.vampireCave.SupremeVampireTomb;
import fightersFactory.vampireCave.VampireFactory;


public class GreatFightersFactory implements FightersFactory {
    RandomElements randomElements = new RandomElements();
    RandomFighter randomFighter;

    DragonsFactory dragonsFactory;
    KnightsFactory knightsFactory;
    VampireFactory vampireFactory;
    RidersFactory ridersFactory;
    ElementalFactory elementalFactory;

    public GreatFightersFactory() {
        dragonsFactory = new MultipleElementsDragonFactory(randomElements.generateArray());
        knightsFactory = new HollyCastle(true);
        knightsFactory = new DarkCastle(true);
        vampireFactory = new SupremeVampireTomb();
        ridersFactory = new DragonRidersClass();
        elementalFactory = new ElementalOfEmptiness(randomElements.generateOne());
    }

    @Override
    public BaseFighter createFighter(FighterType fighterType) {
        switch (fighterType) {
            case Knight:
                return knightsFactory.createKnight();
            case Dragon:
                return dragonsFactory.createDragon();
            case Rider:
                return ridersFactory.createRider();
            case Vampire:
                return vampireFactory.createVampire();
            case Elemental:
                return elementalFactory.createElemental();
            case Random:
                return getRandomFighter();
        }
        return null;
    }

    @Override
    public BaseFighter getRandomFighter() {
        switch (randomFighter.getRandomFighter()) {
            case Knight:
                return knightsFactory.createKnight();
            case Dragon:
                return dragonsFactory.createDragon();
            case Rider:
                return ridersFactory.createRider();
            case Vampire:
                return vampireFactory.createVampire();
            case Elemental:
                return elementalFactory.createElemental();
        }
        return null;
    }
}

