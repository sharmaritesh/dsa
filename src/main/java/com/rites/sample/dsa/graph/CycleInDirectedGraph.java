package com.rites.sample.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleInDirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(4, null);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        final boolean cyc = detectCycle(graph);
        System.out.println(cyc);
    }

    static boolean detectCycle(Graph graph) {
        Set<Integer> unvisitedNodes = new HashSet<>();
        Set<Integer> visitingNodes = new HashSet<>();
        Set<Integer> visitedNodes = new HashSet<>();

        final Set<Integer> nodes = graph.allVertexes();
        nodes.forEach(n -> unvisitedNodes.add(n));

        while (!unvisitedNodes.isEmpty()) {
            final Integer node = unvisitedNodes.iterator().next();
            final boolean cycleFound = dfs(graph, node, unvisitedNodes, visitingNodes, visitedNodes);
            if (cycleFound) return true;
        }
        return false;
    }

    static boolean dfs(Graph graph, Integer node, Set<Integer> unvisitedNodes, Set<Integer> visitingNodes, Set<Integer> visitedNodes) {
        // if this is node is already being visiting then there is a cycle
        if (visitingNodes.contains(node)) return true;
        if (visitedNodes.contains(node)) return false;

        visitingNodes.add(node);
        final List<Integer> adjacentVertexes = graph.getAdjacentVertexes(node);
        if (!adjacentVertexes.isEmpty()) {
            for (Integer adjacentVertex : adjacentVertexes) {
                boolean cycleFound = dfs(graph, adjacentVertex, unvisitedNodes, visitingNodes, visitedNodes);
                if (cycleFound) return true;
            }
        }
        unvisitedNodes.remove(node);
        visitedNodes.add(node);
        return false;
    }

    static class Graph {
        private Map<Integer, List<Integer>> edges;

        public Graph() {
            edges = new HashMap<>();
        }

        void addEdge(Integer n1, Integer n2) {
            final List<Integer> edgesFromN1 = edges.getOrDefault(n1, new ArrayList<>());
            edgesFromN1.add(n2);
            edges.put(n1, edgesFromN1);
        }

        Set<Integer> allVertexes() {
            return edges.keySet();
        }

        List<Integer> getAdjacentVertexes(Integer vertex) {
            return edges.getOrDefault(vertex, new ArrayList<>());
        }
    }
}
