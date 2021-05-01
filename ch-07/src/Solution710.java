import java.util.Scanner;

public class Solution710 {
    public static void main(String[] args) {
        final int NUMBER_OF_INPUTS = 10;
        final Scanner input = new Scanner(System.in);
        final double[] array = new double[NUMBER_OF_INPUTS];

        System.out.println("Enter ten numbers: ");

        for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
            array[i] = input.nextDouble();
        }

        System.out.printf("The largest element is: %s, and its index is: %s", determineLargestElementAndItsIndex(array)[0],
                determineLargestElementAndItsIndex(array)[1]);

        /* System.out.printf("The largest element is: %f, and its index is: %d", determineLargestElement(array),
                determineIndexOfLastLargestElement(array, determineLargestElement(array)));

         */
    }

    /* However the book suggest to use int return type for the method, i think a String[] array is better / more fun to use,
    because in that way the problem can be solved with one single method, instead of two.
    (1. method return double type largestElement, 2. method return int type indexOfLargestElement.)

    I know, a simple String return type is an option too, but we learn about arrays, so i decided to use String[] array instead.

    Anyway, i made an another solution with a twist, see it below. :D
     */


    /* In that String[] array the first element (index = 0) is the largest element of an array, and the second element (index = 1)
    is the index of the last largest element of an array.
     */

    public static String[] determineLargestElementAndItsIndex(final double[] array) {
        String[] largestElementAndItsIndex = new String[2];
        double largestElement = array[0];
        int indexOfLargestElement = 0;

        for (int i = 1; i < array.length; i++) {
            if (largestElement <= array[i]) {
                largestElement = array[i];
                indexOfLargestElement = i;
            }
        }

        largestElementAndItsIndex[0] = String.valueOf(largestElement);
        largestElementAndItsIndex[1] = String.valueOf(indexOfLargestElement);

        return largestElementAndItsIndex;
    }

    /*
    public static int determineIndexOfLastLargestElement(final double[] array, final double itsLargestElement) {
        int indexOfLastLargestElement = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (itsLargestElement == array[i]) {
                indexOfLastLargestElement = i;
            }
        }
        return indexOfLastLargestElement;
    }

    public static double determineLargestElement(final double[] array) {
        if (array == null || array.length == 0) {
            return -1
        }

        double largestElement = array[0];

        for (double value : array) {
            if (largestElement < value) {
                largestElement = value;
            }
        }
        return largestElement;
    }
    */
}
