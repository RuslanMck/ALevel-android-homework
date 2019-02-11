package fighters;

import fighters.base.BaseFighter;
import fighters.base.FightBreakAction;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

public class DragonRider extends BaseFighter implements PostFightActions, FightBreakAction, PreFightActions {

    Dragon dragonPet = null;
    private int pureAttack;

    public DragonRider(String name, int health, int attack, double defense) {
        super(name, health, attack, defense);
        pureAttack = attack;
    }

    public void countHealth() {
        setHealth(getHealth() + dragonPet.getHealth());
    }

    public void countAttack() {
        setAttack(getAttack() + dragonPet.getAttack());
    }

    private boolean isDragonAlive() {
        return getHealth() > getFullHP();
    }

    @Override
    public void action(BaseFighter opponent, int takenDamage) {
        if (!isDragonAlive()) {
            setAttack(getPureAttack());
        }
    }

    public int getPureAttack() {
        return pureAttack;
    }

    @Override
    public void actionWithFight(BaseFighter fighter, FightCallBack callBack) {
        if (!isDragonAlive() && fighter instanceof Dragon) {
            dragonPet = (Dragon) fighter;
            countAttack();
            countHealth();
            System.out.println("Fighter " + this.getName() + " tamed the dragon \n");
            callBack.fightImmediatelyDone(this);
        } else {
            setFullHP(this);
        }
    }

    @Override
    public void actionWithFight(BaseFighter fighter) {
        if (getHealth() < getFullHP()) {
            setHealth(getFullHP());
        }
    }
}