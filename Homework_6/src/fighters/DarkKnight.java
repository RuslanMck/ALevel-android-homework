package fighters;

import fighters.base.BaseFighter;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

public class DarkKnight extends BaseFighter implements PostFightActions, PreFightActions {
    public DarkKnight(String name, int health, int attack, double defense) {
        super(name, health, attack, defense);
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        setHealth(getHealth() + ((getFullHP() - getHealth()) / 2));
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setFullHP(this);
    }
}