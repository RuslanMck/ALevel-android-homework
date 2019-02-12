package fighters.base;

public interface PostFightActions {
    void action(BaseFighter opponent, int takenDamage);


    default void overHeal(BaseFighter fighter) {
        if (fighter.getHealth() > fighter.getFullHP()) {
            fighter.setHealth(fighter.getFullHP());
        }
    }
}