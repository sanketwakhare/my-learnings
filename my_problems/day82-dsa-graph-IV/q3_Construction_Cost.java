import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Construction Cost */

/* Problem Description

Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.


Problem Constraints

1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 10^9


Input Format

First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]



Output Format

Return an integer denoting the minimum construction cost.



Example Input

Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output

Output 1:

9
Output 2:

37


Example Explanation

Explanation 1:

We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of construction is 9.
Explanation 2:

We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node. */
public class q3_Construction_Cost {
    // custom object type to store the edge and weight information
    class Pair implements Comparable<Pair> {
        int u;
        int v;
        int weight;

        public Pair(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public int solve(int A, int[][] B) {

        long minCost = 0;
        long m = 1000000007;

        // build edge list
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int weight = B[i][2];
            list.add(new Pair(u, v, weight));
        }
        // sort the edges by weight in ascending order
        Collections.sort(list);

        // initialize parent array. this means every node is parent of itself[each node
        // represents unique connect component initially]
        int parent[] = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        // check for edge if it can be considered in minimum spanning tree
        for (Pair edge : list) {
            // union method combines 2 different components at a given time
            if (union(edge, parent)) {
                // if edge is considered, add weight to cost
                minCost = ((minCost % m) + ((long) edge.weight % m)) % m;
            }
        }

        return (int) minCost;
    }

    private boolean union(Pair edge, int[] parent) {

        // find parent of source and target node of edge
        int x = edge.u;
        int y = edge.v;
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);

        // if x and y are part of different components, only then combine them
        if (parent_x != parent_y) {
            parent[parent_x] = parent_y;
            return true;
        }
        // return false when x and y are part of same component
        return false;
    }

    private int findParent(int x, int[] parent) {

        // base condition when parent of x = x
        if (parent[x] == x)
            return x;

        // find top most parent of x
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {

        q3_Construction_Cost t1 = new q3_Construction_Cost();
        int A;
        int[][] B;

        // test case 1
        A = 4;
        B = new int[][] { { 1, 2, 1 },
                { 2, 3, 4 },
                { 1, 4, 3 },
                { 4, 3, 2 },
                { 1, 3, 10 } };
        System.out.println(t1.solve(A, B)); // 6

        // test case 2
        A = 3;
        B = new int[][] { { 1, 2, 14 },
                { 2, 3, 7 },
                { 3, 1, 2 } };
        System.out.println(t1.solve(A, B)); // 9

        // test case 3
        A = 3;
        B = new int[][] {
                { 1, 2, 20 },
                { 2, 3, 17 } };
        System.out.println(t1.solve(A, B)); // 37

    }
}
