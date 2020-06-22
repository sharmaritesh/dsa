package com.rites.sample.dsa.array;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class XCards {

    public static void main(String[] args) {

    }

//    public boolean hasGroupsSizeX(int[] deck) {
//        Map<Integer, Integer> count = new HashMap<>();
//
//        for (int c : deck) {
//            count.put(c, count.getOrDefault(c, 0) + 1);
//        }
//
//        int gcd = -1;
//        Collection<Integer> values = count.values();
//        int gcd = findGCD(values);
//
//        if (gcd ==1) return false;
//        for (int v : values) {
//            if (v % gcd != 0) return false;
//        }
//        return true;
//    }

//    int findGCD(Collection<Integer> nums) {
//        int result = nums.get(0);
//        for (int i = 1; i < nums.length(); i++){
//            result = gcd(nums.get(i), result);
//            if(result == 1) {
//                return 1;
//            }
//        }
//        return result;
//    }
//
//    int gcd(int a, int b) {
//        if (a == 0) return b;
//        return gcd(b % a, a);
//    }
}
