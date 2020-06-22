package com.rites.sample.dsa.string;

import java.util.HashMap;
import java.util.Map;

/**
 * company google
 * topic string
 * category hard
 * gfg
 * leetcode
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * Approach : Is to maintain index of every character's last seen index.
     * If character encountered again then stop
     * O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 0};

        int startIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (lastSeen.containsKey(c)) {
                int lastSeenIdx = lastSeen.get(c);
                startIdx = Math.max(startIdx, lastSeenIdx + 1);
                lastSeen.put(c, i);
            }

            if ((longest[1]-longest[0]) < i+1 - startIdx) {
                longest[0] = startIdx;
                longest[1] = i+1;
            }
        }

        return s.substring(longest[0], longest[1]).length();
    }
}
