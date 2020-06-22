package com.rites.sample.dsa.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * company google
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/expressive-words
 * frequency 50%
 */
public class ExpressiveWord {

    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};

        s = "zzzzzyyyyy";
        words = new String[]{"zzyy","zy","zyy"};

        s = "abcd";
        words = new String[]{"abc"};

        System.out.println(expressiveWords(s, words));
    }

    /**
     * O(QK), where Q is the length of words (at least 1), and K is the maximum length of a word.
     * Space O(K)
     */
    public static int expressiveWords(String S, String[] words) {
        // c1 = count of character in actual string
        // c2 = count of character in word

        // total char count doesn't match then not expresssive!!
        // c1 < c2 word is not expresssive
        // c1 >= 3 word is expresssive
        // c1 < 3 then c1 == c2 to be expressive else no !!!

        WordCount source = new WordCount(S);

        int result = 0;
        for (String word : words) {
            WordCount wordCount = new WordCount(word);
            if (!source.charCountMatches(wordCount)) continue;

            boolean match = true;
            for (char c: wordCount.allChars()) {
                int c1 = source.count(c);
                int c2 = wordCount.count(c);

                if (c1 < c2 || c1 < 3 && c1 != c2) {
                    match = false;
                    break;
                }
            }

            // this is our word
            if (match) result++;
        }

        return result;
    }

    static class WordCount {
        String str;
        Map<Character, Integer> map;

        WordCount(String str) {
            this.str = str;
            map = new HashMap<>();
            char[] chars = str.toCharArray();
            for (char c : chars) {
                int count = map.getOrDefault(c, 0);
                map.put(c, ++count);
            }
        }

        boolean charCountMatches(WordCount that) {
            return this.map.size() == that.map.size();
        }

        Set<Character> allChars() {
            return map.keySet();
        }

        int count(char c) {
            return map.getOrDefault(c, 0);
        }
    }
}
