package arena;

import fighters.base.BaseFighter;
import fighters.base.PostFightActions;
import fighters.base.PreFightActions;

import java.util.zip.DataFormatException;

public class Arena {

    /**
     * @param opponentOne first fighter
     * @param opponentTwo second fighter
     * @return return winner, or null when both are dead
     */
    public BaseFighter fight(BaseFighter opponentOne, BaseFighter opponentTwo) {
        int roundsCount = 0;

        final BaseFighter[] winner = {null}; //holder for callback result

        winner[0] = preRoundActions(opponentOne, opponentTwo);
        if (winner[0] != null) return winner[0];
        winner[0] = preRoundActions(opponentTwo, opponentOne);
        if (winner[0] != null) return winner[0];

        while (roundsCount <= 10) {

            int takenDamage2 = opponentOne.attack(opponentTwo);
            int takenDamage1 = opponentTwo.attack(opponentOne);

            postRoundActions(opponentOne, opponentTwo, takenDamage2);
            postRoundActions(opponentTwo, opponentOne, takenDamage1);

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
                }
            }
        }
        return null;
    }

    private BaseFighter preRoundActions(BaseFighter opponentOne, BaseFighter opponentTwo) {
        if (opponentOne instanceof PreFightActions) {
            try {
                ((PreFightActions) opponentOne).actionWithFight(opponentTwo);
            } catch (DataFormatException e) {
                return opponentOne;
            }
        }
        return null;
    }

    private void postRoundActions(BaseFighter opponentOne, BaseFighter opponentTwo, int damageTakenByOpponentTwo) {
        if (opponentOne instanceof PostFightActions)
            ((PostFightActions) opponentOne).action(opponentTwo, damageTakenByOpponentTwo);

    }
}