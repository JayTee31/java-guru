import java.util.Scanner;

public class Solution719 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        final int[] list = new int[input.nextInt()];

        System.out.println("Enter the list: ");

        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        if (isSortedInDecreasingOrder(list)) {
            System.out.println("The list is already sorted");
        } else {
            System.out.println("The list is not sorted");
        }
    }

    public static boolean isSortedInDecreasingOrder(final int[] list) {
        boolean isSorted = true;

        for (int i = 1; i < list.length; i++) {
            if (list[i] > list[i - 1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}
