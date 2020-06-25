package com.rites.sample.dsa.tree;

/**
 * company facebook amazon google
 * topic tree
 * category hard
 * leetcode https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode root = new TreeNode(-2);
        root.left = n1;

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        return (int) maxPathSumHelper(root).asRoot;
    }

    static Sum maxPathSumHelper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Sum(node.val, node.val);
        }

        Sum lSum = new Sum(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Sum rSum = new Sum(Integer.MIN_VALUE, Integer.MIN_VALUE);

        if (node.left != null) lSum = maxPathSumHelper(node.left);
        if (node.right != null) rSum = maxPathSumHelper(node.right);

        /* as branch */
        long maxOfBranch = Math.max(lSum.asBranch, rSum.asBranch);
        long asBranch = Math.max(maxOfBranch + node.val, node.val);

        /* as root */
        long rootSum = Math.max(asBranch, lSum.asBranch + node.val + rSum.asBranch);
        long asRoot = Math.max(lSum.asRoot, Math.max(rootSum, rSum.asRoot));

        return new Sum(asBranch, (int) asRoot);
    }

    private static class Sum {
        long asBranch;
        long asRoot;

        public Sum() {
            this(0, 0);
        }

        public Sum(long asBranch, long asRoot) {
            this.asBranch = asBranch;
            this.asRoot = asRoot;
        }
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

        @Override
        public String toString() {
            return val + "";
        }
    }
}
