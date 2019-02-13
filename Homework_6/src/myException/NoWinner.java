package myException;

import fighters.base.BaseFighter;

public class NoWinner extends Exception {

    BaseFighter winner;

    /**
     * This exception is handle situation when, by the time of 10th both fighters have same health. Exception is chooses winner randomly.
     *
     * @param opponentOne
     * @param opponentTwo
     */
    public NoWinner(BaseFighter opponentOne, BaseFighter opponentTwo) {
        double random = Math.round(Math.random());
        BaseFighter result;
        if (random > 0.5) result = opponentOne;
        else result = opponentTwo;
        this.winner = result;
    }

    public BaseFighter getWinner() {
        return winner;
    }
}
