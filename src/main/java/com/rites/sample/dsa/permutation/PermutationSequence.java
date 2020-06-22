package com.rites.sample.dsa.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * company facebook amazon
 * topic permutation
 * category hard
 * leetcode https://leetcode.com/problems/permutation-sequence/submissions/
 * frequency 35%
 */
public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation2(4, 9));

//        System.out.println(getPermutation(8, 5));
//        System.out.println(getPermutation2(8, 5));
    }

    /**
     * Explaination
     * Approach is to convert K in factorial system and then finding out the kth number using it.
     * e.g. n = 4, k = 9
     *
     * Step 1 : First calculate all factorials value from 0 to n-1
     * nums = [1, 2, 3, 4]
     * factorials = [1, 1, 2, 3]
     *
     * Step 2 : compute factorial representation of k (rather k-1)
     * k = 8 => 2×3! + 1×2! + 0×1! + 0×0! = (2,1,0,0)
     * kFactRepresentation = (2,1,0,0)
     * This array represents the indexes of the elements in nums array.
     *
     * Step 3 : Construct the Permutation from its Factorial Representation
     * iterate over (2,1,0,0) and remove element from nums basis on the index.
     *
     * idx = 2, nums = [1, 2, 3, 4], string = 3, nums = [1, 2, 4]
     * idx = 1, nums = [1, 2, 4], string = 32, nums = [1, 4]
     * idx = 0, nums = [1, 4], string = 321, nums = [4]
     * idx = 0, nums = [4], string = 3214, nums = []
     * DONE :)
     */
    // O(n-sq)
    public static String getPermutation2(int n, int k) {
        // store factorial values in n-1 array
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList(){{add(1);}};

        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            // generate factorial system bases 0!, 1!, ..., (n - 1)!
            factorials[i] = factorials[i-1] * i;

            // generate nums 1, 2, ..., n
            nums.add(i+1);
        }

        // factorial system works with -1 !!
        --k;

        // compute factorial representation of k
        int temp = k;
        int[] kFactRepresentation = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (temp >= factorials[i]) {
                kFactRepresentation[n-1-i] = temp / factorials[i];
                temp = temp % factorials[i];
            } else {
                kFactRepresentation[n-1-i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int position = kFactRepresentation[i];
            sb.append(nums.get(position));
            nums.remove(position);
        }
        return sb.toString();
    }

    public static String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList() {{add(1);}};

        factorials[0] = 1;
        for(int i = 1; i < n; ++i) {
            // generate factorial system bases 0!, 1!, ..., (n - 1)!
            factorials[i] = factorials[i - 1] * i;
            // generate nums 1, 2, ..., n
            nums.add(i + 1);
        }

        // fit k in the interval 0 ... (n! - 1)
        --k;

        // compute factorial representation of k
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > -1; --i) {
            int idx = k / factorials[i];
            k -= idx * factorials[i];

            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
}
