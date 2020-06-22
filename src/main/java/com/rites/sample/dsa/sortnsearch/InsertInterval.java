package com.rites.sample.dsa.sortnsearch;

import java.util.LinkedList;

/**
 * company google facebook amazon
 * topic sort and search
 * category hard
 * leetcode https://leetcode.com/problems/insert-interval/
 * frequency 70%
 */
public class InsertInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 5}};
//        int[] newInterval = {2, 7};
//        int[][] intervals = {{1, 5}};
//        int[] newInterval = {6, 8};

        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 3};

        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();

        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            idx = i;
            result.add(interval);

            if (interval[1] > newInterval[0]) {
                break;
            }
        }

        // insert newInterval
        checkAndMerge(newInterval, result);

        for (int i = idx; i < intervals.length; i++) {
            int[] interval = intervals[i];
            checkAndMerge(interval, result);
        }

        return result.toArray(new int[0][]);
    }

    private static void checkAndMerge(int[] interval, LinkedList<int[]> result) {
        int[] lastInterval = result.isEmpty() ? null : result.getLast();
        if (result.isEmpty() || lastInterval[1] < interval[0]) {
            result.add(interval);
        } else {
            lastInterval[1] = Math.max(lastInterval[1], interval[1]);
        }
    }
}
