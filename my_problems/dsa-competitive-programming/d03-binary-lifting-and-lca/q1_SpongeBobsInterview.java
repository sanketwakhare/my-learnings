/*
SpongeBob's Interview

Problem Description
SpongeBob has applied for a job and he got a call suddenly for an interview. Interviewer starts asking queries from SpongeBob. He is your friend and you need to help him solving queries.

Given a tree with A nodes. Queries are given by a 2D array C of size Q*4.

If C[i][0] = 1 : Find the distance between C[i][1]th node and C[i][2]th node.
If C[i][0] = 2 : Find the C[i][3]th node on the path from C[i][1]th node to C[i][2]th node.


Problem Constraints
1 <= A <= 105 1 <= Q <= 105
C[i][0] = 1 or C[i][0] = 2
1 <= C[i][1], C[i][2] <= A
if C[i][0] = 1, C[i][3] = 0
if C[i][0] = 2, C[i][3] <= length of path



Input Format
First argument is an integer A representing number of nodes in the tree
Second argument is a 2D array B of size (A-1) * 2 where B[i][0]th node is connected to B[i][1]th node.
Third argument is 2D array C of size Q*4 containing queries.



Output Format
Return an integer array D where D[i] represents the answer of ith query.



Example Input
Input 1:

  A : 4
  B :
  [
    [1, 2]
    [2, 3]
    [2, 4]
  ]
  C :
  [
    [2, 1, 3, 3]
    [2, 3, 4, 1]
    [2, 1, 4, 2]
  ]
Input 2:

  A : 8
  B :
  [
    [1, 2]
    [2, 3]
    [3, 4]
    [2, 5]
    [4, 6]
    [3, 7]
    [1, 8]
  ]
  C :
  [
    [2, 5, 4, 1]
    [1, 6, 6, 0]
  ]


Example Output
Output 1:

  [3, 3, 2]
Output 2:

  [5, 0]


Example Explanation
Explanation 1:

  First query- The path from 1 to 3 is 1,2 and 3. The third node is 3.
  Second query- The first node on the path from 3 to 4 is 3.
  Third query- The path from 1 to 4 is 1,2 and 4. The second node is 2.
Explanation 2:

  First query- The first node on the path from 5 to 4 is 5.
  Second query- Distance between 6 and 6 is 0.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1_SpongeBobsInterview {

    public static void main(String[] args) {
        q1_SpongeBobsInterview t = new q1_SpongeBobsInterview();
        {
            int A = 4;
            int[][] B = {{1, 2}, {2, 3}, {2, 4}};
            int[][] C = {{2, 1, 3, 3}, {2, 3, 4, 1}, {2, 1, 4, 2}};
            int[] result = t.solve(A, B, C);
            System.out.println(Arrays.toString(result)); // [3, 3, 2]
        }
        {
            int A = 11;
            int[][] B = {{1, 2}, {1, 3}, {3, 4}, {1, 5}, {4, 6}, {1, 7}, {6, 8}, {1, 9}, {9, 10}, {6, 11}};
            int[][] C = {{2, 7, 8, 2}, {1, 10, 3, 0}};
            int[] result = t.solve(A, B, C);
            System.out.println(Arrays.toString(result)); // [1, 3]
        }
        {
            int A = 8;
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {1, 5}, {2, 6}, {5, 7}, {5, 8}};
            int[][] C = {{1, 4, 2, 0}, {1, 7, 3, 0}, {2, 6, 2, 2}, {2, 3, 1, 1}, {2, 3, 2, 1}, {2, 2, 5, 2}, {1, 6, 2, 0}, {2, 2, 1, 1}, {1, 2, 5, 0}, {2, 8, 8, 1}};
            int[] result = t.solve(A, B, C);
            System.out.println(Arrays.toString(result)); // [1, 3, 2, 3, 3, 1, 1, 2, 2, 8]
        }
        {
            int A = 5;
            int[][] B = {{1, 2}, {2, 3}, {2, 4}, {1, 5}};
            int[][] C = {{1, 3, 4, 0}, {1, 1, 3, 0}, {1, 4, 2, 0}, {2, 1, 5, 1}, {1, 2, 2, 0}, {2, 4, 5, 4}};
            int[] result = t.solve(A, B, C);
            System.out.println(Arrays.toString(result)); // [2, 2, 1, 1, 0, 5]
        }
        {
            int A = 8;
            int[][] B = {{1, 2}, {2, 3}, {3, 4}, {2, 5}, {4, 6}, {3, 7}, {1, 8}};
            int[][] C = {{2, 5, 4, 1}, {1, 6, 6, 0}};
            int[] result = t.solve(A, B, C);
            System.out.println(Arrays.toString(result)); // [5, 0]
        }
    }

    public int[] solve(int A, int[][] B, int[][] C) {

        List<List<Integer>> adjList = buildAdjacencyList(A, B);

        int[] intime = new int[A + 1];
        int[] outtime = new int[A + 1];
        boolean[] vis = new boolean[A + 1];
        int[] time = {0};
        dfs_intime_outtime(1, -1, intime, outtime, adjList, vis, time);

        int[][] up = new int[A + 1][getLogNBase2(A)];
        for (int[] row : up) Arrays.fill(row, -1);
        vis = new boolean[A + 1];
        dfs_populate_up_parent_array(1, -1, adjList, up, vis);

        int[] levels = new int[A + 1];
        Arrays.fill(vis, false);
        dfs_find_levels(1, -1, -1, adjList, vis, levels);

        int[] result = new int[C.length];
        int i = 0;
        for (int[] query : C) {
            int answer;
            int type = query[0];
            if (type == 1) {
                int x = query[1];
                int y = query[2];
                int dist = distance(x, y, levels, up, intime, outtime);
                answer = dist - 1;
            } else {
                int k = query[3];
                int x = query[1];
                int y = query[2];

                int lca = lca(x, y, up, intime, outtime);
                int d1 = distance(x, lca, levels, up, intime, outtime);
                int d2 = distance(y, lca, levels, up, intime, outtime);

                if (k == 1) {
                    answer = x;
                } else if (k < d1) {
                    answer = kthAncestor(x, k - 1, up, A);
                } else {
                    answer = kthAncestor(y, d1 + d2 - k - 1, up, A);
                }
            }
            result[i++] = answer;
        }
        return result;
    }

    // find kth ancestor
    public int kthAncestor(int x, int k, int[][] up, int n) {
        if (k < 0) return -1;
        for (int i = getLogNBase2(n) - 1; i >= 0; i--) {
            if (k >= (1 << i) && x != -1) {
                x = up[x][i];
                k = k - (1 << i);
            }
        }
        return x;
    }

    // distance between node x and y
    public int distance(int x, int y, int[] levels, int[][] up, int[] intime, int[] outtime) {
        int lca = lca(x, y, up, intime, outtime);
        if (lca < 0) return -1;
        // considering distance between nodes inclusive of the start and end nodes
        // e.g. distance between x and x is 1
        return levels[x] + levels[y] - 2 * levels[lca] + 1;
    }

    // find level of each node from root
    public void dfs_find_levels(int curr, int parent, int parentLevel, List<List<Integer>> adjList, boolean[] vis, int[] levels) {
        vis[curr] = true;
        levels[curr] = parentLevel + 1;
        for (int neighbor : adjList.get(curr)) {
            if (!vis[neighbor] && neighbor != parent) {
                dfs_find_levels(neighbor, curr, parentLevel + 1, adjList, vis, levels);
            }
        }
    }

    // find lca of x and y
    public int lca(int x, int y, int[][] up, int[] intime, int[] outtime) {
        if (isAncestor(x, y, intime, outtime)) return x;
        if (isAncestor(y, x, intime, outtime)) return y;

        // go as much up as you can such that temp is not an ancestor of y
        // once we do this, we will be standing at the child of the LCA
        for (int i = up[0].length - 1; i >= 0; i--) {
            int temp = up[x][i];
            if (temp != -1 && !isAncestor(temp, y, intime, outtime)) {
                x = temp;
            }
        }
        // get 1st parent of x i.e. LCA
        return up[x][0];
    }

    // check if x is ancestor of y
    // TC: O(1)
    public boolean isAncestor(int x, int y, int[] intime, int[] outtime) {
        return x >= 0 && x < intime.length && y >= 0 && y < intime.length && intime[x] <= intime[y] && outtime[x] >= outtime[y];
    }

    // populate intime and outtime of each nodes
    // TC: O(N + M)
    // SC: O(N) for intime and outtime
    public void dfs_intime_outtime(int curr, int parent, int[] intime, int[] outtime, List<List<Integer>> adjList, boolean[] vis, int[] time) {
        vis[curr] = true;
        // update intime
        intime[curr] = ++time[0];
        for (int neighbor : adjList.get(curr)) {
            if (!vis[neighbor] && neighbor != parent) {
                dfs_intime_outtime(neighbor, curr, intime, outtime, adjList, vis, time);
            }
        }
        // update outtime
        outtime[curr] = ++time[0];
    }

    /**
     * Populate the up array which stores the ancestors info
     * up[i][0] = 2^0 parent of i = 1st parent of i
     * up[i][1] = 2^1 parent of i = 2nd parent of i
     * up[i][2] = 2^3 parent of i = 3rd parent of i
     * ...
     * up[i][logN-1] = 2^(logN - 1) parent of i
     */
    public void dfs_populate_up_parent_array(int curr, int parent, List<List<Integer>> adjList, int[][] up, boolean[] vis) {
        vis[curr] = true;

        up[curr][0] = parent;
        for (int i = 1; i < up[0].length; i++) {
            if (up[curr][i - 1] != -1) {
                up[curr][i] = up[up[curr][i - 1]][i - 1];
            }
        }

        for (int neighbor : adjList.get(curr)) {
            if (!vis[neighbor] && neighbor != parent) {
                dfs_populate_up_parent_array(neighbor, curr, adjList, up, vis);
            }
        }
    }

    // get logNBase2 value of x
    public int getLogNBase2(int x) {
        return (int) Math.ceil(Math.log(x) / Math.log(2));
    }

    // build adjacency list
    // TC: O(N + M)
    // SC: O(N + M)
    public List<List<Integer>> buildAdjacencyList(int A, int[][] B) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
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
