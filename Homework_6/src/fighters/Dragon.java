package fighters;

import fighters.base.BaseFighter;
import fighters.base.ElementPower;
import fighters.base.PreFightActions;

public class Dragon extends BaseFighter implements ElementPower, PreFightActions {

    Elements[] elements;
    private int pureAttack;

    public Dragon(String name, int health, int attack, double defense, Elements[] elements) {
        super(name, health, attack, defense);
        this.elements = elements;
        this.pureAttack = attack;
    }

    /**
     * Create a byte mask from dragon's elemental power using ENUMs.
     *
     * @return byteMask
     */
    @Override
    public int getElementPower() {
        int byteMask = 0;
        for (Elements i : elements) {
            byteMask |= i.getValue();
        }
        return byteMask;
    }

    public void countAttack(BaseFighter fighter) {
        int bonusAttack = getPowerMultiplier(fighter instanceof ElementPower ? ((ElementPower) fighter).getElementPower() : 0);
        setAttack(getAttack() * bonusAttack);
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setAttack(getPureAttack());
        setFullHP(this);
        countAttack(fighter);
    }

    public int getPureAttack() {
        return pureAttack;
    }
}