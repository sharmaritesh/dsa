package com.rites.sample.dsa.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * company
 * topic heap
 * category hard
 * gfg
 * leetcode
 */
public class ContinuousMedian {

    public static void main(String[] args) {
        ContinuousMedianHandler handler = new ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        System.out.println(handler.median);
        handler.insert(100);
        System.out.println(handler.median);
    }

    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        public void insert(int number) {
            // which heap to insert value to ?
            if (maxheap.peek() == null || number <= maxheap.peek()) {
                maxheap.add(number);
            } else {
                minheap.add(number);
            }

            // check if there is a difference of exactly 1 element
            int diff = maxheap.size() - minheap.size();
            if (diff > 1) {
                // max heap has more elements
                int n = maxheap.poll();
                minheap.add(n);
            } else if (diff < -1) {
                int n = minheap.poll();
                maxheap.add(n);
            }

            diff = maxheap.size() - minheap.size();
            if (diff == 0) {
                // both heaps has same elements
                median = Double.valueOf(maxheap.peek() + minheap.peek())/2;
            } else if (diff == 1) {
                median = maxheap.peek();
            } else {
                median = minheap.peek();
            }

        }

        public double getMedian() {
            return median;
        }
    }
}
