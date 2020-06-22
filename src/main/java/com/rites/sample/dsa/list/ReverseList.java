package com.rites.sample.dsa.list;

/**
 * company google facebook amazon
 * topic list
 * category easy
 * leetcode https://leetcode.com/problems/reverse-linked-list/submissions/
 * frequency 80%
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public String toString() {
            return value + (next != null ? next.toString() : "null");
        }
    }
}
