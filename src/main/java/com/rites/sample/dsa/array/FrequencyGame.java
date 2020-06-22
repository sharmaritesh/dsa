package com.rites.sample.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 * company google
 * topic array
 * category easy
 * gfg https://practice.geeksforgeeks.org/problems/frequency-game/1
 * leetcode
 */
public class FrequencyGame {

    public static void main(String[] args) {
        // int arr[] = {1, 5, 2, 2, 5, 50, 1};
        int arr[] = {75, 605, 3602, 7398, 9120, 4453, 7711, 9204, 5274, 3833, 9436, 4257, 3797, 5009, 1042, 1749, 183, 7152, 5078, 9152, 7779, 5754, 1457, 6728, 834, 2900, 7504, 3668, 7700, 6443, 2220, 9977, 6664, 856, 140, 7970, 3242, 5187, 5402, 2870, 2045, 2421, 1588, 1429, 4810, 7554, 3940, 5954, 1543, 182, 2274, 5864, 4235, 1695, 1815, 1366, 8833, 5820, 1366, 2668, 2348, 1796, 3239, 5723, 8458, 4650, 8851, 3176, 635, 2464, 6551, 7969, 7395, 2170, 7874, 6739};
        System.out.println(LargButMinFreq(arr));
    }

    public static int LargButMinFreq(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer element : arr)  {
            Integer count = map.getOrDefault(element, 0);
            map.put(element, count + 1);
        }

        int largestNum = Integer.MIN_VALUE;
        int freq = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() > largestNum && entry.getValue() <= freq) {
                largestNum = entry.getKey();
                freq = entry.getValue();
            }
        }

        return largestNum;
    }
}
