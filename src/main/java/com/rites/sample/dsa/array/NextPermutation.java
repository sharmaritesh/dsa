package com.rites.sample.dsa.array;

/**
 * company google
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] nums = {1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2; // edge case to handle SINGLE entry array
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length-1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
