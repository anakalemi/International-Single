package algorithms.graph;

import java.util.*;

/**
 * @author : Ana Kalemi
 **/
public class Graph<T> {

    private final Map<T, Set<T>> graph;
    private Stack<T> verticesStack;
    private Map<T, Boolean> visitedMap;
    private Map<T, Integer> stronglyConnectedComponentsMap;
    private int stronglyConnectedComponentsCounter;

    public Graph() {
        graph = new HashMap<>();
        stronglyConnectedComponentsMap = new HashMap<>();
    }

    public void addVertex(T vertex) {
        graph.put(vertex, new HashSet<>());
    }

    public void addEdge(T source, T destination) {
        if (!graph.containsKey(source)) {
            addVertex(source);
        }
        if (!graph.containsKey(destination)) {
            addVertex(destination);
        }
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public Graph<T> getReverseGraph() {
        Graph<T> reverse = new Graph<>();
        for (T source : graph.keySet()) {
            for (T destination : graph.get(source)) {
                reverse.addEdge(destination, source);
            }
        }
        return reverse;
    }

    public void depthFirstSearch() {
        verticesStack = new Stack<>();
        resetVisitedMap();
        for (T vertex : graph.keySet()) {
            if (!visitedMap.get(vertex)) {
                stronglyConnectedComponentsCounter++;
                explore(vertex);
            }
        }
    }

    public void explore(T vertex) {
        visitedMap.put(vertex, true);
        stronglyConnectedComponentsMap.put(vertex, stronglyConnectedComponentsCounter);
        for (T v : graph.get(vertex)) {
            if (!visitedMap.get(v)) {
                explore(v);
            }
        }
        verticesStack.push(vertex);
    }

    public Map<T, Integer> getStronglyConnectedComponents() {
        stronglyConnectedComponentsMap = new HashMap<>();
        stronglyConnectedComponentsCounter = 0;

        Graph<T> reverse = getReverseGraph();
        reverse.depthFirstSearch();

        resetVisitedMap();
        verticesStack = new Stack<>();
        while (!reverse.verticesStack.empty()) {
            T vertex = reverse.verticesStack.pop();
            if (!visitedMap.get(vertex)) {
                stronglyConnectedComponentsCounter++;
                explore(vertex);
            }
        }
        return stronglyConnectedComponentsMap;
    }

    private void resetVisitedMap() {
        visitedMap = new HashMap<>();
        for (T vertex : graph.keySet()) {
            visitedMap.put(vertex, false);
        }
    }

    public Stack<T> getVerticesStack() {
        return verticesStack;
    }

    @Override
    public String toString() {
        StringBuilder graphAsString = new StringBuilder();
        for (T vertex : graph.keySet()) {
            graphAsString.append(vertex)
                    .append(": ")
                    .append(graph.get(vertex))
                    .append("\n");
        }
        return graphAsString.toString();
    }

}
