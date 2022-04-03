import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Check Bipartite Graph */

/* Problem Description
Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:
There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
1 <= A <= 100000
1 <= M <= min(A*(A-1)/2,200000)
0 <= B[i][0],B[i][1] < A


Input Format
The first argument given is an integer A.

The second argument given is the matrix B.


Output Format
Return 1 if the given graph is bipartite else return 0.


Example Input
Input 1:

A = 2
B = [ [0, 1] ]
Input 2:

A = 3
B = [ [0, 1], [0, 2], [1, 2] ]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

Put 0 and 1 into 2 different subsets.
Explanation 2:
 
It is impossible to break the graph down to make two different subsets for bipartite matching */

public class q3_Check_Bipartite_Graph {

    public int solve(int A, int[][] B) {

        int n = A;
        // initialize colors array with -1
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // build adjacency list
        List<List<Integer>> list = buildAdjacencyList(n, B, color);

        // mark source as visited and give one of the color
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 1;
                if (!isBipartiteGraph(i, list, color)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    // DFS traversal to check if given graph is Bipartite
    private boolean isBipartiteGraph(int source, List<List<Integer>> list, int[] color) {

        List<Integer> neighbors = list.get(source);
        for (int i = 0; i < neighbors.size(); i++) {
            int currNode = neighbors.get(i);
            if (color[currNode] == -1) {
                // if not already visited
                color[currNode] = color[source] ^ 1;
                if (!isBipartiteGraph(currNode, list, color)) {
                    return false;
                }
            }
            if (color[currNode] == color[source]) {
                // if any of the neighbor has same color, then it is not bipartite graph
                return false;
            }
        }
        return true;
    }

    // build adjacency list for undirected graph
    private List<List<Integer>> buildAdjacencyList(int n, int[][] B, int[] color) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return list;
    }

    public static void main(String[] args) {

        q3_Check_Bipartite_Graph t1 = new q3_Check_Bipartite_Graph();
        int A;
        int[][] B;

        // test case 1
        A = 3;
        B = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(t1.solve(A, B)); // 0

        // test case 2
        A = 2;
        B = new int[][] { { 0, 1 } };
        System.out.println(t1.solve(A, B)); // 1

        // test case 3
        A = 69;
        B = new int[][] {
                { 40, 64 },
                { 29, 60 },
                { 26, 43 },
                { 29, 32 },
                { 32, 47 },
                { 42, 61 },
                { 48, 61 },
                { 26, 52 },
                { 24, 34 },
                { 35, 55 },
                { 14, 60 },
                { 53, 62 },
                { 61, 63 },
                { 13, 53 },
                { 16, 62 },
                { 62, 64 },
                { 56, 68 },
                { 2, 23 },
                { 7, 55 },
                { 3, 60 },
                { 32, 51 },
                { 2, 18 },
                { 1, 43 },
                { 5, 37 },
                { 4, 51 },
                { 27, 55 },
                { 15, 30 },
                { 13, 65 },
                { 7, 13 },
                { 28, 48 },
                { 36, 50 },
                { 3, 7 },
                { 30, 46 },
                { 1, 35 },
                { 47, 68 },
                { 37, 62 },
                { 37, 58 },
                { 8, 22 },
                { 19, 45 },
                { 6, 64 },
                { 9, 55 },
                { 32, 46 },
                { 48, 56 },
                { 26, 59 },
                { 8, 46 },
                { 44, 66 },
                { 50, 60 },
                { 40, 46 },
                { 30, 68 },
                { 26, 44 },
                { 5, 32 },
                { 9, 34 },
                { 36, 45 },
                { 47, 48 }
        };
        System.out.println(t1.solve(A, B)); // 0

        A = 10;
        B = new int[][] { { 2, 8 },
                { 0, 8 },
                { 2, 7 },
                { 0, 5 },
                { 4, 8 },
                { 3, 7 },
                { 1, 4 },
                { 7, 9 },
                { 0, 9 },
                { 2, 3 },
                { 5, 8 } };
        System.out.println(t1.solve(A, B)); // 0
    }
}
