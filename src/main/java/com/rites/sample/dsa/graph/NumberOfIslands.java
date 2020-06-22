package com.rites.sample.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 0, 0},
                {1, 0, 1},
        };

        final int numOfIslands = numOfIslands(grid);
        System.out.println(numOfIslands);
    }

    static int numOfIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        List<Integer> islands = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) continue;

                if (grid[i][j] == 1) {
                    islands.add(1);
                }
                traverseNode(i, j, grid, visited, islands);
            }
        }

        return islands.size();
    }

    static private void traverseNode(int i, int j, int[][] grid, boolean[][] visited, List<Integer> islands) {
        List<Node> nodesToBeTraversed = new ArrayList<>();
        nodesToBeTraversed.add(new Node(i, j));

        while (!nodesToBeTraversed.isEmpty()) {
            final Node node = nodesToBeTraversed.get(nodesToBeTraversed.size() - 1);
            nodesToBeTraversed.remove(nodesToBeTraversed.size() - 1);

            if (visited[node.i][node.j]) continue;
            visited[node.i][node.j] = true;

            if (grid[node.i][node.j] == 0) {
                continue;
            }

            final List<Node> neighbours = getNeighbours(node.i, node.j, grid, visited);
            nodesToBeTraversed.addAll(neighbours);
        }
    }

    static private List<Node> getNeighbours(int i, int j, int[][] grid, boolean[][] visited) {
        final List<Node> neighbours = new ArrayList<>();
        if (i > 0 && !visited[i-1][j]) neighbours.add(new Node(i-1, j));
        if (i < grid.length-1 && !visited[i+1][j]) neighbours.add(new Node(i+1, j));
        if (j > 0 && !visited[i][j-1]) neighbours.add(new Node(i, j-1));
        if (j < grid[i].length-1 && !visited[i][j+1]) neighbours.add(new Node(i, j+1));
        return neighbours;
    }

    static class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return i+","+j;
        }
    }
}
