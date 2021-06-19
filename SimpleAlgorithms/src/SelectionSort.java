import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        final List<Integer> randomList = new ArrayList<>(List.of(1, 5, 6, 10, 2, 4, 22, 66, 42, 111111, 99, 10, 2, 4, 8, 0, 7, 77));

        sortingWithSelectionSort(randomList);

        System.out.println(randomList);
    }

    public static void sortingWithSelectionSort(final List<Integer> randomList) {
        for (int i = 0; i < randomList.size() - 1; i++) {
            int indexOfTheMinimum = i;
            int minimum = randomList.get(i);

            for (int j = i + 1; j < randomList.size(); j++) {
                if (randomList.get(j) < minimum) {
                    minimum = randomList.get(j);
                    indexOfTheMinimum = j;
                }
            }
            if (minimum != randomList.get(i)) {
                Collections.swap(randomList, i, indexOfTheMinimum);
            }
        }
    }
}