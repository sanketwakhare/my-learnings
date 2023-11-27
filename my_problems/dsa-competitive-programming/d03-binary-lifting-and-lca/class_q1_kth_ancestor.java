import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Approach 1: Maintain parent array
public class class_q1_kth_ancestor {

    public static void main(String[] args) {
        class_q1_kth_ancestor t = new class_q1_kth_ancestor();
        int a1 = 13;
        int[][] b1 = {{1, 2}, {1, 3}, {2, 8}, {2, 7}, {3, 4}, {3, 5}, {8, 9}, {5, 6}, {7, 11}, {7, 10}, {10, 12}, {12, 13}};
        int[] parent1 = t.buildParentArray(a1, b1);
        int res1 = t.findKthAncestor(parent1, 2, 12);
        System.out.println(res1);
        res1 = t.findKthAncestor(parent1, 2, 5);
        System.out.println(res1);
    }

    // TC: O(N + M)
    // SC: O(N + M)
    public int[] buildParentArray(int A, int[][] B) {
        // populate parent array
        int[] parent = new int[A + 1];
        boolean[] vis = new boolean[A + 1];
        Arrays.fill(vis, false);
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
        dfs(1, -1, adjList, parent, vis);
        return parent;
    }

    public void dfs(int curr, int par, List<List<Integer>> adjList, int[] parent, boolean[] vis) {
        parent[curr] = par;
        vis[curr] = true;
        for (int neighbor : adjList.get(curr)) {
            if (!vis[neighbor]) {
                dfs(neighbor, curr, adjList, parent, vis);
            }
        }
    }

    // TC: O(k)
    public int findKthAncestor(int[] parent, int k, int x) {
        // find kth ancestor of x
        while (k-- > 0 && x > 0) {
            x = parent[x];
        }
        return x;
    }

}
