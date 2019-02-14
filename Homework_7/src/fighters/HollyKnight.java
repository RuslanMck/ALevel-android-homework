package fighters;

import fighters.base.BaseFighter;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

public class HollyKnight extends Knight implements PostFightActions, PreFightActions {

    int heal;

    public HollyKnight(String name, int health, int attack, double defense, double shield, int heal) {
        super(name, health, attack, defense, shield);
        this.heal = heal;
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        if (getHealth() - takenDamage > heal && getHealth() < getFullHP()) {
            setHealth(getHealth() + heal);
            overHeal(this);
        }
    }



    @Override
    public void actionWithFight(BaseFighter fighter) {
        setFullHP(this);
    }
}