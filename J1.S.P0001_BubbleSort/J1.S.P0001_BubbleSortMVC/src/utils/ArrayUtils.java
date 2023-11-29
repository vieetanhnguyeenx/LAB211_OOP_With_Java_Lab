package utils;

public class ArrayUtils {
    public static int[] cloneArray(int array[]) {
        int arrayClone[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayClone[i] = array[i];
        }
        return arrayClone;
    }
}
