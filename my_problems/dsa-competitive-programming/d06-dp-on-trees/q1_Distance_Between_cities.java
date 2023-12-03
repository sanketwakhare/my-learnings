/*
Distance between cities

Problem Description
The country TreeLand consists on N cities connected by N-1 bidirectional roads such that you can reach to any city from any other city.

The king of the country decided to add new roads to the country map. In particular, he connected any two city u and v that were not connected with a direct road but share a common neighbor, i.e. there exists such a city w that the original map has a road between u and w and a road between w and v.

You are asked to compute the sum of pairwise distances between all pairs of city in the new map.

The distance between two stations is the minimum possible number of roads on a path between them.

Since the answer could be large output answer mod 109 + 7

NOTE: Pair (a, b) is similar to (b, a). So need to count it only once.

Problem Constraints
2 <= N <= 2 * 105
1 <= B[i][0] , B[i][1] <= N

Input Format
First argument is an integer A denoting the number of cities N.
Second argument is a 2D array b of size (N-1) x 2 denoting the roads where ith road is between B[i][0] and B[i][1] cities.

Output Format
Return an integer denoting the sum of pairwise distances between all pairs of city in new map.


Example Input
Input 1:

 A = 4
 B = [
       [1, 2]
       [1, 3]
       [1, 4]
     ]
Input 2:

 A = 4
 B = [
       [1, 2]
       [2, 3]
       [3, 4]
     ]

Example Output
Output 1:
 6
Output 2:
 7

Example Explanation
Explanation 1:

 In the new map all pairs of cities share a direct road, so the sum of distances is 6.
Explanation 2:

 The new map has a direct road between all pairs of cities except for the pair (1, 4). For these two cities the distance is 2.
 So the total distance is 7
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1_Distance_Between_cities {

    public static void main(String[] args) {
        q1_Distance_Between_cities t = new q1_Distance_Between_cities();
        {
            int A = 4;
            int[][] B = {{1, 2}, {1, 3}, {1, 4}};
            int res = t.solve(A, B);
            System.out.println(res); // 6
        }
        {
            int A = 4;
            int[][] B = {{1, 2}, {2, 3}, {3, 4}};
            int res = t.solve(A, B);
            System.out.println(res); // 7
        }
        {
            int A = 6;
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}};
            int res = t.solve(A, B);
            System.out.println(res); // 20
        }
    }

    public int solve(int A, int[][] B) {
        int m = 1000000007;
        List<List<Integer>> adjList = buildAdjacencyList(A, B);

        // parent[i] = parent node of ith node
        int[] parent = new int[A + 1];
        Arrays.fill(parent, -1);
        // count[i] = no of nodes in subtree of i including ith node
        int[] count = new int[A + 1];
        // no of nodes at odd level
        int[] oddLevelsNodeCount = {0};
        // populate parent, count and oddLevelsNodeCount arrays
        dfs(1, -1, adjList, parent, count, oddLevelsNodeCount, true);

        // using contribution technique, consider each edge, and find no of nodes form either sides and multiple
        long ans = 0;
        for (int[] edge : B) {
            int child;
            int u = edge[0];
            int v = edge[1];
            if (v == parent[u]) {
                // v is parent of u
                child = u;
            } else {
                // u is parent of v
                child = v;
            }
            ans += (long) count[child] * (A - count[child]);
        }
        // at this point ans has original sum of all pairs

        long oddLevelNodes = oddLevelsNodeCount[0];
        long evenLevelsNodes = A - oddLevelsNodeCount[0];
        long pairsNeedDistanceOptimization = oddLevelNodes * evenLevelsNodes;
        ans = (ans - pairsNeedDistanceOptimization) / 2 + pairsNeedDistanceOptimization;
        ans = ans % m;
        ans = ans < 0 ? (ans + m) % m : ans;
        return (int) ans;
    }

    // TC: O(N + E)
    public int dfs(int curr, int p, List<List<Integer>> adjList, int[] parent, int[] count, int[] oddLevelsNodeCount, boolean isOdd) {
        parent[curr] = p;
        if (isOdd) oddLevelsNodeCount[0]++;
        count[curr] = 1;
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != p) {
                count[curr] += dfs(neighbor, curr, adjList, parent, count, oddLevelsNodeCount, !isOdd);
            }
        }
        return count[curr];
    }

    // build adjacency list
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
