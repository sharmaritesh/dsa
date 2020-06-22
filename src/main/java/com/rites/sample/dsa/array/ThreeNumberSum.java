package com.rites.sample.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * company google
 * topic array
 * category easy
 * leetcode https://leetcode.com/problems/two-sum/
 */
public class ThreeNumberSum {

    /**
     * Approach 1
     * O(n2) i.e. n square
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // O(nlogn)

        for (int i=0; i < nums.length; i++) {
            int num = nums[i];

            int leftIdx = i+1;
            int rightIdx = nums.length - 1;
            while (leftIdx < rightIdx) {
                int targetSum = num + nums[leftIdx] + nums[rightIdx];
                if (targetSum == 0) {
                    result.add(Arrays.asList(num, nums[leftIdx], nums[rightIdx]));
                } else if (targetSum < 0) {
                    leftIdx++;
                } else {
                    rightIdx--;
                }
            }
        }

        return result;
    }

    /**
     * TODO :
     * Approach 2
     * O(n2) i.e. n square
     * For each number num, we use 2Sum approach and try to find two elements having sum = -num.
     * Once we found it, we store triplet in hashSet for uniqueness
     */
}
