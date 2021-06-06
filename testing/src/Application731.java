import java.util.Arrays;
import java.util.Scanner;

public class Application731 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter list1 size and contents");
        final int[] list1 = new int[input.nextInt()];

        for (int i = 0; i < list1.length; i++) {
            list1[i] = input.nextInt();
        }

        System.out.println("Enter list2 size and contents");
        final int[] list2 = new int[input.nextInt()];

        for (int i = 0; i < list2.length; i++) {
            list2[i] = input.nextInt();
        }

        System.out.println(Arrays.toString(mergeLists(list1, list2)));
    }

    public static int[] mergeLists(final int[] list1, final int[] list2) {
        if (list1.length == 0 || list2. length == 0) {
            throw new IllegalArgumentException("lists should contain 1 or more elements");
        }

        final int LENGTH_OF_MERGED_LIST = list1.length + list2.length;
        final int[] mergedList = new int[LENGTH_OF_MERGED_LIST];
        final int[] smallerList;
        final int[] largerList;

        if (list1.length != list2.length) {
            smallerList = findSmallerList(list1, list2);
            largerList = findLargerList(list1, list2);
        } else {
            smallerList = list1;
            largerList = list2;
        }

        int smallerListIndexChangerInLoop = 0;
        int largerListIndexChangerInLoop = 0;

        for (int i = 0; smallerListIndexChangerInLoop < Math.min(smallerList.length, largerList.length)
                && largerListIndexChangerInLoop < Math.max(smallerList.length, largerList.length); i++) {

            if (smallerList[smallerListIndexChangerInLoop] <= largerList[largerListIndexChangerInLoop]) {
                mergedList[i] = smallerList[smallerListIndexChangerInLoop];
                smallerListIndexChangerInLoop++;
            } else {
                mergedList[i] = largerList[largerListIndexChangerInLoop];
                largerListIndexChangerInLoop++;
            }
        }

        for (int i = smallerListIndexChangerInLoop + largerListIndexChangerInLoop; i < LENGTH_OF_MERGED_LIST; i++) {
            if (smallerList.length == smallerListIndexChangerInLoop) {
                mergedList[i] = largerList[largerListIndexChangerInLoop];
                largerListIndexChangerInLoop++;
            } else {
                mergedList[i] = smallerList[smallerListIndexChangerInLoop];
                smallerListIndexChangerInLoop++;
            }
        }
        return mergedList;
    }

    public static int[] findLargerList(final int[] list1, final int[] list2) {
        if (list1.length > list2.length) {
            return list1;
        } else {
            return list2;
        }
    }

    public static int[] findSmallerList(final int[] list1, final int[] list2) {
        if (list1.length < list2.length) {
            return list1;
        } else {
            return list2;
        }
    }
}