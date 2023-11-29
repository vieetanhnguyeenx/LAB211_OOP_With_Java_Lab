package bo;

import java.util.Random;

public class ArrayGenerator {
    public ArrayGenerator() {

    }

    public int[] randomArray(int length, int bound, boolean isHavePositive) {
        Random random = new Random();
        int realBound = Math.abs(bound);
        int array[] = new int[length];

        // Generate random integer with modify and assign to each array element
        for (int i = 0; i < array.length; i++) {
            int d = random.nextBoolean() && isHavePositive ? -1 : 1;
            array[i] = d * (random.nextInt(realBound));
        }
        return array;
    }
}
