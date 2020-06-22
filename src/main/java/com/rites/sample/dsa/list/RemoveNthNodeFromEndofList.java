package com.rites.sample.dsa.list;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        final ListNode head = new ListNode(1);
        removeNthFromEnd(head, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 1->2->3->4->5, and n = 2

        ListNode current = head; // first pointer
        ListNode nNode = head; // second pointer

        for (int i = 0; i < n; i++) {
            nNode = nNode.next;
        }

        // head need to be removed
        if (nNode == null) {
            if (head.next != null) {
                head.val = head.next.val;
                head.next = head.next.next;
            } else {
                head = null;
            }
            return head;
        }

        while (nNode.next != null) {
            current = current.next;
            nNode = nNode.next;
        }
        current.next = current.next.next;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
