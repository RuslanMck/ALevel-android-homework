package fightersFactory.randomizer;

import java.util.Random;

public class BoundedRandomDouble {

    /**
     * Generate random double in bounds, that you initialize in methods constructor.
     * @param min
     * @param max
     * @return random double
     */
    public double generate(double min, double max){
        return (Math.random()*((max - min)+1) + min);
    }
}
