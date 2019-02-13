package fighters;

import fighters.base.BaseFighter;
import fighters.base.ElementPower;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

public class Elemental extends BaseFighter implements ElementPower, PostFightActions, PreFightActions {
    Elements[] elements;
    private int pureAttack;

    public Elemental(String name, int health, int attack, double defense, Elements[] elements) {
        super(name, health, attack, defense);
        this.elements = elements;
        pureAttack = attack;
    }

    @Override
    public int getElementPower() {
        int byteMask = 0;
        for (Elements i : elements) {
            byteMask |= i.getValue();
        }
        return byteMask;
    }

    @Override
    public int attack(BaseFighter opponent) {
        int healthBeforeAttack = opponent.getHealth();
        opponent.takeDamage(this.getAttack());
        int regenValue = healthBeforeAttack - opponent.getHealth();
        if (findSimilar(opponent)) countRegen(regenValue);
        return this.getAttack();
    }

    private void countRegen(int regenValue) {
        setHealth(getHealth() + (regenValue * 2));
        overHeal(this);
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        if (findSimilar(opponent)) setHealth(getHealth() + (takenDamage / 2));
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setFullHP(this);
    }
}
