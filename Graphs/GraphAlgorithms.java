import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Your implementation of various different graph algorithms.
 *
 * @author Caleb Alexander
 * @userid calexander49
 * @GTID 903133971
 * @version 1.0
 */
public class GraphAlgorithms {

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * {@code start} which represents the starting vertex.
     *
     * When deciding which neighbors to visit next from a vertex, visit the
     * vertices in the order presented in that entry of the adjacency list.
     *
     * *NOTE* You MUST implement this method recursively, or else you will lose
     * most if not all points for this method.
     *
     * You may import/use {@code java.util.Set}, {@code java.util.List}, and
     * any classes that implement the aforementioned interfaces, as long as it
     * is efficient.
     *
     * The only instance of {@code java.util.Map} that you may use is the
     * adjacency list from {@code graph}. DO NOT create new instances of Map
     * for DFS (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @throws IllegalArgumentException if any input
     *  is null, or if {@code start} doesn't exist in the graph
     * @param <T> the generic typing of the data
     * @param start the vertex to begin the dfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     */
    public static <T> List<Vertex<T>> depthFirstSearch(Vertex<T> start,
                                            Graph<T> graph) {
        if (start == null || graph == null
                || !graph.getAdjList().containsKey(start)) {
            throw new java.lang.IllegalArgumentException("Cannot use DFS"
                    + " on an illegal graph or starting vertex.");
        }
        List<Vertex<T>> visited = new ArrayList<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adjacencyList =
                graph.getAdjList();
        visited = dfsHelper(start, graph, visited, adjacencyList);
        return visited;
    }

    /**
     *  Recursive Helper Method to add visited vertices to the list
     * @param current vertex to be added to the list
     * @param graph graph we are searching though
     * @param visited list of already visited vertices
     * @param adjacencyList adjacency list generated from the graph
     * @param <T> generic data type within the vertices
     * @return returns the updated list
     */
    private static <T> List<Vertex<T>> dfsHelper(Vertex<T> current,
                                             Graph<T> graph,
                                             List<Vertex<T>> visited,
                                             Map<Vertex<T>,
                                                     List<VertexDistance<T>>>
                                                     adjacencyList) {
        visited.add(current);
        List<VertexDistance<T>> adjacentEdges = adjacencyList.get(current);
        for (VertexDistance<T> v : adjacentEdges) {
            Vertex<T> next = v.getVertex();
            if (!visited.contains(next)) {
                visited = dfsHelper(next, graph, visited, adjacencyList);
            }
        }
        return visited;
    }


    /**
     * Finds the single-source shortest distance between the start vertex and
     * all vertices given a weighted graph (you may assume non-negative edge
     * weights).
     *
     * Return a map of the shortest distances such that the key of each entry
     * is a node in the graph and the value for the key is the shortest distance
     * to that node from start, or Integer.MAX_VALUE (representing infinity)
     * if no path exists.
     *
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Map}, and {@code java.util.Set} and any class that
     * implements the aforementioned interfaces, as long as it's efficient.
     *
     * You should implement the version of Dijkstra's where you use two
     * termination conditions in conjunction.
     *
     * 1) Check that not all vertices have been visited.
     * 2) Check that the PQ is not empty yet.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @throws IllegalArgumentException if any input is null, or if start
     *  doesn't exist in the graph.
     * @param <T> the generic typing of the data
     * @param start index representing which vertex to start at (source)
     * @param graph the graph we are applying Dijkstra's to
     * @return a map of the shortest distances from start to every other node
     *         in the graph
     */
    public static <T> Map<Vertex<T>, Integer> dijkstras(Vertex<T> start,
                                                        Graph<T> graph) {
        if (start == null || graph == null
                || !graph.getAdjList().containsKey(start)) {
            throw new java.lang.IllegalArgumentException("Cannot use Dijksta's"
                    + " on an illegal graph or starting vertex.");
        } else {
            Map<Vertex<T>, Integer> totalDist = new HashMap<>();
            List<Vertex<T>> visited = new ArrayList<>();
            Queue<VertexDistance<T>> verticesPQ = new PriorityQueue<>();
            Map<Vertex<T>, List<VertexDistance<T>>> adjacencyList =
                    graph.getAdjList();

            VertexDistance<T> startDist = new VertexDistance<>(start, 0);
            verticesPQ.add(startDist);
            for (Vertex<T> v : graph.getVertices()) {
                if (v != start) {
                    totalDist.put(v, Integer.MAX_VALUE);
                }
            }
            totalDist.put(start, 0);
            List<VertexDistance<T>> neighbors;
            while (!verticesPQ.isEmpty()) {
                VertexDistance<T> current = verticesPQ.remove();
                neighbors = adjacencyList.get(current.getVertex());
                for (VertexDistance<T> neighbor : neighbors) {

                    int oldPath = totalDist.get(neighbor.getVertex());
                    int newPath = totalDist.get(current.getVertex())
                            + neighbor.getDistance();

                    if (newPath < oldPath) {
                        totalDist.put(neighbor.getVertex(), newPath);
                        if (!visited.contains(neighbor.getVertex())) {
                            visited.add(neighbor.getVertex());
                            verticesPQ.add(neighbor);
                        }
                    }
                }
            }
            return totalDist;
        }
    }


    /**
     * Runs Kruskal's algorithm on the given graph and returns the Minimal
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * Kruskal's will also require you to use a Disjoint Set which has been
     * provided for you. A Disjoint Set will keep track of which vertices are
     * connected given the edges in your current MST, allowing you to easily
     * figure out whether adding an edge will create a cycle. Refer
     * to the {@code DisjointSet} and {@code DisjointSetNode} classes that
     * have been provided to you for more information.
     *
     * You should NOT allow self-loops into the MST.
     *
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Set}, and any class that implements the aforementioned
     * interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @throws IllegalArgumentException if any input is null
     * @param <T> the generic typing of the data
     * @param graph the graph we are applying Kruskals to
     * @return the MST of the graph or null if there is no valid MST
     */
    public static <T> Set<Edge<T>> kruskals(Graph<T> graph) {
        if (graph == null) {
            throw new java.lang.IllegalArgumentException("Can not perform "
                    + "Kruskals on a null graph.");
        } else {
            Set<Vertex<T>> vertices = graph.getVertices();
            Set<Edge<T>> edges = graph.getEdges();
            Set<Edge<T>> returnEdges = new HashSet<>();
            Queue<Edge<T>> edgesPQ = new PriorityQueue<>();
            DisjointSet<Vertex<T>> disjointSet =
                    new DisjointSet<>(vertices);

            for (Edge<T> edge : edges) {
                edgesPQ.add(edge);
            }
            while (!edgesPQ.isEmpty()) {
                Edge<T> edge = edgesPQ.remove();
                if (disjointSet.find(edge.getU())
                        != disjointSet.find(edge.getV())) {
                    disjointSet.union(edge.getU(), edge.getV());
                    returnEdges.add(edge);
                    returnEdges.add(new Edge<>(edge.getV(),
                            edge.getU(), edge.getWeight()));
                }
            }

            return returnEdges;
        }
    }
}