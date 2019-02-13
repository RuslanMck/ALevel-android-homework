package fighters.base;

public interface ElementPower {

    enum Elements {
        FIRE(0b0001), WATER(0b0010), EARTH(0b0100), WIND(0b1000);
        private int value;

        Elements(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    int getElementPower();

    /**
     * Compare byte masks of dragons. getPowerMultiplier takes byte mask of calling object and takes second byte mask as a parameter
     * of second object.
     *
     * <ul>
     * <li>Variable int difPower takes result of ^(bitwise XOR).
     * <li>Variable int tempDifPower takes difPower after ~(bitwise compliment).
     * <li>Variable int reverseElements takes tempDifPower after | (bitwise or) of tempDifPower and power.
     * <li>Variable int elements takes reverseElements after ~(bitwise compliment).
     * </ul>
     * Example: first power 1011, second power 0101;
     *
     * <pre>
     *     1011 ^ 0101 = 1110;
     *     ~ 1110 = 0001;
     *     0001 | 0101 = 0101;
     *     ~ 0101 = 1010;
     * </pre>
     * In cycle for method counts number of "passed" elements of byte mask. In example this number os two (number of "1" in byte mask.
     * So the count will equals 2.
     *
     * @param power
     * @return count
     */

    default int getPowerMultiplier(int power) {
        int difPower = getElementPower() ^ power;
        int tempDifPower = ~difPower;
        int reverseElements = tempDifPower | power;
        int elements = ~reverseElements;
        int count = 1;
        for (ElementPower.Elements p : ElementPower.Elements.values()) {
            count += (elements & p.getValue()) > 0 ? 1 : 0;
        }
        return count;
    }

    default int getElementPower(Elements[] elements) {
        int byteMask = 0;
        for (Elements i : elements) {
            byteMask |= i.getValue();
        }
        return byteMask;
    }

    default boolean findSimilar(BaseFighter fighter) {
        boolean result = false;
        if (fighter instanceof ElementPower) {
            result = compareElements(((ElementPower) fighter).getElementPower());
        }
        return result;
    }

    default boolean compareElements(int power) {
        int elements = getElementPower() & power;
        int count = 0;
        for (Elements p : Elements.values()) {
            count += (elements & p.getValue()) > 0 ? 1 : 0;
        }
        if (count == 0) {
            return false;
        } else return true;
    }
}
