package tournament;

import arena.Arena;
import arena.PrintResult;
import fighters.base.BaseFighter;

public class Tour {

    Arena arena = new Arena();
    PrintResult result = new PrintResult();

    public void createAllFighters() {

        BaseFighter[][] fighters = createFightersBarrack();
        startTournament(fighters);
    }

    public void startTournament(BaseFighter[][] fighters) {
        int f = 0;
        int a = 1;
        for (int i = 0; i < fighters.length - 1; i++) {
            for (int j = 0; j < fighters[i].length; j++) {
                fighters[a][f] = arena.fight(fighters[i][j], fighters[i][++j]);
                f++;
            }

            if (i == fighters.length - 2) {
                System.out.println("Winner ");
                result.printResult(fighters[a]);
            } else {
                System.out.println("Tour " + a);
                result.printResult(fighters[a]);
                System.out.println("\n");
            }
            a++;
            f = 0;
        }
    }

    public BaseFighter[][] createFightersBarrack() {
        FightersCreator creator = new FightersCreator();
        BaseFighter[] listOfFighters = creator.createFighters();

        int arrayLength = 0;
        for (int a = listOfFighters.length; a % 2 == 0; ) {
            a = a / 2;
            arrayLength++;
        }
        BaseFighter[][] fighters = new BaseFighter[arrayLength + 1][];

        int s = listOfFighters.length;
        for (int i = 0; i < fighters.length; i++) {
            fighters[i] = new BaseFighter[s];
            s = s / 2;
        }
        fighters[0] = listOfFighters;
        return fighters;
    }
}