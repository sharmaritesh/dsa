package com.rites.sample.dsa.string;

/**
 * company google
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public static void main(String[] args) {

    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "";
        }
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        String rnum1 = new StringBuilder(num1).reverse().toString();
        String rnum2 = new StringBuilder(num2).reverse().toString();



        return result.toString();
    }
}
