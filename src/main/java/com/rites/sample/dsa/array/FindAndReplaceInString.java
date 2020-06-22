package com.rites.sample.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 * company google microsoft linkedin
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/find-and-replace-in-string/
 * frequency 30%
 */
public class FindAndReplaceInString {

    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = {0,2};
        String[] sources = {"a","cd"};
        String[] targets = {"eee","ffff"};

        S = "vmokgggqzp";
        indexes = new int[]{3,5,1}; // IMP question : indexes may not be sorted
        sources = new String[] {"kg","ggq","mo"};
        targets = new String[] {"s","so","bfr"};


        System.out.println(findReplaceString(S, indexes, sources, targets));
    }

    public static String findReplaceString(String S, int[] indexes,
                                    String[] sources, String[] targets) {

        Map<Integer, Replacement> validReplacements = new HashMap<>();

        // figure out replacement candidates first
        for (int i = 0; i < indexes.length; i++) {
            int idx = indexes[i];

            if (S.substring(idx, idx + sources[i].length()).equals(sources[i])) {
                validReplacements.put(idx, new Replacement(idx, sources[i], targets[i]));
            }
        }

        // now since you have found replacements,
        // start iterating char by char and if you find a replacement for an index then add new target
        // and increment index by source string.
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < S.length()) {
            if (validReplacements.containsKey(idx)) {
                sb.append(validReplacements.get(idx).getTarget());
                idx = idx + validReplacements.get(idx).getSourceLength();
            } else {
                sb.append(S.charAt(idx++));
            }
        }

        return sb.toString();
    }

    static class Replacement {
        int index;
        int sourceLength;
        String target;

        Replacement(int index, String source, String target) {
            this.index = index;
            this.sourceLength = source.length();
            this.target = target;
        }

        String getTarget() {
            return target;
        }

        int getSourceLength() {
            return sourceLength;
        }
    }
}
