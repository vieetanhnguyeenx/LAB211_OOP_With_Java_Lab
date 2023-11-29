package bo;

public class ArrayDisplayer {
    public ArrayDisplayer() {

    }
    public void displayArray(int[] array, String message) {
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
}
