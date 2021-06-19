package org.example.sorting;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingBenchmark {
    @State(Scope.Thread)
    public static class BenchmarkInput {
        @Setup(Level.Invocation)
        public void setup() {
            System.out.println("asd");
            randomArrayList = new ArrayList<>(List.of(1, 45, 2, 5, 3, 1, 23,4, 5, 34, 45, 45, 2,1, 2, 3, 1, 1, 45, 2, 5, 3, 1, 23,4, 5, 34, 45, 45, 2,1, 2, 3, 1, 1, 45, 2, 5, 3, 1, 23,4, 5, 34, 45, 45, 2,1, 2, 3, 1));
            randomLinkedList = new LinkedList<>(List.of(1, 45, 2, 5, 3, 1, 23,4, 5, 34, 45, 45, 2,1, 2, 3, 1, 1, 45, 2, 5, 3, 1, 23,4, 5, 34, 45, 45, 2,1, 2, 3, 1, 1, 45, 2, 5, 3, 1, 23,4, 5, 34, 45, 45, 2,1, 2, 3, 1));
        }

        public ArrayList<Integer> randomArrayList;
        public LinkedList<Integer> randomLinkedList;
    }

    @Benchmark
    public void arrayListSort(final Blackhole blackhole, final BenchmarkInput input) {
        Collections.sort(input.randomArrayList);

        blackhole.consume(input.randomArrayList);
    }

    @Benchmark
    public void linkedListSort(final Blackhole blackhole, final BenchmarkInput input) {
        Collections.sort(input.randomLinkedList);

        blackhole.consume(input.randomLinkedList);
    }
}


