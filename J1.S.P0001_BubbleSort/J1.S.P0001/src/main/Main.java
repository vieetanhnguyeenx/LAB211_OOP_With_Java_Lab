package main;

import util.Validation;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Input size number of array
        int arraySize = Validation.getInt("Enter number of array:",
                1,
                Integer.MAX_VALUE);

        int array[] = new int[arraySize];

        // Generate random integer for each array element
        randomArray(array, 10, false);

        // Display unsorted array
        displayArray(array, "Unsorted array:");
        
        // Sort array in increase
        sortArray(array);
        
        // Display sorted array
        displayArray(array, "Sorted array:");
    }

    // Generate random integer for each array element
    private static void randomArray(int[] array, int bound, boolean isHavePositive) {
        Random random = new Random();
        int realBound = Math.abs(bound);

        // Generate random integer with modify and assign to each array element
        for (int i = 0; i < array.length; i++) {
            int d = random.nextBoolean() && isHavePositive ? -1 : 1;
            array[i] = d * (random.nextInt(realBound));
        }
    }

    // Display array with custom message
    private static void displayArray(int[] array, String message) {
        System.out.print(message + " [");
        // Display array
        for (int i = 0; i < array.length; i++) {

            // Special display for the last element of array
            if (i == array.length - 1) {
                System.out.print(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    // Sort using bubble sort algorithm
    private static void sortArray(int[] array) {
        /*Loop use to accessed from the first to last element of array,
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length - 1; i++) {
            /*Loop use to accessed first unsorted element to the element
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
