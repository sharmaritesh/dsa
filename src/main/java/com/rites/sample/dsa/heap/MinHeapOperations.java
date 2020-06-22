package com.rites.sample.dsa.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeapOperations {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(1);
        queue.add(2);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> values) {

            return null;
        }

        public int peek() {
            return -1;
        }

        public void insert(int value) {

        }

        public void remove(int value) {

        }
    }
}
