package controller;

import bo.ArrayDisplayer;
import bo.ArrayGenerator;
import bo.BubbleSort;
import bo.SortInputter;

public class SortController {
    private BubbleSort bubbleSort;
    private SortInputter sortInputter;
    private ArrayGenerator arrayGenerator;
    private ArrayDisplayer arrayDisplayer;

    public SortController() {
        bubbleSort = new BubbleSort();
        sortInputter = new SortInputter();
        arrayGenerator = new ArrayGenerator();
        arrayDisplayer = new ArrayDisplayer();
    }

    public void bubbleSort() {
        int arrayLength = sortInputter.enterNumberOfArray("Enter number of array:",
                1,
                Integer.MAX_VALUE);

        int array[] = arrayGenerator.randomArray(arrayLength, arrayLength, false);
        arrayDisplayer.displayArray(array, "Unsorted array:");

        int sortedArray[] = bubbleSort.sort(array, false);
        arrayDisplayer.displayArray(sortedArray, "Sorted array:");

    }
}
