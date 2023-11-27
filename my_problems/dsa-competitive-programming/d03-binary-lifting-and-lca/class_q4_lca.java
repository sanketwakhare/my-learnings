import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class class_q4_lca {
    public static void main(String[] args) {

        class_q4_lca t = new class_q4_lca();

        int A = 13;
        int[][] B = {{1, 2}, {1, 3}, {2, 8}, {2, 7}, {3, 4}, {3, 5}, {8, 9}, {5, 6}, {7, 11}, {7, 10}, {10, 12}, {12, 13}};

        List<List<Integer>> adjList = t.buildAdjacencyList(A, B);

        int[] intime = new int[A + 1];
        int[] outtime = new int[A + 1];
        boolean[] vis = new boolean[A + 1];
        int[] time = {0};
        t.dfs_intime_outtime(1, -1, intime, outtime, adjList, vis, time);

        int[][] up = new int[A + 1][t.getLogNBase2(A)];
        for (int[] row : up) Arrays.fill(row, -1);
        vis = new boolean[A + 1];
        t.dfs_populate_up_parent_array(1, -1, adjList, up, vis);

        System.out.println(t.lca(12, 8, up, intime, outtime));
        System.out.println(t.lca(12, 7, up, intime, outtime));
        System.out.println(t.lca(12, 4, up, intime, outtime));
        System.out.println(t.lca(11, 5, up, intime, outtime));
        System.out.println(t.lca(11, 13, up, intime, outtime));
        System.out.println(t.lca(11, 9, up, intime, outtime));
        System.out.println(t.lca(11, 20, up, intime, outtime));
    }

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

    // TC: O(1)
    public boolean isAncestor(int x, int y, int[] intime, int[] outtime) {
        return x >= 0 && x < intime.length && y >= 0 && y < intime.length && intime[x] <= intime[y] && outtime[x] >= outtime[y];
    }

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
