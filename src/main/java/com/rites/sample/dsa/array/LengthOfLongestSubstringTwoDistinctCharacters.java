package com.rites.sample.dsa.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * company google facebook microsoft amazon
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * leetcode https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 *
 * Description
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Input: "eceba" Output: 3 Explanation: t is "ece" which its length is 3.
 * Input: "ccaabbb" Output: 5 Explanation: t is "aabbb" which its length is 5.
 */
public class LengthOfLongestSubstringTwoDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    /**
     * O(n)
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        final int length = s.length();
        if (length < 3) {
            return length;
        }

        int left = 0, right = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 2;

        while (right < length) {
            if (lastSeen.size() < 3) {
                lastSeen.put(s.charAt(right), right++);
            }

            if (lastSeen.size() == 3) {
                int leftMostIdx = Collections.min(lastSeen.values());
                lastSeen.remove(s.charAt(leftMostIdx));
                left = leftMostIdx + 1;
            }
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
