package fightersFactory;

import fighters.base.BaseFighter;
import fightersFactory.dragonsNest.DragonsFactory;
import fightersFactory.dragonsNest.OneElementDragonFactory;
import fightersFactory.elementalStorm.ElementalFactory;
import fightersFactory.elementalStorm.NatureElemental;
import fightersFactory.knightsKastle.DarkCastle;
import fightersFactory.knightsKastle.HollyCastle;
import fightersFactory.knightsKastle.KnightsFactory;
import fightersFactory.randomizer.RandomElements;
import fightersFactory.randomizer.RandomFighter;
import fightersFactory.ridersSchool.LoneRidersClass;
import fightersFactory.ridersSchool.RidersFactory;
import fightersFactory.vampireCave.VampireFactory;
import fightersFactory.vampireCave.VampireTomb;

public class RegularFightersFactory implements FightersFactory {

    RandomElements randomElements = new RandomElements();
    RandomFighter randomFighter;

    DragonsFactory dragonsFactory;
    KnightsFactory knightsFactory;
    VampireFactory vampireFactory;
    RidersFactory ridersFactory;
    ElementalFactory elementalFactory;

    public RegularFightersFactory() {
        dragonsFactory = new OneElementDragonFactory(randomElements.generateOne());
        knightsFactory = new HollyCastle(false);
        knightsFactory = new DarkCastle(false);
        vampireFactory = new VampireTomb();
        ridersFactory = new LoneRidersClass();
        elementalFactory = new NatureElemental(randomElements.generateOne());
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