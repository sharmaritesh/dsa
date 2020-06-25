package com.rites.sample.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * company facebook amazon microsoft
 * topic tree
 * category medium
 * leetcode https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagTraversal {

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n15 = new TreeNode(15);
        TreeNode n20 = new TreeNode(20);
        n20.left = n15; n20.right = n7;
        TreeNode n9 = new TreeNode(9);
        TreeNode n3 = new TreeNode(3);
        n3.left = n9; n3.right = n20;

        zigzagLevelOrder(n3);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (i == size - 1) result.add(level);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) reverse(result.get(i));
        }
        return result;
    }

    private static void reverse(List<Integer> list) {
        Collections.reverse(list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return val+"";
        }
    }
}
