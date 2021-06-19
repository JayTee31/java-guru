import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        final List<Integer> randomList = new ArrayList<>(List.of(1, 10, 32, 42, 60, 111, 200, 3000));
        final int element = 10;

        System.out.println(isListContainsTheElement(randomList, element));
    }

    public static boolean isListContainsTheElement(final List<Integer> list, final int element) {
        int startIndex = 0;
        int endIndex = list.size() - 1;

        while (startIndex <= endIndex) {
            if (list.get((startIndex + endIndex) / 2) == element) {
                return true;
            } else if (list.get((startIndex + endIndex) / 2) > element) {
                endIndex = (startIndex + endIndex) / 2 - 1;
            } else if (list.get(endIndex / 2) < element) {
                startIndex = (startIndex + endIndex) / 2 + 1;
            }
        }
        return false;
    }
}
