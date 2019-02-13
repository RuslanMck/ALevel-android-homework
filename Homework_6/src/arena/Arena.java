package arena;

import fighters.base.BaseFighter;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;
import myException.FightImmediatelyDone;
import myException.NoWinner;

public class Arena {

    /**
     * @param opponentOne first fighter
     * @param opponentTwo second fighter
     * @return return winner, or null when both are dead
     */
    public BaseFighter fight(BaseFighter opponentOne, BaseFighter opponentTwo) {
        int roundsCount = 0;

        try {
            preRoundActions(opponentOne, opponentTwo);
            preRoundActions(opponentTwo, opponentOne);
        } catch (FightImmediatelyDone e) {
            return e.getWinner();
        }

        while (roundsCount <= 10) {

            int takenDamage2 = opponentOne.attack(opponentTwo);
            int takenDamage1 = opponentTwo.attack(opponentOne);

            postRoundActions(opponentOne, opponentTwo, takenDamage2);
            postRoundActions(opponentTwo, opponentOne, takenDamage1);

            try {
                if (opponentOne.isAlive() && opponentTwo.isAlive()) {
                    roundsCount++;
                } else if (opponentOne.isAlive()) {
                    return opponentOne;
                } else if (opponentTwo.isAlive()) {
                    return opponentTwo;
                }
                if (roundsCount == 10) {
                    if (opponentOne.getHealth() > opponentTwo.getHealth()) {
                        return opponentOne;
                    } else if (opponentTwo.getHealth() > opponentOne.getHealth()) {
                        return opponentTwo;
                    } else if (opponentOne.getHealth() == opponentTwo.getHealth()) {
                        throw new NoWinner(opponentOne, opponentTwo);
                    }
                }
            } catch (NoWinner e) {
                return e.getWinner();
            }
        }
        return null;
    }

    private BaseFighter preRoundActions(BaseFighter opponentOne, BaseFighter opponentTwo) throws FightImmediatelyDone {
        if (opponentOne instanceof PreFightActions) {
            ((PreFightActions) opponentOne).actionWithFight(opponentTwo);
        }
        return null;
    }

    private void postRoundActions(BaseFighter opponentOne, BaseFighter opponentTwo, int damageTakenByOpponentTwo) {
        if (opponentOne instanceof PostFightActions)
            ((PostFightActions) opponentOne).action(opponentTwo, damageTakenByOpponentTwo);

    }
}