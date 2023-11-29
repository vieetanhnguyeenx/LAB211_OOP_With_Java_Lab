package bo;

import utils.ArrayUtils;

public class BubbleSort {
    public BubbleSort() {

    }
    public int[] sort(int rawArray[], boolean isAsc) {
        int array[] = ArrayUtils.cloneArray(rawArray);
        for (int i = 0; i < array.length - 1; i++) {
            /*Loop use to accessed first unsorted element to the element
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                if (isAsc) {
                    if (array[j] > array[j+1]) {
                        int tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                    }
                } else {
                    if (array[j] < array[j+1]) {
                        int tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                    }
                }

            }
        }
        return array;
    }
}
