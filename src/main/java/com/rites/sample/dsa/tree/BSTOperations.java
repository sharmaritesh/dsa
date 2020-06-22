package com.rites.sample.dsa.tree;

/**
 *  topic BST
 *  category easy
 */
public class BSTOperations {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }

            return this;
        }

        public boolean contains(int value) {
            if (value < this.value) {
                if (left != null) {
                    return left.contains(value);
                } else {
                    return false;
                }
            } else if (value > this.value){
                if (right != null) {
                    return right.contains(value);
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public BST remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value){
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                // ah, we found the value
                if (left != null && right != null) {
                    // root node
                    // find the min value in the right sub-tree
                    int minValue = right.findMinValue();
                    this.value = minValue;
                    right.remove(minValue, this);
                } else if (parent == null) {
                    // root node
                    if (left != null) {
                        this.value = left.value;
                        this.right = left.right;
                        this.left = left.left;
                    } else if (right != null){
                        this.value = right.value;
                        this.left = right.left;
                        this.right = right.right;
                    }
                } else if (parent.left == this) {
                    // this handles a leaf node as well as node with single child
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }
            return this;
        }

        public int findMinValue() {
            BST currentNode = this;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
            return currentNode.value;
        }
    }


}
