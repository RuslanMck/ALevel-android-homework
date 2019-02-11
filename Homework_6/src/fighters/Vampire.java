package fighters;

import fighters.base.BaseFighter;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

public class Vampire extends BaseFighter implements PostFightActions, PreFightActions {

    int pureAttack;

    public Vampire(String name, int health, int attack, double defense) {
        super(name, health, attack, defense);
        pureAttack = attack;
    }

    public void countRegen(int takenDamage) {
        setHealth(getHealth() + (takenDamage));
        setAttack(getAttack() + (takenDamage / 2));

        if (getHealth() > getFullHP()) {
            setHealth(getFullHP());
        }
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        countRegen(takenDamage);
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setAttack(getPureAttack());
        setFullHP(this);
    }

    public int getPureAttack() {
        return pureAttack;
    }
}
