import java.util.ArrayList;
import java.util.List;

/* Cycle in Undirected Graph */

/* Problem Description

Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain at least three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
1 <= A, M <= 3*10^5
1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].


Output Format
Return 1 if cycle is present else return 0.


Example Input

Input 1:
 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
Input 2:
 A = 3
 B = [  [1. 2]
        [1, 3]
     ]


Example Output

Output 1:
 1
Output 2:
 0


Example Explanation

Explanation 1:
 There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1
Explanation 2:
 No cycle present in the graph so we will return 0. */

/**
 * Detect cycle using DFS traversal
 * TC: O(n + m) => n no of nodes and m no of edges
 * SC: O(n + m) => visited array and adj list
 */
public class q5_Cycle_in_Undirected_Graph {

    public int solve(int A, int[][] B) {
        // build adjacency list
        List<List<Integer>> list = buildAdjList(A, B);

        boolean visited[] = new boolean[A + 1];
        for (int source = 1; source <= A; source++) {
            if (!visited[source]) {
                if (isCyclePresent(source, -1, list, visited)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    // detect cycle in undirected graph - DFS traversal
    public boolean isCyclePresent(int source, int parent, List<List<Integer>> list, boolean[] visited) {

        visited[source] = true;

        List<Integer> neighbors = list.get(source);
        for (int i = 0; i < neighbors.size(); i++) {
            int currNode = neighbors.get(i);
            if (!visited[currNode]) {
                if (isCyclePresent(currNode, source, list, visited)) {
                    return true;
                }
            } else {
                // if parent is different, it means the node is already visited by some other
                // node.
                // And hence cycle is detected
                if (currNode != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    // build adjacency list
    public List<List<Integer>> buildAdjList(int n, int[][] B) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++) {
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

}
