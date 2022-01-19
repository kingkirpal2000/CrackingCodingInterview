package treegraph;

import java.util.Queue;

import javax.management.QueryEval;

import datastructures.LinkedList;
import java.util.*;

/**
 * Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 */
class _04_01_RouteBetweenNodes {

    private final Digraph digraph;

    _04_01_RouteBetweenNodes(Digraph digraph) {
        this.digraph = digraph;
    }

    boolean hasRoute(int source, int target) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        queue.add(source);

        ArrayList<Integer> visited = new ArrayList<Integer>();
        visited.add(source);

        while (!queue.isEmpty()) {
            int x = queue.remove(0);
            Iterable<Integer> neighbors = digraph.adjacent(x);
            System.out.println(neighbors);
            for (int neighbor : neighbors) {
                if (neighbor == target) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }

        }

        return false;

    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(2, 4);
        _04_01_RouteBetweenNodes obj = new _04_01_RouteBetweenNodes(digraph);
        System.out.println(obj.hasRoute(0, 5));

    }

}
