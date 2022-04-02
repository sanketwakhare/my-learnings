import java.util.ArrayList;
import java.util.List;

/* DFS Traversal */
public class class_q1_dfsTraversal {

    public void performDFS(int[][] connections, int n) {

        List<Integer> dfsPath = new ArrayList<Integer>();
        boolean[] visited = new boolean[n + 1];

        // build adjacency list
        List<List<Integer>> adjList = buildAdjacencyList(connections, n);

        // count of connected components/islands
        int count = 0;

        // traverse from every node as there can be more than 1 connected components
        for (int i = 1; i <= n; i++) {
            // perform dfs on a node only when it is not already visited
            if (!visited[i]) {
                count++;
                // dfs will make sure that it will visit all the nods within it's(same)
                // component
                dfs(i, adjList, visited, dfsPath);
            }
        }
        System.out.println("DFS Path: " + dfsPath);
        System.out.println("no of connected components: " + count);
    }

    private void dfs(int source, List<List<Integer>> adjList, boolean[] visited, List<Integer> dfsPath) {

        // mark as visited
        visited[source] = true;
        dfsPath.add(source);

        // get all adjacent nodes of source
        List<Integer> adjNodes = adjList.get(source);
        for (int i = 0; i < adjNodes.size(); i++) {
            int nextNode = adjNodes.get(i);
            if (!visited[nextNode]) {
                dfs(nextNode, adjList, visited, dfsPath);
            }
        }
    }

    private List<List<Integer>> buildAdjacencyList(int[][] connections, int n) {

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            // undirected graph
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }

    public static void main(String[] args) {

        class_q1_dfsTraversal t1 = new class_q1_dfsTraversal();
        int n;
        int[][] connections;

        // test case 1
        n = 11;
        // undirected graph
        connections = new int[][] {
                { 1, 2 },
                { 1, 3 },
                { 2, 4 },
                { 2, 6 },
                { 3, 6 },
                { 3, 9 },
                { 4, 6 },
                { 4, 11 },
                { 5, 7 },
                { 5, 8 },
                { 5, 11 },
                { 6, 8 },
                { 7, 9 },
                { 7, 10 },
                { 8, 11 },
                { 9, 10 }
        };
        t1.performDFS(connections, n);

        // test case 2
        n = 15;
        // undirected graph
        connections = new int[][] {
                { 1, 2 },
                { 1, 3 },
                { 1, 6 },
                { 2, 3 },
                { 3, 4 },
                { 4, 6 },

                { 5, 7 },
                { 5, 9 },
                { 7, 8 },
                { 7, 9 },
                { 8, 9 },

                { 10, 11 },
                { 10, 14 },
                { 11, 14 },
                { 12, 14 },

                { 13, 15 }
        };
        t1.performDFS(connections, n);

    }
}
