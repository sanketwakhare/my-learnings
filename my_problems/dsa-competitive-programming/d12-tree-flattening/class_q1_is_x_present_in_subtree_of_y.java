import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a tree and Q queries.
Each query will have [x, y], find x is present in subtree of y or not
Return 1 if present else return 0.

Return array of result for all teh queries where result[i] represents answer for ith query.
 */
public class class_q1_is_x_present_in_subtree_of_y {
    public static void main(String[] args) {
        class_q1_is_x_present_in_subtree_of_y t = new class_q1_is_x_present_in_subtree_of_y();
        {
            int A = 6;
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}};
            int[][] Q = {{4, 2}, {3, 1}, {5, 1}, {5, 3}, {6, 2}, {6, 1}, {4, 5}, {5, 2}};
            /*
                      1
                    /   \
                   2     3
                 /  \   /
                4    5 6
             */
            System.out.println(Arrays.toString(t.solve(A, B, Q))); // [1, 1, 1, 0, 0, 1, 0, 1]
        }
    }

    public int[] solve(int A, int[][] B, int[][] Q) {
        // build adjacency list
        List<List<Integer>> adjList = buildAdjList(A, B);
        // populate start and end time arrays
        int[] startTime = new int[A + 1];
        int[] endTime = new int[A + 1];
        dfs(1, -1, adjList, startTime, endTime, new int[]{0});
        // get result for each query
        int[] result = new int[Q.length];
        for (int i = 0; i < Q.length; i++) {
            int x = Q[i][0];
            int y = Q[i][1];
            boolean isYAncestorOfX = isAncestor(y, x, startTime, endTime);
            result[i] = isYAncestorOfX ? 1 : 0;
        }
        return result;
    }

    private boolean isAncestor(int y, int x, int[] startTime, int[] endTime) {
        return startTime[y] <= startTime[x] && endTime[y] >= endTime[x];
    }

    private void dfs(int curr, int parent, List<List<Integer>> adjList, int[] startTime, int[] endTime, int[] time) {
        startTime[curr] = time[0]++;
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                dfs(neighbor, curr, adjList, startTime, endTime, time);
            }
        }
        endTime[curr] = time[0]++;
    }


    List<List<Integer>> buildAdjList(int A, int[][] B) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
