import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HromiakFixedGraphTests {


    private Graph<Integer> a;
    private Graph<Integer> b;
    private Graph<Integer> c;
    public static final int TIMEOUT = 200;

    @Before
    public void init() {
        a = makeA();
        b = makeB();
        c = makeC();
    }

    /**
     * Creates a directed graph.
     * The graph is depicted in the pdf.
     *
     * @return the completed graph
     */
    private Graph<Integer> makeA() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 0; i <= 7; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(0), new Vertex<>(1), 4));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 5));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(5), 6));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(6), 1));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(5), 7));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 1));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(7), 6));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(4), 3));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(3), 9));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(0), 4));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 5));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(1), 6));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(1), 1));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(2), 7));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 1));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(5), 6));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(7), 3));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(7), 9));

        return new Graph<Integer>(vertices, edges);
    }

    /**
     * Creates an undirected graph.
     * The graph is depicted in the pdf.
     *
     * @return the completed graph
     */
    private Graph<Integer> makeB() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 0; i <= 7; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>(0), new Vertex<>(1), 2));
        edges.add(new Edge<>(new Vertex<>(0), new Vertex<>(4), 4));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 2));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 9));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(5), 1));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(6), 3));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 1));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(7), 7));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(7), 6));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(4), 3));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(2), 3));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(5), 4));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(0), 2));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(0), 4));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 2));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(1), 9));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(1), 1));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(1), 3));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 1));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(3), 7));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(5), 6));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(6), 3));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(6), 3));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(2), 4));

        return new Graph<Integer>(vertices, edges);
    }

    /**
     * Creates an undirected graph.
     * The graph is depicted in the pdf.
     *
     * @return the completed graph
     */
    private Graph<Integer> makeC() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 0; i <= 17; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>(0), new Vertex<>(2), 1));
        edges.add(new Edge<>(new Vertex<>(0), new Vertex<>(14), 3));
        edges.add(new Edge<>(new Vertex<>(0), new Vertex<>(7), 4));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 1));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(5), 5));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(5), 2));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(6), 8));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(10), 2));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(17), 6));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(7), 2));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(8), 1));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(5), 3));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(9), 8));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(9), 5));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(10), 3));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(8), 1));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 6));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(12), 1));
        edges.add(new Edge<>(new Vertex<>(11), new Vertex<>(14), 2));
        edges.add(new Edge<>(new Vertex<>(11), new Vertex<>(15), 8));
        edges.add(new Edge<>(new Vertex<>(11), new Vertex<>(12), 8));
        edges.add(new Edge<>(new Vertex<>(12), new Vertex<>(15), 5));
        edges.add(new Edge<>(new Vertex<>(12), new Vertex<>(16), 8));
        edges.add(new Edge<>(new Vertex<>(12), new Vertex<>(13), 8));
        edges.add(new Edge<>(new Vertex<>(13), new Vertex<>(17), 7));
        edges.add(new Edge<>(new Vertex<>(15), new Vertex<>(17), 2));
        edges.add(new Edge<>(new Vertex<>(16), new Vertex<>(17), 1));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(0), 1));
        edges.add(new Edge<>(new Vertex<>(14), new Vertex<>(0), 3));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(0), 4));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 1));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(1), 5));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(2), 2));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(3), 8));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(3), 2));
        edges.add(new Edge<>(new Vertex<>(17), new Vertex<>(3), 6));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(4), 2));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(4), 1));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 3));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(5), 8));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(6), 5));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(6), 3));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(7), 1));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(8), 6));
        edges.add(new Edge<>(new Vertex<>(12), new Vertex<>(9), 1));
        edges.add(new Edge<>(new Vertex<>(14), new Vertex<>(11), 2));
        edges.add(new Edge<>(new Vertex<>(15), new Vertex<>(11), 8));
        edges.add(new Edge<>(new Vertex<>(12), new Vertex<>(11), 8));
        edges.add(new Edge<>(new Vertex<>(15), new Vertex<>(12), 5));
        edges.add(new Edge<>(new Vertex<>(16), new Vertex<>(12), 8));
        edges.add(new Edge<>(new Vertex<>(13), new Vertex<>(12), 8));
        edges.add(new Edge<>(new Vertex<>(17), new Vertex<>(13), 7));
        edges.add(new Edge<>(new Vertex<>(17), new Vertex<>(15), 2));
        edges.add(new Edge<>(new Vertex<>(17), new Vertex<>(16), 1));


        return new Graph<Integer>(vertices, edges);
    }





    @Test(timeout = TIMEOUT)
    public void testAstart0() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(0), a);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(0), 0);
        dijkExpected.put(new Vertex<>(1), 4);
        dijkExpected.put(new Vertex<>(2), 9);
        dijkExpected.put(new Vertex<>(3), 21);
        dijkExpected.put(new Vertex<>(4), 15);
        dijkExpected.put(new Vertex<>(5), 6);
        dijkExpected.put(new Vertex<>(6), 5);
        dijkExpected.put(new Vertex<>(7), 12);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart0() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(0), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(0), 0);
        dijkExpected.put(new Vertex<>(1), 2);
        dijkExpected.put(new Vertex<>(2), 4);
        dijkExpected.put(new Vertex<>(3), 4);
        dijkExpected.put(new Vertex<>(4), 4);
        dijkExpected.put(new Vertex<>(5), 3);
        dijkExpected.put(new Vertex<>(6), 5);
        dijkExpected.put(new Vertex<>(7), 9);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart1() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(1), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(1), 0);
        dijkExpected.put(new Vertex<>(0), 2);
        dijkExpected.put(new Vertex<>(2), 2);
        dijkExpected.put(new Vertex<>(3), 2);
        dijkExpected.put(new Vertex<>(4), 6);
        dijkExpected.put(new Vertex<>(5), 1);
        dijkExpected.put(new Vertex<>(6), 3);
        dijkExpected.put(new Vertex<>(7), 7);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart2() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(2), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(2), 0);
        dijkExpected.put(new Vertex<>(0), 4);
        dijkExpected.put(new Vertex<>(1), 2);
        dijkExpected.put(new Vertex<>(3), 4);
        dijkExpected.put(new Vertex<>(4), 6);
        dijkExpected.put(new Vertex<>(5), 3);
        dijkExpected.put(new Vertex<>(6), 3);
        dijkExpected.put(new Vertex<>(7), 9);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart3() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(3), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(3), 0);
        dijkExpected.put(new Vertex<>(0), 4);
        dijkExpected.put(new Vertex<>(1), 2);
        dijkExpected.put(new Vertex<>(2), 4);
        dijkExpected.put(new Vertex<>(4), 8);
        dijkExpected.put(new Vertex<>(5), 1);
        dijkExpected.put(new Vertex<>(6), 5);
        dijkExpected.put(new Vertex<>(7), 7);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart4() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(4), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(4), 0);
        dijkExpected.put(new Vertex<>(0), 4);
        dijkExpected.put(new Vertex<>(1), 6);
        dijkExpected.put(new Vertex<>(2), 6);
        dijkExpected.put(new Vertex<>(3), 8);
        dijkExpected.put(new Vertex<>(5), 7);
        dijkExpected.put(new Vertex<>(6), 3);
        dijkExpected.put(new Vertex<>(7), 13);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart5() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(5), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(5), 0);
        dijkExpected.put(new Vertex<>(0), 3);
        dijkExpected.put(new Vertex<>(1), 1);
        dijkExpected.put(new Vertex<>(2), 3);
        dijkExpected.put(new Vertex<>(3), 1);
        dijkExpected.put(new Vertex<>(4), 7);
        dijkExpected.put(new Vertex<>(6), 4);
        dijkExpected.put(new Vertex<>(7), 6);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart6() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(6), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(6), 0);
        dijkExpected.put(new Vertex<>(0), 5);
        dijkExpected.put(new Vertex<>(1), 3);
        dijkExpected.put(new Vertex<>(2), 3);
        dijkExpected.put(new Vertex<>(3), 5);
        dijkExpected.put(new Vertex<>(4), 3);
        dijkExpected.put(new Vertex<>(5), 4);
        dijkExpected.put(new Vertex<>(7), 10);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBstart7() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(7), b);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(7), 0);
        dijkExpected.put(new Vertex<>(0), 9);
        dijkExpected.put(new Vertex<>(1), 7);
        dijkExpected.put(new Vertex<>(2), 9);
        dijkExpected.put(new Vertex<>(3), 7);
        dijkExpected.put(new Vertex<>(4), 13);
        dijkExpected.put(new Vertex<>(5), 6);
        dijkExpected.put(new Vertex<>(6), 10);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart0() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(0), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(0), 0);
        dijkExpected.put(new Vertex<>(1), 2);
        dijkExpected.put(new Vertex<>(2), 1);
        dijkExpected.put(new Vertex<>(3), 21);
        dijkExpected.put(new Vertex<>(4), 6);
        dijkExpected.put(new Vertex<>(5), 3);
        dijkExpected.put(new Vertex<>(6), 16);
        dijkExpected.put(new Vertex<>(7), 4);
        dijkExpected.put(new Vertex<>(8), 5);
        dijkExpected.put(new Vertex<>(9), 11);
        dijkExpected.put(new Vertex<>(10), 19);
        dijkExpected.put(new Vertex<>(11), 5);
        dijkExpected.put(new Vertex<>(12), 12);
        dijkExpected.put(new Vertex<>(13), 20);
        dijkExpected.put(new Vertex<>(14), 3);
        dijkExpected.put(new Vertex<>(15), 13);
        dijkExpected.put(new Vertex<>(16), 16);
        dijkExpected.put(new Vertex<>(17), 15);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart1() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(1), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(1), 0);
        dijkExpected.put(new Vertex<>(0), 2);
        dijkExpected.put(new Vertex<>(2), 1);
        dijkExpected.put(new Vertex<>(3), 21);
        dijkExpected.put(new Vertex<>(4), 6);
        dijkExpected.put(new Vertex<>(5), 3);
        dijkExpected.put(new Vertex<>(6), 16);
        dijkExpected.put(new Vertex<>(7), 6);
        dijkExpected.put(new Vertex<>(8), 7);
        dijkExpected.put(new Vertex<>(9), 11);
        dijkExpected.put(new Vertex<>(10), 19);
        dijkExpected.put(new Vertex<>(11), 7);
        dijkExpected.put(new Vertex<>(12), 12);
        dijkExpected.put(new Vertex<>(13), 20);
        dijkExpected.put(new Vertex<>(14), 5);
        dijkExpected.put(new Vertex<>(15), 15);
        dijkExpected.put(new Vertex<>(16), 18);
        dijkExpected.put(new Vertex<>(17), 17);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart2() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(2), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(2), 0);
        dijkExpected.put(new Vertex<>(0), 1);
        dijkExpected.put(new Vertex<>(1), 1);
        dijkExpected.put(new Vertex<>(3), 20);
        dijkExpected.put(new Vertex<>(4), 5);
        dijkExpected.put(new Vertex<>(5), 2);
        dijkExpected.put(new Vertex<>(6), 15);
        dijkExpected.put(new Vertex<>(7), 5);
        dijkExpected.put(new Vertex<>(8), 6);
        dijkExpected.put(new Vertex<>(9), 10);
        dijkExpected.put(new Vertex<>(10), 18);
        dijkExpected.put(new Vertex<>(11), 6);
        dijkExpected.put(new Vertex<>(12), 11);
        dijkExpected.put(new Vertex<>(13), 19);
        dijkExpected.put(new Vertex<>(14), 4);
        dijkExpected.put(new Vertex<>(15), 14);
        dijkExpected.put(new Vertex<>(16), 17);
        dijkExpected.put(new Vertex<>(17), 16);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart3() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(3), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(3), 0);
        dijkExpected.put(new Vertex<>(0), 21);
        dijkExpected.put(new Vertex<>(1), 21);
        dijkExpected.put(new Vertex<>(2), 20);
        dijkExpected.put(new Vertex<>(4), 17);
        dijkExpected.put(new Vertex<>(5), 18);
        dijkExpected.put(new Vertex<>(6), 5);
        dijkExpected.put(new Vertex<>(7), 17);
        dijkExpected.put(new Vertex<>(8), 16);
        dijkExpected.put(new Vertex<>(9), 10);
        dijkExpected.put(new Vertex<>(10), 2);
        dijkExpected.put(new Vertex<>(11), 16);
        dijkExpected.put(new Vertex<>(12), 11);
        dijkExpected.put(new Vertex<>(13), 13);
        dijkExpected.put(new Vertex<>(14), 18);
        dijkExpected.put(new Vertex<>(15), 8);
        dijkExpected.put(new Vertex<>(16), 7);
        dijkExpected.put(new Vertex<>(17), 6);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart4() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(4), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(4), 0);
        dijkExpected.put(new Vertex<>(0), 6);
        dijkExpected.put(new Vertex<>(1), 6);
        dijkExpected.put(new Vertex<>(2), 5);
        dijkExpected.put(new Vertex<>(3), 17);
        dijkExpected.put(new Vertex<>(5), 3);
        dijkExpected.put(new Vertex<>(6), 12);
        dijkExpected.put(new Vertex<>(7), 2);
        dijkExpected.put(new Vertex<>(8), 1);
        dijkExpected.put(new Vertex<>(9), 7);
        dijkExpected.put(new Vertex<>(10), 15);
        dijkExpected.put(new Vertex<>(11), 11);
        dijkExpected.put(new Vertex<>(12), 8);
        dijkExpected.put(new Vertex<>(13), 16);
        dijkExpected.put(new Vertex<>(14), 9);
        dijkExpected.put(new Vertex<>(15), 13);
        dijkExpected.put(new Vertex<>(16), 16);
        dijkExpected.put(new Vertex<>(17), 15);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart5() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(5), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(5), 0);
        dijkExpected.put(new Vertex<>(0), 3);
        dijkExpected.put(new Vertex<>(1), 3);
        dijkExpected.put(new Vertex<>(2), 2);
        dijkExpected.put(new Vertex<>(3), 18);
        dijkExpected.put(new Vertex<>(4), 3);
        dijkExpected.put(new Vertex<>(6), 13);
        dijkExpected.put(new Vertex<>(7), 5);
        dijkExpected.put(new Vertex<>(8), 4);
        dijkExpected.put(new Vertex<>(9), 8);
        dijkExpected.put(new Vertex<>(10), 16);
        dijkExpected.put(new Vertex<>(11), 8);
        dijkExpected.put(new Vertex<>(12), 9);
        dijkExpected.put(new Vertex<>(13), 17);
        dijkExpected.put(new Vertex<>(14), 6);
        dijkExpected.put(new Vertex<>(15), 14);
        dijkExpected.put(new Vertex<>(16), 17);
        dijkExpected.put(new Vertex<>(17), 16);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart6() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(6), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(6), 0);
        dijkExpected.put(new Vertex<>(0), 16);
        dijkExpected.put(new Vertex<>(1), 16);
        dijkExpected.put(new Vertex<>(2), 15);
        dijkExpected.put(new Vertex<>(3), 5);
        dijkExpected.put(new Vertex<>(4), 12);
        dijkExpected.put(new Vertex<>(5), 13);
        dijkExpected.put(new Vertex<>(7), 12);
        dijkExpected.put(new Vertex<>(8), 11);
        dijkExpected.put(new Vertex<>(9), 5);
        dijkExpected.put(new Vertex<>(10), 3);
        dijkExpected.put(new Vertex<>(11), 14);
        dijkExpected.put(new Vertex<>(12), 6);
        dijkExpected.put(new Vertex<>(13), 14);
        dijkExpected.put(new Vertex<>(14), 16);
        dijkExpected.put(new Vertex<>(15), 11);
        dijkExpected.put(new Vertex<>(16), 12);
        dijkExpected.put(new Vertex<>(17), 11);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart7() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(7), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(7), 0);
        dijkExpected.put(new Vertex<>(0), 4);
        dijkExpected.put(new Vertex<>(1), 6);
        dijkExpected.put(new Vertex<>(2), 5);
        dijkExpected.put(new Vertex<>(3), 17);
        dijkExpected.put(new Vertex<>(4), 2);
        dijkExpected.put(new Vertex<>(5), 5);
        dijkExpected.put(new Vertex<>(6), 12);
        dijkExpected.put(new Vertex<>(8), 1);
        dijkExpected.put(new Vertex<>(9), 7);
        dijkExpected.put(new Vertex<>(10), 15);
        dijkExpected.put(new Vertex<>(11), 9);
        dijkExpected.put(new Vertex<>(12), 8);
        dijkExpected.put(new Vertex<>(13), 16);
        dijkExpected.put(new Vertex<>(14), 7);
        dijkExpected.put(new Vertex<>(15), 13);
        dijkExpected.put(new Vertex<>(16), 16);
        dijkExpected.put(new Vertex<>(17), 15);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart8() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(8), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(8), 0);
        dijkExpected.put(new Vertex<>(0), 5);
        dijkExpected.put(new Vertex<>(1), 7);
        dijkExpected.put(new Vertex<>(2), 6);
        dijkExpected.put(new Vertex<>(3), 16);
        dijkExpected.put(new Vertex<>(4), 1);
        dijkExpected.put(new Vertex<>(5), 4);
        dijkExpected.put(new Vertex<>(6), 11);
        dijkExpected.put(new Vertex<>(7), 1);
        dijkExpected.put(new Vertex<>(9), 6);
        dijkExpected.put(new Vertex<>(10), 14);
        dijkExpected.put(new Vertex<>(11), 10);
        dijkExpected.put(new Vertex<>(12), 7);
        dijkExpected.put(new Vertex<>(13), 15);
        dijkExpected.put(new Vertex<>(14), 8);
        dijkExpected.put(new Vertex<>(15), 12);
        dijkExpected.put(new Vertex<>(16), 15);
        dijkExpected.put(new Vertex<>(17), 14);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart9() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(9), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(9), 0);
        dijkExpected.put(new Vertex<>(0), 11);
        dijkExpected.put(new Vertex<>(1), 11);
        dijkExpected.put(new Vertex<>(2), 10);
        dijkExpected.put(new Vertex<>(3), 10);
        dijkExpected.put(new Vertex<>(4), 7);
        dijkExpected.put(new Vertex<>(5), 8);
        dijkExpected.put(new Vertex<>(6), 5);
        dijkExpected.put(new Vertex<>(7), 7);
        dijkExpected.put(new Vertex<>(8), 6);
        dijkExpected.put(new Vertex<>(10), 8);
        dijkExpected.put(new Vertex<>(11), 9);
        dijkExpected.put(new Vertex<>(12), 1);
        dijkExpected.put(new Vertex<>(13), 9);
        dijkExpected.put(new Vertex<>(14), 11);
        dijkExpected.put(new Vertex<>(15), 6);
        dijkExpected.put(new Vertex<>(16), 9);
        dijkExpected.put(new Vertex<>(17), 8);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart10() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(10), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(10), 0);
        dijkExpected.put(new Vertex<>(0), 19);
        dijkExpected.put(new Vertex<>(1), 19);
        dijkExpected.put(new Vertex<>(2), 18);
        dijkExpected.put(new Vertex<>(3), 2);
        dijkExpected.put(new Vertex<>(4), 15);
        dijkExpected.put(new Vertex<>(5), 16);
        dijkExpected.put(new Vertex<>(6), 3);
        dijkExpected.put(new Vertex<>(7), 15);
        dijkExpected.put(new Vertex<>(8), 14);
        dijkExpected.put(new Vertex<>(9), 8);
        dijkExpected.put(new Vertex<>(11), 17);
        dijkExpected.put(new Vertex<>(12), 9);
        dijkExpected.put(new Vertex<>(13), 15);
        dijkExpected.put(new Vertex<>(14), 19);
        dijkExpected.put(new Vertex<>(15), 10);
        dijkExpected.put(new Vertex<>(16), 9);
        dijkExpected.put(new Vertex<>(17), 8);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart11() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(11), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(11), 0);
        dijkExpected.put(new Vertex<>(0), 5);
        dijkExpected.put(new Vertex<>(1), 7);
        dijkExpected.put(new Vertex<>(2), 6);
        dijkExpected.put(new Vertex<>(3), 16);
        dijkExpected.put(new Vertex<>(4), 11);
        dijkExpected.put(new Vertex<>(5), 8);
        dijkExpected.put(new Vertex<>(6), 14);
        dijkExpected.put(new Vertex<>(7), 9);
        dijkExpected.put(new Vertex<>(8), 10);
        dijkExpected.put(new Vertex<>(9), 9);
        dijkExpected.put(new Vertex<>(10), 17);
        dijkExpected.put(new Vertex<>(12), 8);
        dijkExpected.put(new Vertex<>(13), 16);
        dijkExpected.put(new Vertex<>(14), 2);
        dijkExpected.put(new Vertex<>(15), 8);
        dijkExpected.put(new Vertex<>(16), 11);
        dijkExpected.put(new Vertex<>(17), 10);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart12() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(12), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(12), 0);
        dijkExpected.put(new Vertex<>(0), 12);
        dijkExpected.put(new Vertex<>(1), 12);
        dijkExpected.put(new Vertex<>(2), 11);
        dijkExpected.put(new Vertex<>(3), 11);
        dijkExpected.put(new Vertex<>(4), 8);
        dijkExpected.put(new Vertex<>(5), 9);
        dijkExpected.put(new Vertex<>(6), 6);
        dijkExpected.put(new Vertex<>(7), 8);
        dijkExpected.put(new Vertex<>(8), 7);
        dijkExpected.put(new Vertex<>(9), 1);
        dijkExpected.put(new Vertex<>(10), 9);
        dijkExpected.put(new Vertex<>(11), 8);
        dijkExpected.put(new Vertex<>(13), 8);
        dijkExpected.put(new Vertex<>(14), 10);
        dijkExpected.put(new Vertex<>(15), 5);
        dijkExpected.put(new Vertex<>(16), 8);
        dijkExpected.put(new Vertex<>(17), 7);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart13() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(13), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(13), 0);
        dijkExpected.put(new Vertex<>(0), 20);
        dijkExpected.put(new Vertex<>(1), 20);
        dijkExpected.put(new Vertex<>(2), 19);
        dijkExpected.put(new Vertex<>(3), 13);
        dijkExpected.put(new Vertex<>(4), 16);
        dijkExpected.put(new Vertex<>(5), 17);
        dijkExpected.put(new Vertex<>(6), 14);
        dijkExpected.put(new Vertex<>(7), 16);
        dijkExpected.put(new Vertex<>(8), 15);
        dijkExpected.put(new Vertex<>(9), 9);
        dijkExpected.put(new Vertex<>(10), 15);
        dijkExpected.put(new Vertex<>(11), 16);
        dijkExpected.put(new Vertex<>(12), 8);
        dijkExpected.put(new Vertex<>(14), 18);
        dijkExpected.put(new Vertex<>(15), 9);
        dijkExpected.put(new Vertex<>(16), 8);
        dijkExpected.put(new Vertex<>(17), 7);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart14() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(14), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(14), 0);
        dijkExpected.put(new Vertex<>(0), 3);
        dijkExpected.put(new Vertex<>(1), 5);
        dijkExpected.put(new Vertex<>(2), 4);
        dijkExpected.put(new Vertex<>(3), 18);
        dijkExpected.put(new Vertex<>(4), 9);
        dijkExpected.put(new Vertex<>(5), 6);
        dijkExpected.put(new Vertex<>(6), 16);
        dijkExpected.put(new Vertex<>(7), 7);
        dijkExpected.put(new Vertex<>(8), 8);
        dijkExpected.put(new Vertex<>(9), 11);
        dijkExpected.put(new Vertex<>(10), 19);
        dijkExpected.put(new Vertex<>(11), 2);
        dijkExpected.put(new Vertex<>(12), 10);
        dijkExpected.put(new Vertex<>(13), 18);
        dijkExpected.put(new Vertex<>(15), 10);
        dijkExpected.put(new Vertex<>(16), 13);
        dijkExpected.put(new Vertex<>(17), 12);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart15() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(15), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(15), 0);
        dijkExpected.put(new Vertex<>(0), 13);
        dijkExpected.put(new Vertex<>(1), 15);
        dijkExpected.put(new Vertex<>(2), 14);
        dijkExpected.put(new Vertex<>(3), 8);
        dijkExpected.put(new Vertex<>(4), 13);
        dijkExpected.put(new Vertex<>(5), 14);
        dijkExpected.put(new Vertex<>(6), 11);
        dijkExpected.put(new Vertex<>(7), 13);
        dijkExpected.put(new Vertex<>(8), 12);
        dijkExpected.put(new Vertex<>(9), 6);
        dijkExpected.put(new Vertex<>(10), 10);
        dijkExpected.put(new Vertex<>(11), 8);
        dijkExpected.put(new Vertex<>(12), 5);
        dijkExpected.put(new Vertex<>(13), 9);
        dijkExpected.put(new Vertex<>(14), 10);
        dijkExpected.put(new Vertex<>(16), 3);
        dijkExpected.put(new Vertex<>(17), 2);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart16() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(16), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(16), 0);
        dijkExpected.put(new Vertex<>(0), 16);
        dijkExpected.put(new Vertex<>(1), 18);
        dijkExpected.put(new Vertex<>(2), 17);
        dijkExpected.put(new Vertex<>(3), 7);
        dijkExpected.put(new Vertex<>(4), 16);
        dijkExpected.put(new Vertex<>(5), 17);
        dijkExpected.put(new Vertex<>(6), 12);
        dijkExpected.put(new Vertex<>(7), 16);
        dijkExpected.put(new Vertex<>(8), 15);
        dijkExpected.put(new Vertex<>(9), 9);
        dijkExpected.put(new Vertex<>(10), 9);
        dijkExpected.put(new Vertex<>(11), 11);
        dijkExpected.put(new Vertex<>(12), 8);
        dijkExpected.put(new Vertex<>(13), 8);
        dijkExpected.put(new Vertex<>(14), 13);
        dijkExpected.put(new Vertex<>(15), 3);
        dijkExpected.put(new Vertex<>(17), 1);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testCstart17() {
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<Integer>(17), c);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(17), 0);
        dijkExpected.put(new Vertex<>(0), 15);
        dijkExpected.put(new Vertex<>(1), 17);
        dijkExpected.put(new Vertex<>(2), 16);
        dijkExpected.put(new Vertex<>(3), 6);
        dijkExpected.put(new Vertex<>(4), 15);
        dijkExpected.put(new Vertex<>(5), 16);
        dijkExpected.put(new Vertex<>(6), 11);
        dijkExpected.put(new Vertex<>(7), 15);
        dijkExpected.put(new Vertex<>(8), 14);
        dijkExpected.put(new Vertex<>(9), 8);
        dijkExpected.put(new Vertex<>(10), 8);
        dijkExpected.put(new Vertex<>(11), 10);
        dijkExpected.put(new Vertex<>(12), 7);
        dijkExpected.put(new Vertex<>(13), 7);
        dijkExpected.put(new Vertex<>(14), 12);
        dijkExpected.put(new Vertex<>(15), 2);
        dijkExpected.put(new Vertex<>(16), 1);

        assertEquals(dijkExpected, dijkActual);
    }
}
