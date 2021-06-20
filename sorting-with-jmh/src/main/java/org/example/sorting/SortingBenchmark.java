package org.example.sorting;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortingBenchmark {
    @State(Scope.Thread)
    public static class BenchmarkInput {
        @Setup(Level.Invocation)
        public void setup() {
            alreadySortedList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
            alreadySortedListBackwards = new ArrayList<>(List.of(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
            smallRandomArrayList = new ArrayList<>(List.of(1, 45, 2, 5, 3, 1, 23, 4, 5, 34, 45, 45, 2, 18, 3, 1, 45, 1));
            largeRandomArrayList = new ArrayList<>(List.of(6, 22, 234, 234, 24, 634, 46, 423, 4, 23, 42, 99, 87, 12, 345, 0, 1, 43, 22, 55, 642,
                    123, 434, 777, 10, 14, 66, 43, 976, 23, 24, 634, 46, 423, 4, 23, 42, 99, 87, 12, 123, 434, 777, 10, 14, 66, 43, 976, 23, 24, 634, 46,
                    234, 24, 634, 46, 423, 4, 23, 42, 99, 87, 12, 123, 434, 777, 10, 14, 66, 43, 976, 23, 24, 634, 46, 423, 4, 23, 42, 99, 87, 12, 123, 434, 777, 10, 14, 66,
                    0, 19, 54, 32, 111, 134, 5435, 34, 786, 66, 44, 22, 66, 22, 1, 2, 7, 10, 43, 34, 65, 222, 444, 21, 97, 100, 765, 23, 22, 1, 5, 7, 100, 43,
                    55, 66, 210, 43, 4554, 21, 454, 7567, 10, 43, 12, 456, 123, 45, 23, 45, 123, 4564, 123, 345, 100, 2, 45, 7, 5, 10, 5, 12, 1, 43));

        }

        public ArrayList<Integer> smallRandomArrayList;
        public ArrayList<Integer> largeRandomArrayList;
        public ArrayList<Integer> alreadySortedList;
        public ArrayList<Integer> alreadySortedListBackwards;
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void bubbleSortSmallRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithBubbleSort(input.smallRandomArrayList);

        blackhole.consume(input.smallRandomArrayList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void bubbleSortLargeRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithBubbleSort(input.largeRandomArrayList);

        blackhole.consume(input.largeRandomArrayList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void bubbleSortAlreadySortedList(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithBubbleSort(input.alreadySortedList);

        blackhole.consume(input.alreadySortedList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void bubbleSortAlreadySortedListBackwards(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithBubbleSort(input.alreadySortedListBackwards);

        blackhole.consume(input.alreadySortedListBackwards);
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

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void insertionSortSmallRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithInsertionSort(input.smallRandomArrayList);

        blackhole.consume(input.smallRandomArrayList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void insertionSortLargeRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithInsertionSort(input.largeRandomArrayList);

        blackhole.consume(input.largeRandomArrayList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void insertionSortAlreadySortedList(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithInsertionSort(input.alreadySortedList);

        blackhole.consume(input.alreadySortedList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void insertionSortAlreadySortedListBackwards(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithInsertionSort(input.alreadySortedListBackwards);

        blackhole.consume(input.alreadySortedListBackwards);
    }

    public static void sortingWithInsertionSort(final List<Integer> randomList) {
        for (int i = 1; i < randomList.size(); i++) {
            int j = i;

            while (j > 0 && randomList.get(j) < randomList.get(j - 1)) {
                Collections.swap(randomList, j, j - 1);
                j--;
            }
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void selectionSortSmallRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithSelectionSort(input.smallRandomArrayList);

        blackhole.consume(input.smallRandomArrayList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void selectionSortLargeRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithSelectionSort(input.largeRandomArrayList);

        blackhole.consume(input.largeRandomArrayList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void selectionSortAlreadySortedList(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithSelectionSort(input.alreadySortedList);

        blackhole.consume(input.alreadySortedList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void selectionSortAlreadySortedListBackwards(final Blackhole blackhole, final BenchmarkInput input) {
        sortingWithSelectionSort(input.alreadySortedListBackwards);

        blackhole.consume(input.alreadySortedListBackwards);
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

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void mergeSortSmallRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        final List<Integer> sortedList = sortingWithMergeSort(input.smallRandomArrayList);

        blackhole.consume(sortedList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void mergeSortLargeRandomArray(final Blackhole blackhole, final BenchmarkInput input) {
        final List<Integer> sortedList = sortingWithMergeSort(input.largeRandomArrayList);

        blackhole.consume(sortedList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void mergeSortAlreadySortedList(final Blackhole blackhole, final BenchmarkInput input) {
        final List<Integer> sortedList = sortingWithMergeSort(input.alreadySortedList);

        blackhole.consume(sortedList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 2, time = 10)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void mergeSortAlreadySortedListBackwards(final Blackhole blackhole, final BenchmarkInput input) {
        final List<Integer> sortedList = sortingWithMergeSort(input.alreadySortedListBackwards);

        blackhole.consume(sortedList);
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


