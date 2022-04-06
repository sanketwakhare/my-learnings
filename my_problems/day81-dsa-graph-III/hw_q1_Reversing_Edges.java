import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/* Reversing Edges */
/* https://www.geeksforgeeks.org/minimum-edges-reverse-make-path-source-destination/ */
/* Problem Description

Given a directed graph with A nodes and M edges.
Find the minimum number of edges that needs to be reversed in order to reach node A from node 1.



Problem Constraints

1 <= A, M <= 10^ 5
1 <= B[i][0], B[i][1] <= A
There can be multiple edges or self loops (B[i][0] = B[i][1])


Input Format

The first argument is an integer A, denoting the number of nodes in the graph.
The second argument is a 2D integer array B, denoting the directed edges in the graph.


Output Format

Return a single integer denoting the minimum number of edges to be reversed.


Example Input

Input 1:
A = 5
B = [[1, 2],
     [2, 3],
     [4, 3],
     [4, 5]]
Input 2:

A = 5
B = [[1, 2],
     [2, 3],
     [3, 4],
     [4, 5]]


Example Output

Output 1:
1
Output 2:

0


Example Explanation

Explanation 1:

Reversing the edge (4, 3) is only required.

Explanation 2:

There already exists a path between 1 and A, so no edges need to be reversed. */

/**
 * Idea: add a reverse edges with cost as 1 and apply Dijkstra's shortest path
 * algorithm
 */
public class hw_q1_Reversing_Edges {

    // this pair will be used for storing <node,distance> into Adjacency list
    class Pair implements Comparable<Pair> {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public int reverseEdges(int A, int[][] B) {

        // build adjacency list
        List<List<Pair>> list = buildAdjList(A, B);

        // maintain a distance array
        int[] dist = new int[A + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        // add source into Queue
        dist[1] = 0;
        queue.add(new Pair(1, dist[1]));

        while (!queue.isEmpty()) {

            Pair x = queue.poll();
            int parentNode = x.node;
            int parentWeight = x.weight;

            // if current weight in distance array is equal to weight in the pair
            if (parentWeight == dist[parentNode]) {
                // visit all its neighbors
                List<Pair> neighbors = list.get(parentNode);
                for (int i = 0; i < neighbors.size(); i++) {
                    Pair temp = neighbors.get(i);
                    int childNode = temp.node;
                    int childWeight = temp.weight;

                    if (dist[childNode] > childWeight + parentWeight) {
                        dist[childNode] = parentWeight + childWeight;
                        queue.add(new Pair(childNode, dist[childNode]));
                    }
                }
            }
        }

        // if there is no way to reach node A from node 1
        return dist[A] == Integer.MAX_VALUE ? -1 : dist[A];
    }

    public List<List<Pair>> buildAdjList(int A, int[][] B) {

        List<List<Pair>> list = new ArrayList<List<Pair>>();
        for (int i = 0; i <= A; i++) {
            list.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            if (u != v) {
                list.get(u).add(new Pair(v, 0));
                list.get(v).add(new Pair(u, 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {

        hw_q1_Reversing_Edges t1 = new hw_q1_Reversing_Edges();
        int A;
        int[][] B;

        // test case 1
        A = 5;
        B = new int[][] { { 1, 2 },
                { 2, 3 },
                { 4, 3 },
                { 4, 5 } };
        System.out.println(t1.reverseEdges(A, B)); // 1

        // test case 2
        A = 5;
        B = new int[][] { { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 5 } };
        System.out.println(t1.reverseEdges(A, B));

        // test case 3
        A = 6;
        B = new int[][] {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 1 },
                { 2, 3 },
                { 4, 2 },
                { 3, 4 },
                { 5, 5 },
                { 5, 5 } };
        System.out.println(t1.reverseEdges(A, B));

    }

}
