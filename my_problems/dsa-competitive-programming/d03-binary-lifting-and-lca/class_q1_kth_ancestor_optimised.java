import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class class_q1_kth_ancestor_optimised {
    public static void main(String[] args) {
        class_q1_kth_ancestor_optimised t = new class_q1_kth_ancestor_optimised();

        int a1 = 13;
        int[][] b1 = {{1, 2}, {1, 3}, {2, 8}, {2, 7}, {3, 4}, {3, 5}, {8, 9}, {5, 6}, {7, 11}, {7, 10}, {10, 12}, {12, 13}};
        List<List<Integer>> adjList = t.buildAdjacencyList(a1, b1);
        int[][] up = new int[a1 + 1][t.getLogNBase2(a1)];
        for (int[] row : up) Arrays.fill(row, -1);
        boolean[] vis = new boolean[a1 + 1];
        t.dfs_populate_up_parent_array(1, -1, adjList, up, vis);

        System.out.println(Arrays.deepToString(up));
        int res1 = t.kthAncestor(12, 3, up, a1);
        System.out.println(res1);
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

    public int getLogNBase2(int x) {
        return (int) Math.ceil(Math.log(x) / Math.log(2));
    }
}
