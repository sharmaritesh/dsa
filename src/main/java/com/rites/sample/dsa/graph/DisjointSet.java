package com.rites.sample.dsa.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DisjointSet {

    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));


    }

    private Map<Integer, Node> map;

    public DisjointSet() {
        map = new HashMap<>();
    }

    public void makeSet(int data) {
        map.put(data, new Node(data));
    }

    public boolean union(int data1, int data2) {
        final Node node1 = map.get(data1);
        final Node node2 = map.get(data2);

        final Node set1 = findSet(node1);
        final Node set2 = findSet(node2);

        if(set1.equals(set2)) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (set1.rank >= set2.rank) {
            //increment rank only if both sets have same rank
            if (set1.rank == set2.rank) {
                set1.rank += 1;
            }
            set2.parent = set1;
        } else {
            set1.parent = set2;
        }
        return true;
    }

    public int findSet(int data) {
        final Node node = map.get(data);
        return findSet(node).data;
    }

    private Node findSet(Node node) {
        if (node.parent == node) return node;
        // path compression
        node.parent = findSet(node.parent);
        return node.parent;
    }

    static class Node {
        int rank;
        int data;
        Node parent;

        public Node(int data) {
            this.rank = 0;
            this.data = data;
            this.parent = this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return rank == node.rank &&
                    data == node.data &&
                    Objects.equals(parent, node.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rank, data, parent);
        }
    }
}
