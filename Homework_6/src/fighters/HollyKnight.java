package fighters;

import fighters.base.BaseFighter;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

public class HollyKnight extends BaseFighter implements PostFightActions, PreFightActions {

    int heal;

    public HollyKnight(String name, int health, int attack, double defense, int heal) {
        super(name, health, attack, defense);
        this.heal = heal;
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        if (getHealth() - takenDamage > heal && getHealth() < getFullHP()) {
            setHealth(getHealth() + heal);
            overHeal();
        }
    }

    public void overHeal() {
        if (getHealth() > getFullHP()) {
            setHealth(getFullHP());
        }
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setFullHP(this);
    }
}