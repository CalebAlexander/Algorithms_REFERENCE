import java.util.HashSet;
import java.util.Set;

/**
 * Class to create every type of graph that will be used
 *
 * @author Mary Xu
 * @version 1.0
 */
public class XuCreateGraphs {


    //--------------------------------------------------------------------
    //----------------------------- Directed -----------------------------
    //--------------------------------------------------------------------

    /**
     *
     * @return dirConnectedGraph
     */
    public static Graph<Character> createDirConnected() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 2));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 4));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 5));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 9));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return dirUnconnectedGraph
     */
    public static Graph<Character> createDirUnconnected() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 10));

        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 15));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return dirAcyclicGraph
     */
    public static Graph<Character> createDirAcyclic() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 3));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 10));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return dirCyclicGraph
     */
    public static Graph<Character> createDirCyclic() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 2));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 8));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 5));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 10));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 3));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return dirSparseGraph
     */
    public static Graph<Character> createDirSparse() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 10));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('E'), 1));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return dirDenseGraph
     */
    public static Graph<Character> createDirDense() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 3));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 15));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 3));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 8));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 13));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('C'), 3));

        return new Graph<>(vertices, edges);
    }







    //----------------------------------------------------------------------
    //----------------------------- Undirected -----------------------------
    //----------------------------------------------------------------------

    /**
     *
     * @return undirConnectedGraph
     */
    public static Graph<Character> createUndirConnected() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 4));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 4));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 5));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 9));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 9));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return undirUnconnectedGraph
     */
    public static Graph<Character> createUndirUnconnected() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 10));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 10));

        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 15));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 15));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return undirAcyclicGraph
     */
    public static Graph<Character> createUndirAcyclic() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 3));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 6));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 6));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return undirCyclicGraph
     */
    public static Graph<Character> createUndirCyclic() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 2));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 2));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 8));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 8));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 5));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 5));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 10));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 10));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('E'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 3));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return undirSparseGraph
     */
    public static Graph<Character> createUndirSparse() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 10));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 10));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('E'), 1));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('C'), 1));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return undirDenseGraph
     */
    public static Graph<Character> createUndirDense() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 3));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 3));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 15));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 15));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('A'), 1));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('E'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 3));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 8));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 8));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 13));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 13));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 2));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('C'), 3));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('E'), 3));

        return new Graph<>(vertices, edges);
    }







    //-----------------------------------------------------------------
    //----------------------------- Other -----------------------------
    //-----------------------------------------------------------------

    /**
     *
     * @return noPathGraph
     */
    public static Graph<Character> createNoPath() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 3));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 3));

        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 4));

        return new Graph<>(vertices, edges);
    }

    /**
     *
     * @return monsterGraph
     */
    public static Graph<Character> createMonster() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 72; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 10));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('F'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 20));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 20));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 8));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('D'), 7));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('G'), 7));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('H'), 5));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('G'), 6));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('F'), 9));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 2));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 2));

        return new Graph<>(vertices, edges);
    }
}
