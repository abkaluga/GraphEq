package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import code.Edge;
import code.Graph;

public class GraphTest {

    List<Edge> e1, e2;

    @Test
    public void testSholdBeEqual() {
        // Prepare
        Edge[] a1 = { new Edge(1, 7), //
                      new Edge(2, 3), new Edge(2, 7), //
                      new Edge(3, 7), //
                      new Edge(4, 7), //
                      new Edge(5, 6), new Edge(5, 7), //
                      new Edge(6, 7) };
        e1 = Arrays.asList(a1);
        Edge[] a2 = { new Edge(7, 1), new Edge(7, 2), new Edge(7, 3), new Edge(7, 4), new Edge(7, 5), new Edge(7, 6), //
                      new Edge(6, 5), //
                      new Edge(3, 2) };
        e2 = Arrays.asList(a2);
        Graph g1 = new Graph(e1, 8);
        Graph g2 = new Graph(e2, 8);

        // Test

        boolean result = g1.equals(g2);

        // Assert
        assertTrue("Should be equal", result);

    }

    @Test
    public void testSholdNotBeEqualRemoveEdge() {
        // Prepare
        Edge[] a1 = { new Edge(1, 7), //
                      new Edge(2, 3), new Edge(2, 7), //
                      new Edge(3, 7), //
                      new Edge(5, 6), new Edge(5, 7), //
                      new Edge(6, 7) };
        e1 = Arrays.asList(a1);
        Edge[] a2 = { new Edge(7, 1), new Edge(7, 2), new Edge(7, 3), new Edge(7, 4), new Edge(7, 5), new Edge(7, 6), //
                      new Edge(6, 5), //
                      new Edge(3, 2) };
        e2 = Arrays.asList(a2);
        Graph g1 = new Graph(e1, 8);
        Graph g2 = new Graph(e2, 8);

        // Test
        boolean result = g1.equals(g2);

        // Assert
        assertFalse("Should not be equal remove edge", result);

    }

    @Test
    public void testSholdNotBeEqualRename() {
        // Prepare
        Edge[] a1 = { new Edge(1, 2), //
                      new Edge(2, 3), new Edge(2, 4) };
        e1 = Arrays.asList(a1);
        Edge[] a2 = { new Edge(1, 4), //
                      new Edge(2, 4), //
                      new Edge(3, 4) };
        e2 = Arrays.asList(a2);
        Graph g1 = new Graph(e1, 8);
        Graph g2 = new Graph(e2, 8);

        // Test
        boolean result = g1.equals(g2);

        // Assert
        assertFalse("Should not be equal rename", result);

    }

    @Test
    public void testSholdBeEqualBig() {
        // Prepare
        int size = 1 << 16;
        e1 = new LinkedList<Edge>();
        e2 = new LinkedList<Edge>();
        for (int i = 0; i < size - 1; ++i) {
            e1.add(new Edge(i, i + 1));

        }
        for (int i = size - 1; i > 0; --i) {
            e2.add(new Edge(i, i - 1));

        }

        e1.add(new Edge(size - 1, 0));
        e2.add(new Edge(0, size - 1));

        Collections.shuffle(e1);
        Collections.shuffle(e2);
        Graph g1 = new Graph(e1, size);
        Graph g2 = new Graph(e2, size);

        // Test
        boolean result = g1.equals(g2);

        // Assert
        assertTrue("Should not be equal remove edge", result);

    }

}
