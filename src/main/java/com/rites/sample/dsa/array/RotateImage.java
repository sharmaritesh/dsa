package com.rites.sample.dsa.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * company google
 * topic array
 * category medium
 * leetcode https://leetcode.com/problems/rotate-image/
 * frequency 75%
 */
public class RotateImage {

    public static void main(String[] args) {

    }

    /**
     * Step 1 : reverse the matrix
     * Step 2 : transpose matrix
     * O(n2) i.e. n square
     */
    public static void rotate(int[][] matrix) {
        Collections.reverse(Arrays.asList(matrix));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
