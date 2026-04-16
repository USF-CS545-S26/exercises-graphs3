package adjacencylist;

import java.util.Arrays;

public class GraphExample {
    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Graph.Edge edge10 = new Graph.Edge(0);
        Graph.Edge edge12 = new Graph.Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Graph.Edge edge05 = new Graph.Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Graph.Edge edge26 = new Graph.Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Graph.Edge edge54 = new Graph.Edge(4);
        Graph.Edge edge56 = new Graph.Edge(6);
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Graph.Edge edge67 = new Graph.Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Graph.Edge edge47 = new Graph.Edge(7);
        g.addEdge(4, edge47);

        int[] order = g.topologicalSort();
        System.out.println(Arrays.toString(order)); //[3, 1, 2, 0, 5, 4, 6, 7]
    }
}
