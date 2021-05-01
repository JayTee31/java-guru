import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution73 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter the integers between 1 and 50:");

        while (true) {
            final int enteredNumber = input.nextInt();

            if (enteredNumber == 0) {
                break;
            } else {
                numbers.add(enteredNumber);
            }
        }
        countNumberOccurrencesInSortedList(sortNumbersInList(numbers));
    }

    public static void countNumberOccurrencesInSortedList(final ArrayList<Integer> sortedList) {
        for (int i = 0; i < sortedList.size(); i++) {
            int occurrencesCounter = 1;

            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).equals(sortedList.get(j)) && i != sortedList.size() - 1) {
                    occurrencesCounter++;
                    i++;
                } else {
                    break;
                }
            }

            if (occurrencesCounter > 1) {
                System.out.printf("%d occurs %d times\n", sortedList.get(i), occurrencesCounter);
            } else {
                System.out.printf("%d occurs %d time\n", sortedList.get(i), occurrencesCounter);
            }
        }
    }

    public static ArrayList<Integer> sortNumbersInList(final ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
