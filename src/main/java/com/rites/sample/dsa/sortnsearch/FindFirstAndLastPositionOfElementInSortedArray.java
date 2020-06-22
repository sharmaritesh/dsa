package com.rites.sample.dsa.sortnsearch;

/**
 * company google facebook amazon
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * frequency 65%
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        searchRange(nums, target, 0, nums.length - 1, result, true);
        searchRange(nums, target, 0, nums.length - 1, result, false);
        return result;
    }

    private void searchRange(int[] array, int target, int start, int end, int[] result, boolean goLeft) {
        if (start > end) return;

        int mid = (start+end)/2;
        if (array[mid] > target) {
            // Go left
            searchRange(array, target, end, mid-1, result, goLeft);
        } else if (array[mid] < target) {
            // Go right
            searchRange(array, target, mid+1, end, result, goLeft);
        } else {
            // mid is equal to target
            if (goLeft) {
                if (mid == 0 || array[mid-1] != target) {
                    // go further left
                    result[0] = mid;
                } else {
                    searchRange(array, target, start, mid-1, result, goLeft);
                }
            } else {
                if (mid == array.length-1 || array[mid+1] != target) {
                    // go further right
                    result[1] = mid;
                } else {
                    searchRange(array, target, mid+1, end, result, goLeft);
                }
            }
        }
    }
}
