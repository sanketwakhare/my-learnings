import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Path in Directed Graph */

/* Problem Description

Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 10^5
1 <= M <= min(200000,A*(A-1))
1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return 1 if path exists between node 1 to node A else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 The given doesn't contain any path from node 1 to node 5 so we will return 0.
Explanation 2:

 Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1. */
public class q1_Path_in_Directed_Graph {

    public int solve(int A, int[][] B) {

        List<List<Integer>> list = buildAdjacencyListGraph(A, B);

        return isPathPresent(A, list, 1, A);
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
    private int isPathPresent(int A, List<List<Integer>> list, int source, int target) {

        // initialization block
        // source, target, flag to identify if path exist, visited array and queue to
        // maintain BFS traversal
        boolean isPathExist = false;
        boolean[] visited = new boolean[A + 1];
        Queue<Integer> queue = new LinkedList<Integer>();

        // insert source into queue
        queue.add(source);
        // mark source as visited
        visited[source] = true;

        // while all teh nodes are not visited
        while (!queue.isEmpty()) {
            // remove current node from queue
            int x = queue.poll();

            // get all the immediate next nodes from x
            List<Integer> adjList = list.get(x);
            for (int i = 0; i < adjList.size(); i++) {

                int nextNode = adjList.get(i);
                if (nextNode == target) {
                    // path exist
                    isPathExist = true;
                    break;
                }
                // if nextNode is not visited already
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
        return isPathExist ? 1 : 0;
    }

    public static void main(String[] args) {

        q1_Path_in_Directed_Graph t1 = new q1_Path_in_Directed_Graph();
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
        System.out.println(t1.solve(A, B)); // 0

        // test case 2
        A = 5;
        B = new int[][] { { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 5 } };
        System.out.println(t1.solve(A, B)); // 1

        // test case 3
        A = 5;
        B = new int[][] { { 1, 4 },
                { 2, 1 }, { 4, 3 }, { 4, 5 }, { 2, 3 }, { 2, 4 }, { 1, 5 }, { 5, 3 },
                { 2, 5 }, { 5, 1 }, { 4, 2 }, { 3, 1 }, { 5, 4 }, { 3, 4 }, { 1, 3 }, { 4, 1 }, { 3, 5 }, { 3, 2 },
                { 5, 2 } };
        System.out.println(t1.solve(A, B)); // 1
    }

}
