package fightersFactory.randomizer;

import fighters.base.ElementPower;

import java.util.Random;

public class RandomElements {
    ElementPower.Elements[] elements = new ElementPower.Elements[]{ElementPower.Elements.WIND,
            ElementPower.Elements.WATER, ElementPower.Elements.FIRE, ElementPower.Elements.EARTH};

    public ElementPower.Elements generateOne(){
        Random random = new Random();
        int rnd = random.nextInt(elements.length);
        return elements[rnd];
    }
    public ElementPower.Elements[] generateArray(){
        Random random = new Random();
        int rnd;

        ElementPower.Elements[] result = new ElementPower.Elements[4];

        for (int i = 0; i < 4; i++){
            rnd = random.nextInt(elements.length );
            result[i] = elements[rnd];
        }
        return result;
    }
}
