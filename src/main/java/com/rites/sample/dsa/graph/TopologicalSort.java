package com.rites.sample.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("a", "c");
        graph.addEdge("b", "c");
        graph.addEdge("b", "d");
        graph.addEdge("d", "f");
        graph.addEdge("c", "e");
        graph.addEdge("e", "h");
        graph.addEdge("e", "f");
        graph.addEdge("f", "g");

        final Stack<String> result = topologicalSort(graph);
        while (!result.empty()) {
            System.out.print(result.pop() + " ");
        }
    }

    static Stack<String> topologicalSort(Graph graph) {
        final Set<String> vertexes = graph.allVertexes();
        Stack<String> stack = new Stack<>();
        Set<String> visitedVertexes = new HashSet<>();

        for (String vertex : vertexes) {
            if (!visitedVertexes.contains(vertex)) {
                sort(graph, vertex, stack, visitedVertexes);
            }
        }
        return stack;
    }

    static void sort(Graph graph, String vertex, Stack<String> stack, Set<String> visitedVertexes) {
        visitedVertexes.add(vertex);

        final List<String> adjacentVertexes = graph.getAdjacentVertexes(vertex);
        for (String adjacentVertex : adjacentVertexes) {
            if (!visitedVertexes.contains(adjacentVertex)) {
                sort(graph, adjacentVertex, stack, visitedVertexes);
            }
        }
        stack.push(vertex);
    }

    // directed graph
    static class Graph {
        Map<String, List<String>> edges;

        public Graph() {
            edges = new HashMap<>();
        }

        void addEdge(String n1, String n2) {
            final List<String> edgesFromN1 = edges.getOrDefault(n1, new ArrayList<>());
            edgesFromN1.add(n2);
            edges.put(n1, edgesFromN1);
        }

        Set<String> allVertexes() {
            return edges.keySet();
        }

        List<String> getAdjacentVertexes(String vertex) {
            return edges.getOrDefault(vertex, new ArrayList<>());
        }
    }
}
