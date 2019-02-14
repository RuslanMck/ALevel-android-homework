package fighters;

import fighters.base.BaseFighter;
import fighters.base.ElementPower;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

import java.util.Random;

public class SupremeVampire extends Vampire implements PostFightActions, ElementPower, PreFightActions {

    private Elements[] elementsArray = new Elements[]{Elements.FIRE, Elements.WATER, Elements.EARTH, Elements.WIND};
    private Elements[] elements = new Elements[1];
    private int pureAttack;

    public SupremeVampire(String name, int health, int attack, double defense) {
        super(name, health, attack, defense);
        pureAttack = attack;
    }

    @Override
    public int attack(BaseFighter opponent) {
        return super.attack(opponent);
    }

    private void countBonusAttack(BaseFighter opponent) {
        int bonusAttack = getPowerMultiplier(opponent instanceof ElementPower ? ((ElementPower) opponent).getElementPower() : 0);
        if (!findSimilar(opponent)) {
            bonusAttack = bonusAttack * 3;
            setAttack(getAttack() * bonusAttack);
        } else {
            setAttack(getAttack() * bonusAttack);
        }
    }

    private void resetAttack() {
        setAttack(getPureAttack());
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        resetAttack();
        elements[0] = (getElementFromArray(elementsArray));
        countBonusAttack(opponent);
    }

    @Override
    public int getElementPower() {
        int byteMask = 0;
        if (elements[0] == null) {
            return byteMask;
        } else {
            for (Elements i : elements) {
                byteMask |= i.getValue();
            }
        }
        return byteMask;
    }

    public Elements getElementFromArray(Elements[] elements) {
        int rnd = new Random().nextInt(elements.length);
        return elements[rnd];
    }

    public int getPureAttack() {
        return pureAttack;
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        resetAttack();
    }
}