package chapter9;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution96 {
    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            list.add((int)(Math.random() * 1000));
        }

        stopwatch.start();
        Collections.sort(list);
        stopwatch.stop();

        System.out.println(stopwatch.getElapseTime());
    }

    public static class StopWatch {
        private long startTime;
        private long endTime;

        StopWatch() {
            this.startTime = System.currentTimeMillis();
        }

        public void start() {
            startTime = System.currentTimeMillis();
        }

        public void stop() {
            endTime = System.currentTimeMillis();
        }

        public long getElapseTime() {
            return endTime - startTime;
        }
    }
}
