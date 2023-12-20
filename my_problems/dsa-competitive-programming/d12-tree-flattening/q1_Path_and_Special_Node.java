import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Path and Special Node

Problem Description

Given a Tree with N nodes numbered 1 to N. Also, given a special node denoted by integer A.

2D array B of size (N-1) x 2 denotes the edges between the nodes of Tree.

You are asked to answer Q queries of the following type:
For each query, given two integers X and V, Output 1 if X exists in the path of (A, V). Else output 0.


Problem Constraints
1 <= N, Q <= 10^5
1 <= A, B[i][0], B[i][1], X, V <= N


Input Format
First argument is an integer A denoting the special Node.
Second argument is a 2D array B of size N-1 x 2, where ith edge if between B[i][0] and B[i][1] node.
Third argument is a 2D array C of size Q x 2. For ith Query, X = C[i][0] and V = C[i][1].



Output Format
Return an integer array of size Q denoting the output of every query.



Example Input
Input 1:
 A = 1
 B = [
       [1, 2]
       [1, 3]
       [1, 4]
       [3, 5]
       [3, 6]
     ]
 C = [
       [5, 6]
       [3, 5]
       [4, 2]
     ]

Input 2:
 A = 3
 B = [
       [1, 2]
       [1, 3]
       [1, 4]
       [3, 5]
       [3, 6]
       [2, 8]
       [4, 7]
     ]
 C = [
       [1, 7]
       [5, 8]
       [5, 5]
     ]


Example Output
Output 1:
 [0, 1, 0]
Output 2:
 [1, 0, 1]


Example Explanation

Explanation 1:

 Tree:         1
             / | \
            2  3  4
              / \
             5   6
 Special Node: 1
 First Query : X = 5, V = 6. Path (1, 6) = 1 -> 3 -> 6, there is no node 5 in the path. So output 0.
 Second Query: X = 3, V = 5. Path (1, 5) = 1 -> 3 -> 5, there is node 3 in the path. So output 1.
 Third Query : X = 4, V = 2. Path (1, 2) = 1 -> 2, there is no node 4 in the path. So output 0.
Explanation 2:

 Tree:         1
             / | \
            2  3  4
           /  / \  \
          8  5   6  7
 Special Node: 3
 First Query : X = 1, V = 7. Path (3, 7) = 3 -> 1 -> 4 -> 7, there is node 1 in the path. So output 1.
 Second Query: X = 5, V = 8. Path (3, 8) = 3 -> 1 -> 2 -> 8, there is no node 5 in the path. So output 0.
 Third Query : X = 5, V = 5. Path (3, 5) = 3 -> 5, there is node 5 in the path. So output 1.
 */

/*
Idea: Rooting a tree with given node A and find answer for each query using isAncestor method.
 */
public class q1_Path_and_Special_Node {

    public static void main(String[] args) {
        q1_Path_and_Special_Node t = new q1_Path_and_Special_Node();
        {
            int A = 1;
            int[][] B = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};
            int[][] C = new int[][]{{5, 6}, {3, 5}, {4, 2}};
            System.out.println(Arrays.toString(t.solve(A, B, C))); // [0, 1, 0]
        }
        {
            int A = 3;
            int[][] B = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}, {2, 8}, {4, 7}};
            int[][] C = new int[][]{{1, 7}, {5, 8}, {5, 5}};
            System.out.println(Arrays.toString(t.solve(A, B, C))); // [1, 0, 1]
        }
    }

    // TC: O(N + E + Q)
    // SC: 3 * N + E for adjacency list, start and end arrays
    // ~ O(N + E)
    public int[] solve(int A, int[][] B, int[][] C) {
        int n = B.length + 1;
        List<List<Integer>> adjList = buildAdjList(n, B);

        int[] start = new int[n + 1];
        int[] end = new int[n + 1];
        int[] time = {0};
        // make root as A and populate start and end arrays
        dfs(A, -1, adjList, start, end, time);

        int[] result = new int[C.length];
        int i = 0;
        for (int[] query : C) {
            int x = query[0];
            int v = query[1];
            // check if A is ancestor of V and also check if X is ancestor of V
            if (isAncestor(A, x, start, end) && isAncestor(x, v, start, end)) {
                result[i++] = 1;
            } else {
                result[i++] = 0;
            }
        }
        return result;
    }

    // is x ancestor of y
    private boolean isAncestor(int x, int y, int[] start, int[] end) {
        return start[x] <= start[y] && end[x] >= end[y];
    }

    public void dfs(int curr, int parent, List<List<Integer>> adjList, int[] start, int[] end, int[] time) {
        start[curr] = time[0]++;
        for (Integer neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                dfs(neighbor, curr, adjList, start, end, time);
            }
        }
        end[curr] = time[0]++;
    }

    private List<List<Integer>> buildAdjList(int n, int[][] B) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
