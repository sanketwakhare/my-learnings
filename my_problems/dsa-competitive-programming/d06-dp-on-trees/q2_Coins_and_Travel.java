import java.util.*;

/*
Coins and Travel

Problem Description

Robin wants to travel a country which has N cities connected by N-1 bi-directional roads.

The cities and roads of the country are weird as they give A[v] coins on visiting the city v and it cost coins equal to length of a road on visiting the road.

He will select any two cities X and Y (X may also be equal to Y), and travel from X to Y via simple path(visiting a road at most once) such that he lefts with maximum coins at the end.

Return the maximum coins he can have, since the answer could be large return answer % 109 + 7.

Note: The number of coins with him can't be negative at any point of time.


Problem Constraints

1 <= N <= 10^5
0 <= A[i] <= 10^5
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 10^5


Input Format

First argument is an integer array A of size N denoting the coins at cities.
Second argument is a 2D array B of size N-1 x 3 where the ith road is between B[i][0] and B[i][1] city and of length B[i][2].

Output Format
Return an integer denoting the maximum coins he can have at the end of tour.



Example Input

Input 1:

 A = [1, 3, 3]
 B = [
       [1, 2, 2]
       [1, 3, 2]
     ]
Input 2:

 A = [6, 3, 2, 5, 0]
 B = [
       [1, 2, 10]
       [2, 3, 3]
       [2, 4, 1]
       [1, 5, 1]
     ]


Example Output

Output 1:

 3
Output 2:

 7


Example Explanation

Explanation 1:

 The optimal way is to travel from (2, 3) via 2->1->3. Coins remaining will be 3 (3 - 2 + 1 - 2 + 3).
Explanation 2:

 The optimal way is to travel from (2, 4) via 2->4.
 */
public class q2_Coins_and_Travel {
    public static void main(String[] args) {
        q2_Coins_and_Travel t = new q2_Coins_and_Travel();
        {
            int[] A = {6, 3, 2, 5, 0};
            int[][] B = {{1, 2, 10}, {2, 3, 3}, {2, 4, 1}, {1, 5, 1}};
            int res = t.solve(A, B);
            System.out.println(res);
        }
        {
            int[] A = {6, 4, 3, 6, 4, 0, 9, 7, 0, 7, 7};
            int[][] B = {{1, 2, 4}, {2, 3, 10}, {3, 4, 5}, {3, 5, 1}, {3, 6, 1}, {4, 7, 3}, {4, 8, 10}, {6, 9, 2}, {5, 10, 3}, {6, 11, 10}};
            int res = t.solve(A, B);
            System.out.println(res);
        }
    }

    long m = 1000000007;

    private static class Node {
        int tgt;
        long wt;

        public Node(int tgt, long wt) {
            this.tgt = tgt;
            this.wt = wt;
        }
    }

    public int solve(int[] A, int[][] B) {
        int n = A.length;

        // build adjacency list
        Map<Integer, List<Node>> adjList = buildAdjList(B);

        // dp[i] represents max points path starting with ith node
        long[] dp = new long[n + 1];
        // ans[i] represents max points path passing through ith node
        long[] ans = new long[n + 1];
        dfs(1, -1, adjList, dp, A, ans);

        // find max points
        long maxPoints = 0;
        for (long e : ans) maxPoints = Math.max(maxPoints, e);
        maxPoints = maxPoints % m;
        return (int) maxPoints;
    }

    private void dfs(int curr, int parent, Map<Integer, List<Node>> adjList, long[] dp, int[] points, long[] ans) {

        long max1 = 0;
        long max2 = 0;

        long maxPoints = points[curr - 1];
        for (Node childNode : adjList.get(curr)) {
            int neighbor = childNode.tgt;
            if (neighbor != parent) {
                long wt = childNode.wt;

                dfs(neighbor, curr, adjList, dp, points, ans);

                long currMaxPoints = dp[neighbor] - wt;
                maxPoints = Math.max(maxPoints, currMaxPoints + points[curr - 1]);

                // take max 2 values from the child nodes
                if (currMaxPoints > max1) {
                    max2 = max1;
                    max1 = currMaxPoints;
                } else if (currMaxPoints > max2) {
                    max2 = currMaxPoints;
                }
            }
        }
        ans[curr] = (points[curr - 1] + max1 + max2) % m;
        dp[curr] = maxPoints;
    }

    public Map<Integer, List<Node>> buildAdjList(int[][] B) {
        Map<Integer, List<Node>> adjList = new HashMap<>();
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            Node node1 = new Node(v, w);
            List<Node> list1 = adjList.get(u);
            if (Objects.isNull(list1)) {
                list1 = new ArrayList<>();
                adjList.put(u, list1);
            }
            list1.add(node1);

            Node node2 = new Node(u, w);
            List<Node> list2 = adjList.get(v);
            if (Objects.isNull(list2)) {
                list2 = new ArrayList<>();
                adjList.put(v, list2);
            }
            list2.add(node2);
        }
        return adjList;
    }

}
