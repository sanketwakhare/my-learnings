import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class class_q2_intime_outtime {
    public static void main(String[] args) {
        class_q2_intime_outtime t = new class_q2_intime_outtime();

        int A = 13;
        int[][] B = {{1, 2}, {1, 3}, {2, 8}, {2, 7}, {3, 4}, {3, 5}, {8, 9}, {5, 6}, {7, 11}, {7, 10}, {10, 12}, {12, 13}};
        List<List<Integer>> adjList = t.buildAdjacencyList(A, B);
        int[] intime = new int[A + 1];
        int[] outtime = new int[A + 1];
        boolean[] vis = new boolean[A + 1];
        int[] time = {0};
        t.dfs_intime_outtime(1, -1, intime, outtime, adjList, vis, time);
        System.out.println(Arrays.toString(intime));
        System.out.println(Arrays.toString(outtime));
    }

    // TC: O(N + M)
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
