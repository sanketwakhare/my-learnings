/* Dijkstra */

/* Problem Description

Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

=> D[i] : Shortest distance form the C node to node i.

=> If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are numbered from 0 to A-1.

Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

1 <= A <= 1e5
0 <= B[i][0],B[i][1] < A
0 <= B[i][2] <= 1e3
0 <= C < A


Input Format

The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].

The third argument given is an integer C.



Output Format
Return the integer array D.



Example Input
Input 1:
A = 6
B = [   [0, 4, 9]
        [3, 4, 6] 
        [1, 2, 1] 
        [2, 5, 1] 
        [2, 4, 5] 
        [0, 3, 7] 
        [0, 1, 1] 
        [4, 5, 7] 
        [0, 5, 1] ] 
C = 4

Input 2:
A = 5
B = [   [0, 3, 4]
        [2, 3, 3] 
        [0, 1, 9] 
        [3, 4, 10] 
        [1, 3, 8]  ] 
C = 4


Example Output

Output 1:
D = [7, 6, 5, 6, 0, 6]
Output 2:
D = [14, 18, 13, 10, 0]


Example Explanation

Explanation 1:

 All Paths can be considered from the node C to get shortest path
Explanation 2:

 All Paths can be considered from the node C to get shortest path */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class q3_Dijkstra {

    static class DistanceToNodePair implements Comparable<DistanceToNodePair> {
        int dist;
        int node;

        public DistanceToNodePair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        public int compareTo(DistanceToNodePair pair) {
            return this.dist - pair.dist;
        }
    }

    static class NodeToWeightPair {
        int node;
        int weight;

        public NodeToWeightPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] solve(int A, int[][] B, int C) {

        // initialize distance array for each node from node C
        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // build adjacency list
        List<List<NodeToWeightPair>> list = buildAdjList(A, B);

        PriorityQueue<DistanceToNodePair> queue = new PriorityQueue<DistanceToNodePair>();
        dist[C] = 0;
        queue.add(new DistanceToNodePair(0, C));

        while (!queue.isEmpty()) {
            DistanceToNodePair x = queue.poll();
            int d = x.dist;
            int node = x.node;

            if (d == dist[node]) {
                // traverse all the neighboring nodes of the node x.node
                List<NodeToWeightPair> neighbors = list.get(node);
                for (NodeToWeightPair temp : neighbors) {
                    int t_node = temp.node;
                    int t_weight = temp.weight;

                    // if current distance is < distance in array, update the distance and add new
                    // distance pair in queue
                    if (dist[t_node] > dist[node] + t_weight) {
                        dist[t_node] = dist[node] + t_weight;
                        queue.add(new DistanceToNodePair(dist[t_node], t_node));
                    }
                }
            }
        }
        // if any node is not reachable, make it -1 as expected in output
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public List<List<NodeToWeightPair>> buildAdjList(int A, int[][] B) {

        List<List<NodeToWeightPair>> list = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] nodesInfo : B) {
            int u = nodesInfo[0];
            int v = nodesInfo[1];
            int weight = nodesInfo[2];
            list.get(u).add(new NodeToWeightPair(v, weight));
            list.get(v).add(new NodeToWeightPair(u, weight));
        }
        return list;
    }

    public static void main(String[] args) {

        q3_Dijkstra t1 = new q3_Dijkstra();
        int A, C;
        int[] dist;
        int[][] B;

        // test case 1
        A = 6;
        B = new int[][] {
                { 0, 4, 9 },
                { 3, 4, 6 },
                { 1, 2, 1 },
                { 2, 5, 1 },
                { 2, 4, 5 },
                { 0, 3, 7 },
                { 0, 1, 1 },
                { 4, 5, 7 },
                { 0, 5, 1 } };
        C = 4;
        dist = t1.solve(A, B, C);
        ArrayUtils.printArray(dist); // [ 7, 6, 5, 6, 0, 6 ]

        // test case 2
        A = 5;
        B = new int[][] {
                { 0, 3, 4 },
                { 2, 3, 3 },
                { 0, 1, 9 },
                { 3, 4, 10 },
                { 1, 3, 8 } };
        C = 4;
        dist = t1.solve(A, B, C);
        ArrayUtils.printArray(dist); // [ 14, 18, 13, 10, 0 ]
    }

}
