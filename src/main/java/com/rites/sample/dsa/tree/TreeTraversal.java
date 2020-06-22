package com.rites.sample.dsa.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  topic tree
 *  category easy
 */
public class TreeTraversal {

    static class Node {
        String name;
        List<Node> children;

        public void dfs(List<String> traversal) {
            traversal.add(name);
            if (children != null) {
                for (Node child : children) {
                    child.dfs(traversal);
                }
            }
        }

        public void bfs(List<String> traversal) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                final Node node = queue.poll();
                traversal.add(node.name);
                queue.addAll(node.children);
            }
        }
    }
}
