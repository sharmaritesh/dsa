package com.rites.sample.dsa.array;

/**
 * company google facebook
 * topic array
 * category easy
 * leetcode https://leetcode.com/problems/plus-one/
 * frequency 65%
 */
public class PlusOne {

    /**
     * O(n)
     */
    public int[] plusOne(int[] digits) {
        // 129, 192, 99, 123, 999

        for (int i = digits.length-1; i >= 0; i--) {
            // find the last non-nine number
            if (digits[i] == 9) {
                // replace all 9 with 0 occurring after non-nine number
                digits[i] = 0;
            } else {
                // add 1 to it
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        // we are here coz all elements are 9
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
