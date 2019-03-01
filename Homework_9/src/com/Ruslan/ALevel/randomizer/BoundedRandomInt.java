package com.Ruslan.ALevel.randomizer;

import java.util.Random;

public class BoundedRandomInt {
    /**
     * Generate random int in bounds, that you initialize in methods constructor.
     * @param min
     * @param max
     * @return random int
     */

    public int generate(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
