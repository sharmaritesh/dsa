package com.rites.sample.dsa.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * company google amazon facebook microsoft apple oracle
 * topic stack array
 * category easy
 * leetcode https://leetcode.com/problems/valid-parentheses/
 * frequency 75%
 */
public class ValidParentheses {
    public static void main(String[] args) {

    }

    public static boolean isValid(String str) {
        Map<Character, Character> closingBrackets = new HashMap<>();
        closingBrackets.put(')', '(');
        closingBrackets.put(']', '[');
        closingBrackets.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i=0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                // 1st char is closing bracket
                if (stack.size() == 0) return false;
                if (closingBrackets.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // when 1st char is opening bracket n there is not closing bracket for it.
        return stack.size() == 0;
    }
}
