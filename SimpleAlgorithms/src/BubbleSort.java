import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        final List<Integer> randomList = new ArrayList<>(List.of(1, 5, 6, 10, 2, 4, 22, 66, 42, 111111, 99, 10, 2, 4, 8, 0, 7, 77));

        sortingWithBubbleSort(randomList);

        System.out.println(randomList);
    }

    public static void sortingWithBubbleSort(final List<Integer> randomList) {
        for (int i = randomList.size(); i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (randomList.get(j) > randomList.get(j + 1)) {
                    Collections.swap(randomList, j, j + 1);
                }
            }
        }
    }
}
