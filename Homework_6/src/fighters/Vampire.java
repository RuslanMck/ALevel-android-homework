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

    private void countRegen(int regenValue) {
        setHealth(getHealth() + regenValue);
        setAttack(getAttack() + (regenValue / 2));
        overHeal(this);
    }

    @Override
    public int attack(BaseFighter opponent) {
        int healthBeforeAttack = opponent.getHealth();
        opponent.takeDamage(this.getAttack());
        int regenValue = healthBeforeAttack - opponent.getHealth();
        countRegen(regenValue);
        return this.getAttack();
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        setAttack(getPureAttack());
        setFullHP(this);
    }

    public int getPureAttack() {
        return pureAttack;
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        setAttack(getPureAttack());
    }
}
