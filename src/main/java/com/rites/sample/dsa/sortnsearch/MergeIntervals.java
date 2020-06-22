package com.rites.sample.dsa.sortnsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * company google facebook amazon
 * topic sort and search
 * category medium
 * leetcode https://leetcode.com/problems/merge-intervals/
 * frequency 70%
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
//        Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]

        // nlogn
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size()-1)[1] < interval[0]) {
                result.add(interval);
            } else {
                final int[] lastInterval = result.get(result.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }
        return result.toArray(new int[0][]);
    }
}
