package com.rites.sample.dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * company google facebook amazon adobe
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/single-number-ii/submissions/
 * frequency 50%
 */
public class SingleNumber {
    /**
     * Time - O(nlogn) for sorting :(
     * Space - O(n)
     */
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 2) {
            int num = nums[i];
            if (num != nums[i+1] || num != nums[i+2]) return num;
            i = i+3;
        }

        if (i >= nums.length-1) return nums[nums.length-1];
        else return nums[0];
    }

    /**
     * Time - O(n)
     * Space - O(n)
     */
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int c = count.getOrDefault(num, 0);
            if (++c == 3) count.remove(num);
            else count.put(num, c);
        }
        return count.keySet().iterator().next();
    }

    /**
     * Time - O(n)
     * Space - O(d) d = unique digits ~ n/3 i.e. O(n)
     */
    public int singleNumber3(int[] nums) {
        Set<Long> unique = new HashSet<>();
        long sum = 0;
        for (int num : nums) {
            unique.add((long)num);
            sum = sum + num;
        }


        // 3*(a+b+c) - (3a+3b+c) = 2c
        long sumSet = 0;
        for (Long i : unique) {
            sumSet = sumSet+i;
        }

        return (int)((3*sumSet - sum)/2);
    }
}
