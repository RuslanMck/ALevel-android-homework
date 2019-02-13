package fighters.base;

import myException.FightImmediatelyDone;

public interface PreFightActions {

    void actionWithFight(BaseFighter fighter) throws FightImmediatelyDone;

    default void setFullHP(BaseFighter fighter) {
        fighter.setHealth(fighter.getFullHP());
    }
}