package com.rites.sample.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(reconstructQueue(people));
    }

    public static int[][] reconstructQueue(int[][] people) {
        // Solution is to adopt Greedy approach

        // pre-requisite of greedy approach is sorting
        // Step 1 : so sort input basis on height
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2) {
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });

        // Step 2: Add then basis on their position
        List<int[]> resultList = new LinkedList<>();
        for (int[] person : people){
            resultList.add(person[1], person);
        }

        return resultList.toArray(new int[people.length][2]);
    }
}
