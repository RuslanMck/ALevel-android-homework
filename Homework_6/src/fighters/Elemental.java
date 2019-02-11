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
    public void action(BaseFighter opponent, int takenDamage) {
        if (findSimilar(opponent)) {
            setHealth(getHealth() + (takenDamage / 2));
            if (getHealth() < getFullHP()) {
                setHealth(getHealth() + (takenDamage * 2));
            }
            if (getHealth() > getFullHP()) {
                setHealth(getFullHP());
            }
        }
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setFullHP(this);
    }
}
