package com.rites.sample.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 * company google
 * topic array
 * category easy
 * leetcode https://leetcode.com/problems/two-sum/
 */
public class TwoNumberSum {

    /**
     * Approach :
     * O(n)
     */
    static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            int target = targetSum - i;
            if (map.containsKey(target)) {
                return new int[]{i, target};
            } else {
                map.put(i, i);
            }
        }

        return new int[0];
    }
}
