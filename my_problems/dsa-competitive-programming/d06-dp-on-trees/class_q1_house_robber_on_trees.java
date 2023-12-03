import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a tree of N nodes, each node will have some value(coin).
Find the max value(coin) robber can rob such that 2 adjacent nodes are robber.
 */
public class class_q1_house_robber_on_trees {
    public static void main(String[] args) {
        class_q1_house_robber_on_trees t = new class_q1_house_robber_on_trees();
        {
            int A = 7;
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}};
            int[] C = {1, 2, 3, 4, 5, 6, 7}; // 1 based indexed
            int res = t.solve(A, B, C);
            System.out.println(res); // 23
        }
        {
            int A = 7;
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}};
            int[] C = {11, 2, 7, 1, 4, 9, 3}; // 1 based indexed
            int res = t.solve(A, B, C);
            System.out.println(res); // 28
        }
    }

    public int solve(int A, int[][] B, int[] coins) {
        List<List<Integer>> adjList = buildAdjacencyList(A, B);
        int[][] dp = new int[A + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);

        // dp[i][0] = maximum money/value in subtree of (i) such that (i) is not picked and no 2 adjacent elements are allowed
        // dp[i][0] = sum of { dp[child of [i][1] }

        // dp[i][1] = maximum money/value in subtree of (i) such that no 2 adjacent elements are allowed. i.e. (i) can be picked
        // dp[i][1] = max [ max money if root is picked,
        //                  max money if root is not picked ]
        //          = max [ coins[i-1] + sum of { dp[child][0] },
        //                  sum of { dp[child][1] } ]

        int maxvalueIfRootIsPicked = dfs(1, -1, 1, adjList, coins, dp);
        int maxvalueIfRootIsNotPicked = dfs(1, -1, 0, adjList, coins, dp);
        return Math.max(maxvalueIfRootIsPicked, maxvalueIfRootIsNotPicked);
    }

    // TC: O(N + E)
    private int dfs(int curr, int parent, int canTake, List<List<Integer>> adjList, int[] coins, int[][] dp) {

        // if answer is already present/known
        if (dp[curr][canTake] != -1) return dp[curr][canTake];

        int maxValue = 0;
        int ans = 0;
        if (canTake == 0) {
            for (int neighbor : adjList.get(curr)) {
                if (neighbor != parent) {
                    ans += dfs(neighbor, curr, 1, adjList, coins, dp);
                }
            }
        } else {
            // if current value is not picked
            int ans1 = 0;
            for (int neighbor : adjList.get(curr)) {
                if (neighbor != parent) {
                    ans1 += dfs(neighbor, curr, 1, adjList, coins, dp);
                }
            }
            // if current value is picked
            int ans2 = coins[curr - 1];
            for (int neighbor : adjList.get(curr)) {
                if (neighbor != parent) {
                    ans2 += dfs(neighbor, curr, 0, adjList, coins, dp);
                }
            }
            // take max of ans1 and ans2
            maxValue = Math.max(ans1, ans2);
        }
        // take max of answer from both cases
        maxValue = Math.max(maxValue, ans);
        return dp[curr][canTake] = maxValue;
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
