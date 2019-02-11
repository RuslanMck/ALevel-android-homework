package fighters.base;

public interface PreFightActions {
    void actionWithFight(BaseFighter fighter);

    default void setFullHP(BaseFighter fighter) {
        fighter.setHealth(fighter.getFullHP());
    }
}