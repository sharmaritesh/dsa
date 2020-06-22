package com.rites.sample.dsa.array;

import java.util.Arrays;

/**
 * company google amazon microsoft apple facebook
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/sort-colors/
 * frequency 65%
 */
public class SortColors {

    public static void main(String[] args) {
        //1,0,1,1,2,2
        //1,0,2,0,1,1
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int l = nums.length;
        int p0 = 0, p2 = l - 1;

        int current = 0;
        while (current <= p2) {
            if (nums[current] == 0) swap(nums, current++, p0++);
            else if (nums[current] == 1) current++;
            else swap(nums, current, p2--);
        }
    }

    static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
