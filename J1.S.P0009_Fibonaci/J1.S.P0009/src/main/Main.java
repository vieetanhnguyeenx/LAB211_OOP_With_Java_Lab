package main;

public class Main {
    public static void main(String[] args) {
        // Display message
        System.out.println("The 45 sequence fibonacci:");

        // Display displays 45 sequence Fibonacci
        displayFibonacci(0, 1, 45);

    }

    private static void displayFibonacci(int lower, int higher, int term) {
        int f0 = lower;
        int f1 = higher;
        int fn = 0;

        // Loop to display sequence of fibonacci
        for (int i = 0; i < term; i++) {
            if (i < 2)
                System.out.print(i + ", ");
            else {
                fn = f0 + f1;
                f0 = f1;
                f1 = fn;
                if (i == term - 1)
                    System.out.print(fn + "\n");
                else
                    System.out.print(fn + ", ");

            }
        }
    }
}
