package arena;

import fighters.base.BaseFighter;

public class PrintResult {

    public void printResult(BaseFighter[] fighters) {

        for (int i = 0; i < fighters.length; i++){
            System.out.print( " | " + fighters[i].getName() + " (" +fighters[i].getClass() + ") "  );
        }
    }
}