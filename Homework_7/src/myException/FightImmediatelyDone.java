package myException;

import fighters.base.BaseFighter;

public class FightImmediatelyDone extends Exception {

    BaseFighter winner;

    public FightImmediatelyDone(BaseFighter winner) {
        this.winner = winner;
    }

    public BaseFighter getWinner() {
        return winner;
    }
}
