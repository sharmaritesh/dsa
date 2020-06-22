package com.rites.sample.dsa.list;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists2(LinkedList l1, LinkedList l2) {
        LinkedList dummy = new LinkedList(-1);

        LinkedList prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // one of the list not null here so
        if (l1 == null) prev.next = l2;
        else prev.next = l1;

        return dummy.next;
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // prev = null
        // p1 : 2 6 7 8
        // p2 : 1 3 4 5 9 10

        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;
        LinkedList prev = null;

        while (p1 != null && p2 != null) {
            if (p1.value >= p2.value) {
                if (prev != null) prev.next =p2;
                prev = p2;
                p2 = p2.next;
                prev.next = p1;
            } else {
                prev = p1;
                p1 = p1.next;
            }
        }

        if (p1 == null) {
            prev.next = p2;
        }

        return headOne.value < headTwo.value ? headOne : headTwo;
    }
}
