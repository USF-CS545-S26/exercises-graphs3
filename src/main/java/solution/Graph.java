package solution;

public class Graph {
    private Edge[] graph; // adjacency list for this graph
    private int time;

    // Nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }


    /** Dfs that should compute discovery and finish times
     *
     * @param vertex
     * @param visited
     * @param discovery
     * @param finish
     */
    public void dfs(int vertex, boolean[] visited, int[] discovery, int[] finish) {
        visited[vertex] = true;
        time++;
        discovery[vertex] = time;

        Edge e = graph[vertex];
        while (e != null) {
            if (!visited[e.neighbor]) {
                dfs(e.neighbor, visited, discovery, finish);
            }
            e = e.next;
        }

        time++;
        finish[vertex] = time;
    }

    public void dfsMain(int[] discovery, int[] finish) {
        boolean[] visited = new boolean[graph.length];
        time = 0;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, discovery, finish);
            }
        }
    }

    /** Run dfs to compute discovery and finish times,
      * then sort vertices in reverse order of finish times to produce the topological sort.
     */
    public int[] topologicalSort() {
        int n = graph.length;
        int[] discovery = new int[n];
        int[] finish = new int[n];

        dfsMain(discovery, finish);

        int[] order = new int[n]; // topological order
        boolean[] used = new boolean[n]; // which vertices we already picked

        for (int i = 0; i < n; i++) {
            int maxIndex = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (maxIndex == -1 || finish[j] > finish[maxIndex])) {
                    maxIndex = j;
                }
            }
            order[i] = maxIndex;
            used[maxIndex] = true;
        }

        return order;
    }

}


