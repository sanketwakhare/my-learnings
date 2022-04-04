import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* Topological Sort */

/* Problem Description

Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexicographically smallest one.

Ordering (a, b, c) is said to be lexicographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 104
1 <= M <= min(100000,A*(A-1))
1 <= B[i][0], B[i][1] <= A


Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.

Example Input

Input 1:
 A = 6
 B = [  [6, 3] 
        [6, 1] 
        [5, 1] 
        [5, 2] 
        [3, 4] 
        [4, 2] ]
Input 2:
 A = 3
 B = [  [1, 2]
        [2, 3] 
        [3, 1] ]


Example Output

Output 1:
 [5, 6, 1, 3, 4, 2]
Output 2:
 []


Example Explanation

Explanation 1:

 The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
Explanation 2:

 The given graph contain cycle so topological ordering not possible we will return empty array. */

/**
 * TC: O(m + n) - similar to BFS traversal
 * SC: O(m + n)
 */
public class q1_Topological_Sort {

    public int[] solve(int A, int[][] B) {

        // build adjacency list and in degree array
        int[] inDegree = new int[A + 1];
        List<List<Integer>> list = buildAdjList(A, B, inDegree);

        // push all nodes with inDegree as 0 into PriorityQueue
        // taking priority queue as we need output in lexicographical order
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        List<Integer> path = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            // get current node which from queue adn traverse all its neighbors
            int x = queue.poll();
            path.add(x);
            List<Integer> neighbors = list.get(x);
            for (int i = 0; i < neighbors.size(); i++) {
                // decrement inDegree of neighbor
                int temp = neighbors.get(i);
                inDegree[temp]--;
                // if inDegree of neighbor is 0, all node to queue
                if (inDegree[temp] == 0)
                    queue.add(temp);
            }
        }

        // if it is possible to resolve all dependencies, then convert the list into
        // array and return the array
        if (path.size() == A) {
            int[] ans = new int[A];
            for (int i = 0; i < path.size(); i++) {
                ans[i] = path.get(i);
            }
            return ans;
        }
        // otherwise return empty array
        return new int[] {};
    }

    /**
     * build adjacency list
     */
    private List<List<Integer>> buildAdjList(int A, int[][] B, int[] inDegree) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= A; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            inDegree[v]++;
            list.get(u).add(v);
        }
        return list;
    }

    public static void main(String[] args) {

        q1_Topological_Sort t1 = new q1_Topological_Sort();
        int A;
        int[][] B;

        // test case 1
        A = 6;
        B = new int[][] { { 6, 3 },
                { 6, 1 },
                { 5, 1 },
                { 5, 2 },
                { 3, 4 },
                { 4, 2 } };
        ArrayUtils.printArray(t1.solve(A, B)); // [ 5, 6, 1, 3, 4, 2 ]

        // test case 2
        A = 8;
        B = new int[][] { { 1, 4 },
                { 1, 2 },
                { 4, 2 },
                { 4, 3 },
                { 3, 2 },
                { 5, 2 },
                { 3, 5 },
                { 8, 2 },
                { 8, 6 }
        };
        ArrayUtils.printArray(t1.solve(A, B)); // [ 1, 4, 3, 5, 7, 8, 2, 6 ]

        // test case 3
        A = 3;
        B = new int[][] { { 1, 2 },
                { 2, 3 },
                { 3, 1 } };
        ArrayUtils.printArray(t1.solve(A, B)); // []
    }
}
