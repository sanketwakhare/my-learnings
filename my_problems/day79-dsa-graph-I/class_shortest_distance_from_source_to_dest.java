import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Find Shortest Distance between source and destination using BFS*/

public class class_shortest_distance_from_source_to_dest {

    class Pair {
        int node;
        int distanceFromSource;

        public Pair(int node, int distanceFromSource) {
            this.node = node;
            this.distanceFromSource = distanceFromSource;
        }
    }

    // build Graph with Adjacency List
    private List<List<Integer>> buildAdjacencyListGraph(int A, int[][] B) {
        // adjacency list
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // create empty lists
        for (int i = 0; i <= A; i++) {
            list.add(new ArrayList<Integer>());
        }

        // add edges to list
        for (int i = 0; i < B.length; i++) {
            int from = B[i][0];
            int to = B[i][1];
            list.get(from).add(to);
        }
        return list;
    }

    // BFS traversal
    private int shortestDistance(int A, int[][] B, int source, int target) {

        // adjacency list
        List<List<Integer>> list = buildAdjacencyListGraph(A, B);

        // initialization block
        // source, target, flag to identify if path exist, visited array and queue to
        // maintain BFS traversal
        boolean isPathExist = false;
        boolean[] visited = new boolean[A + 1];
        Queue<Pair> queue = new LinkedList<Pair>();

        // insert source into queue
        queue.add(new Pair(source, 0));
        // mark source as visited
        visited[source] = true;
        int dist = 0;

        // while all teh nodes are not visited
        while (!queue.isEmpty()) {
            // remove current node from queue
            Pair x = queue.poll();
            if (x.node == target) {
                // path exist
                isPathExist = true;
                dist = x.distanceFromSource;
                break;
            }
            // get all the immediate next nodes from x
            List<Integer> adjList = list.get(x.node);
            for (int i = 0; i < adjList.size(); i++) {

                int nextNode = adjList.get(i);
                // if nextNode is not visited already
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new Pair(nextNode, x.distanceFromSource + 1));
                }
            }
        }
        if (isPathExist) {
            return dist;
        }
        return 0;
    }

    public static void main(String[] args) {

        class_shortest_distance_from_source_to_dest t1 = new class_shortest_distance_from_source_to_dest();
        int A;
        int[][] B;

        // test case 1
        A = 5;
        B = new int[][] { { 1, 2 },
                { 4, 1 },
                { 2, 4 },
                { 3, 4 },
                { 5, 2 },
                { 1, 3 } };
        System.out.println(t1.shortestDistance(A, B, 1, 4)); // 2
        System.out.println(t1.shortestDistance(A, B, 3, 2)); // 3
        System.out.println(t1.shortestDistance(A, B, 1, 5)); // 0
        System.out.println(t1.shortestDistance(A, B, 5, 1)); // 3
        System.out.println(t1.shortestDistance(A, B, 5, 2)); // 1
        System.out.println(t1.shortestDistance(A, B, 5, 3)); // 4
        System.out.println(t1.shortestDistance(A, B, 5, 4)); // 2
    }
}
