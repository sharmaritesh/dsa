package com.rites.sample.dsa.array;

/**
 * company google amazon
 * topic array
 * category easy
 * leetcode https://leetcode.com/problems/maximize-distance-to-closest-person/
 * frequency 20%
 */
public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
//        int[] seats = {1,0,0,0,1,0,1};
//        int[] seats = {1,0,0,0};
//        int[] seats = {0,0,0,1};
//        int[] seats = {1,0,1,0,1};
//        int[] seats = {1,0,1,0,0,0,1};
        int[] seats = {0,0,1,0,1,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        // [1,0,0,0,1,0,1]
        // [1,0,0,0]
        // [0,0,0,1]
        // [1,0,1,0,1]
        // [1,0,1,0,0,0,1]

        int count = 0;
        int res = 0;
        for (int s : seats) {
            if (s == 1) {
                count = 0;
            } else {
                count++;
                res = Math.max(res, (count+1)/2);
            }
        }

        // this is to handle edge case 0,0,0,1
        for (int i = 0; i < seats.length; ++i)  {
            if (seats[i] == 1) {
                res = Math.max(res, i);
                break;
            }
        }

        // this is to handle edge case 1,0,0,0
        int n = seats.length;
        for (int i = n-1; i >= 0; --i)  {
            if (seats[i] == 1) {
                res = Math.max(res, n - 1 - i);
                break;
            }
        }

        return res;
    }

}
