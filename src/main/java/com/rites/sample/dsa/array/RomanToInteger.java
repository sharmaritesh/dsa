package com.rites.sample.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 * company google facebook amazon microsoft apple
 * topic array
 * category easy
 * leetcode https://leetcode.com/problems/roman-to-integer/
 * frequency 65%
 */
public class RomanToInteger {

    public static void main(String[] args) {
//        String s = "MMCMLXXXIX";
//        String s = "CM";
        String s = "III";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
//        MMCMLXXXIX

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        final int length = s.length();
        int i = 0;
        int result = 0;

        // CM i =0 & l ==2
        while (i < length) {
            if (i != length - 1) {
                final String twoString = s.substring(i, i + 2);
                if (twoString != null && map.containsKey(twoString)) {
                    result += map.get(twoString);
                    i = i + 2;
                    continue;
                }
            }

            String singleString = s.substring(i, i + 1);
            result += map.get(singleString);
            i++;
        }

        return result;
    }
}
