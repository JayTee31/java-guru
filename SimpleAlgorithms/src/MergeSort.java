import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        final List<Integer> randomList = new ArrayList<>(List.of(1, 5, 6, 10, 2, 4, 22, 66, 42, 111111, 99, 10, 2, 4, 8, 0, 7, 77));

        System.out.println(sortingWithMergeSort(randomList));
    }

    public static List<Integer> sortingWithMergeSort(final List<Integer> randomList) {
        List<Integer> firstHalfOfTheList = new ArrayList<>(randomList.subList(0, (int)Math.ceil(randomList.size() / 2.0)));
        List<Integer> secondHalfOfTheList = new ArrayList<>(randomList.subList((int)Math.ceil(randomList.size() / 2.0),
                randomList.size()));

        if (firstHalfOfTheList.size() > 1) {
            firstHalfOfTheList = sortingWithMergeSort(firstHalfOfTheList);
        }

        if (secondHalfOfTheList.size() > 1) {
            secondHalfOfTheList = sortingWithMergeSort(secondHalfOfTheList);
        }

        return mergeLists(firstHalfOfTheList, secondHalfOfTheList);
    }

    public static List<Integer> mergeLists(final List<Integer> list1, List<Integer> list2) {
        final int LENGTH_OF_MERGED_LIST = list1.size() + list2.size();
        final List<Integer> mergedList = new ArrayList<>();
        final List<Integer> smallerList;
        final List<Integer> largerList;

        if (list1.size() > list2.size()) {
            smallerList = list2;
            largerList = list1;
        } else {
            smallerList = list1;
            largerList = list2;
        }

        int smallerListIndexChangerInLoop = 0;
        int largerListIndexChangerInLoop = 0;

        for (int i = 0; smallerListIndexChangerInLoop < Math.min(smallerList.size(), largerList.size())
                && largerListIndexChangerInLoop < Math.max(smallerList.size(), largerList.size()); i++) {

            if (smallerList.get(smallerListIndexChangerInLoop) <= largerList.get(largerListIndexChangerInLoop)) {
                mergedList.add(smallerList.get(smallerListIndexChangerInLoop));
                smallerListIndexChangerInLoop++;
            } else {
                mergedList.add(largerList.get(largerListIndexChangerInLoop));
                largerListIndexChangerInLoop++;
            }
        }

        for (int i = smallerListIndexChangerInLoop + largerListIndexChangerInLoop; i < LENGTH_OF_MERGED_LIST; i++) {
            if (smallerList.size() == smallerListIndexChangerInLoop) {
                mergedList.add(largerList.get(largerListIndexChangerInLoop));
                largerListIndexChangerInLoop++;
            } else {
                mergedList.add(smallerList.get(smallerListIndexChangerInLoop));
                smallerListIndexChangerInLoop++;
            }
        }
        return mergedList;
    }
}
