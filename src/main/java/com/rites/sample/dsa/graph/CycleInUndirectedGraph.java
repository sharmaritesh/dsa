package com.rites.sample.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleInUndirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        final boolean cyc = detectCycle(graph);
        System.out.println(cyc);
    }

    static boolean detectCycle(Graph graph) {
        DisjointSet disjointSet = new DisjointSet();
        for (Integer vertex : graph.allVertexes()) {
            if (vertex != null) disjointSet.makeSet(vertex);
        }

        final Map<Integer, Integer> edges = graph.getEdges();
        for (Map.Entry<Integer, Integer> edge : edges.entrySet()) {
            final boolean created = disjointSet.union(edge.getKey(), edge.getValue());
            if (!created) {
                return true;
            }
        }
        return false;
    }

    static class Graph {
        private Map<Integer, List<Integer>> adjancyList;
        private Map<Integer, Integer> edges;

        public Graph() {
            adjancyList = new HashMap<>();
            edges = new HashMap<>();
        }

        void addEdge(Integer n1, Integer n2) {
            final List<Integer> edgesFromN1 = adjancyList.getOrDefault(n1, new ArrayList<>());
            edgesFromN1.add(n2);
            adjancyList.put(n1, edgesFromN1);

            // reverse map
            final List<Integer> edgesFromN2 = adjancyList.getOrDefault(n2, new ArrayList<>());
            edgesFromN2.add(n1);
            adjancyList.put(n2, edgesFromN2);

            edges.put(n1, n2);
        }

        public Map<Integer, Integer> getEdges() {
            return edges;
        }

        Set<Integer> allVertexes() {
            return adjancyList.keySet();
        }

        List<Integer> getAdjacentVertexes(Integer vertex) {
            return adjancyList.getOrDefault(vertex, new ArrayList<>());
        }
    }
}
