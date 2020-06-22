package com.rites.sample.dsa.sortnsearch;

import java.util.HashMap;
import java.util.Map;

/**
 * company google facebook amazon
 * topic sort and search
 * category easy
 * leetcode https://leetcode.com/problems/valid-anagram/
 * frequency 60%
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "b"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);

            c  = t.charAt(i);
            count = map.getOrDefault(c, 0);
            map.put(c, count - 1);
        }

        for (int count : map.values()) {
            if (count != 0) return false;
        }

        return true;
    }
}
