package com.rites.sample.dsa.tree;

import java.util.List;

/**
 *  topic BST
 *  category easy
 */
public class BSTTraversal {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public void inOrder(List<Integer> traversal) {
            if (left != null) {
                left.inOrder(traversal);
            }
            traversal.add(value);
            if (right != null) {
                right.inOrder(traversal);
            }
        }

        public void preOrder(List<Integer> traversal) {
            traversal.add(value);
            if (left != null) {
                left.preOrder(traversal);
            }
            if (right != null) {
                right.preOrder(traversal);
            }
        }

        public void postOrder(List<Integer> traversal) {
            if (left != null) {
                left.postOrder(traversal);
            }
            if (right != null) {
                right.postOrder(traversal);
            }
            traversal.add(value);
        }

    }
}
