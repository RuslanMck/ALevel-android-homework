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

    private void countRegen(int regenValue) {
        setHealth(getHealth() + (regenValue / 2));
        overHeal(this);
    }

    @Override
    public int attack(BaseFighter opponentTwo) {
        int healthBeforeAttack = opponentTwo.getHealth();
        opponentTwo.takeDamage(this.getAttack());
        int regenValue = healthBeforeAttack - opponentTwo.getHealth();
        countRegen(regenValue);
        return this.getAttack();
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setFullHP(this);
    }
}