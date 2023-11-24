import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bi-connected Xor
 * <p>
 * Problem Description
 * Given a undirected graph with N nodes labelled from 1 to N containing M edges given in a form of 2D-matrix B of size M * 2 where B[i][0] and B[i][1] denotes two nodes connected by an edge.
 * <p>
 * You are also given an 1D integer array A of size N denoting the weights assigned to each node.
 * <p>
 * Your task is as follows:
 * <p>
 * Delete a node and all of the edges associated with it such that the number of connected components increases by atleast one.
 * After deletion calculate the sum of the weights of nodes in each of the connected components.
 * Perform XOR of all those values obtained in above step.
 * You need to find the maximum of XOR value you can obtain by deleting exactly 1 node between 1 to N.
 * <p>
 * If it is not possible to delete a node that will increase the number of connected components then simply return -1.
 * <p>
 * NOTE:
 * <p>
 * Input graph is connected.
 * No multiple edges and self loops are present.
 * Nodes are labelled from 1 to N but input array A is 0 indexed so make sure to handle that.
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= N <= 3*105
 * <p>
 * N - 1 <= M <= min(3*105, ( N * ( N - 1 ) ) / 2)
 * <p>
 * 1 <= B[i][0], B[i][1] <= N
 * <p>
 * 1 <= A[i] <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an 1D integer array A of size N denoting weights assigned to each node.
 * <p>
 * Second argument is an 2D integer array B of size M * 2 denoting the M edges for eg. (B[i][0], B[i][1]) denotes two nodes connected by an edge.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer denoting the maximum of XOR value you can obtain by deleting exactly 1 node between 1 to N.
 * <p>
 * If it is not possible to delete a node that will increase the number of connected components then simply return -1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5, 6]
 * B = [  [1, 2]
 * [1, 3]
 * [1, 4]
 * [2, 3]
 * [3, 5]
 * [3, 6]
 * [4, 6]
 * ]
 * Input 2:
 * <p>
 * A = [11, 2, 13]
 * B = [  [1, 2]
 * [1, 3]
 * [2, 3]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 8
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * We have only one possible way to increase the number of connected components i.e when we remove node 3, the above graph
 * gets divided into two components  {1, 2, 4, 6} and {5}. Else if we remove any of the other nodes the graph remain connected only.
 * <p>
 * So when we remove 3 graph breaks down into two components:
 * Component 1: Sum of weights of nodes{1, 2, 4, 6} = A[1] + A[2] + A[4] + A[6] = 1 + 2 + 4 + 6 = 13
 * Component 2: Sum of weight of node {5} = A[5] = 5
 * <p>
 * So the maximum possible XOR is 13 ^ 5 = 8.
 * Explanation 2:
 * <p>
 * We have no possible way to increase the number of connected components by deleting any node so we return -1.
 */
public class hw_q2_Bi_connected_Xor {

    int time = 0;

    public static void main(String[] args) {
        hw_q2_Bi_connected_Xor t = new hw_q2_Bi_connected_Xor();

        int[] a1 = {1, 2, 3, 4, 5, 6};
        int[][] b1 = {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 5}, {3, 6}, {4, 6}};
        int res1 = t.solve(a1, b1);
        System.out.println(res1); // 8

        int[] a2 = {11, 2, 13};
        int[][] b2 = {{1, 2}, {1, 3}, {2, 3}};
        int res2 = t.solve(a2, b2);
        System.out.println(res2); // -1

        // TODO: failing for this test case
        int[] a3 = {42, 468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812, 323, 334, 674, 665, 142, 712, 254, 869, 548, 645};
        int[][] b3 = {{44, 50}, {23, 26}, {20, 45}, {4, 26}, {12, 33}, {9, 41}, {30, 51}, {2, 26}, {2, 23}, {16, 18}, {32, 51}, {30, 49}, {46, 52}, {13, 31}, {2, 37}, {11, 44}, {22, 23}, {31, 40}, {1, 5}, {13, 44}, {6, 13}, {23, 37}, {29, 37}, {8, 43}, {13, 37}, {30, 36}, {11, 39}, {11, 42}, {29, 32}, {28, 32}, {26, 37}, {28, 45}, {7, 31}, {15, 46}, {31, 51}, {15, 19}, {22, 36}, {6, 47}, {10, 48}, {19, 27}, {2, 19}, {11, 40}, {33, 35}, {8, 38}, {38, 43}, {3, 36}, {1, 16}, {22, 32}, {18, 20}, {31, 43}, {18, 44}, {5, 33}, {21, 42}, {17, 29}, {2, 51}, {12, 19}, {13, 47}, {18, 38}, {22, 27}, {15, 21}, {10, 31}, {16, 20}, {44, 45}, {2, 11}, {7, 36}, {8, 47}, {25, 38}, {10, 36}, {1, 41}, {5, 49}, {11, 38}, {32, 40}, {32, 37}, {17, 45}, {6, 37}, {2, 10}, {13, 48}, {3, 26}, {5, 9}, {43, 50}, {17, 52}, {2, 42}, {10, 27}, {24, 37}, {37, 51}, {10, 29}, {24, 46}, {38, 46}, {46, 51}, {14, 44}, {6, 39}, {31, 35}, {39, 41}, {2, 15}, {3, 13}, {16, 27}, {20, 23}, {16, 28}, {12, 20}, {3, 4}, {26, 35}, {12, 50}, {35, 41}, {21, 30}, {27, 52}, {2, 45}, {23, 45}, {14, 51}};
        int res3 = t.solve(a3, b3);
        System.out.println(res3); // expected : 29153
        // node 38 is articulation point
        // 3 connected components after deleting node 38
        // with sum weights as 28329 (all nodes except 25, 34 and 38), 293(node 25), 539(node 34)
        // 28329 ^ 293 ^ 539 = 28055 which is incorrect as per expectation (29153)

        int[] a4 = {335, 501, 170, 725, 479, 359, 963};
        int[][] b4 = {{1, 2}, {2, 3}, {3, 1}, {2, 4}, {2, 5}, {2, 7}, {4, 6}, {5, 6}};
        int res4 = t.solve(a4, b4);
        System.out.println(res4); // expected: 1057
    }

    public int solve(int[] A, int[][] B) {

        time = 0;
        int n = A.length;
        Set<Integer> artPoints = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] disc = new int[n + 1];
        int[] low = new int[n + 1];
        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, -1, disc, low, artPoints, adj, vis);
            }
        }

        int[] articulationPoints = artPoints.stream().mapToInt(i -> i).toArray();

        int maxXor = 0;
        for (int currArtPoint : articulationPoints) {
            // perform DFS
            int currXor = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                List<Integer> sumList = new ArrayList<>();
                if (!visited[i] && i != currArtPoint) {
                    dfs_xor(i, currArtPoint, adj, visited, sumList);
                }
                int currSum = 0;
                for (int el : sumList) {
                    currSum += A[el - 1];
                }
                currXor = currXor ^ currSum;
            }
            maxXor = Math.max(maxXor, currXor);
        }

        // find max XOR
        return articulationPoints.length == 0 ? -1 : maxXor;
    }

    private void dfs_xor(int currNode, int currArtPoint, List<List<Integer>> adj, boolean[] vis, List<Integer> sumList) {
        sumList.add(currNode);
        vis[currNode] = true;
        for (int neighbor : adj.get(currNode)) {
            if (neighbor != currArtPoint && !vis[neighbor]) {
                dfs_xor(neighbor, currArtPoint, adj, vis, sumList);
            }
        }
    }

    public void dfs(int curr, int parent, int[] disc, int[] low, Set<Integer> artPoints, List<List<Integer>> adj, boolean[] vis) {
        int children = 0;
        disc[curr] = low[curr] = ++time;
        vis[curr] = true;

        for (int neighbor : adj.get(curr)) {
            if (neighbor != parent) {
                if (!vis[neighbor]) {
                    children++;
                    dfs(neighbor, curr, disc, low, artPoints, adj, vis);
                    low[curr] = Math.min(low[curr], low[neighbor]);

                    if (parent != -1 && low[neighbor] >= disc[curr]) {
                        artPoints.add(curr);
                    }
                } else {
                    low[curr] = Math.min(low[curr], disc[neighbor]);
                }
            }
        }

        if (parent == -1 && children > 1) {
            artPoints.add(curr);
        }
    }
}
