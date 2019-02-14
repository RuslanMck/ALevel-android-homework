package fighters;

import fighters.base.BaseFighter;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;
import myException.FightImmediatelyDone;

public class DragonRider extends BaseFighter implements PostFightActions, PreFightActions {

    Dragon dragonPet;
    private int pureAttack;

    public DragonRider(String name, int health, int attack, double defense, Dragon dragonPet) {
        super(name, health, attack, defense);
        this.dragonPet = dragonPet;
        this.pureAttack = attack;
    }

    public void countHealth() {
        setHealth(getHealth() + dragonPet.getHealth());
    }

    public void countAttack() {
        setAttack(getAttack() + dragonPet.getAttack());
    }

    private boolean isDragonAlive() {
        return dragonPet != null;
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
    public void actionWithFight(BaseFighter fighter) throws FightImmediatelyDone {
        if (!isDragonAlive() && fighter instanceof Dragon) {
            dragonPet = (Dragon) fighter;
            countAttack();
            countHealth();
            System.out.println("Fighter " + this.getName() + " tamed the dragon" + fighter.getName() + "\n");
            throw new FightImmediatelyDone(this);
        } else {
            setFullHP(this);
        }
    }
}