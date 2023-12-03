import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a tree with N nodes, find no of different subtrees
 */
public class class_q3_no_of_different_subtrees {
    public static void main(String[] args) {
        class_q3_no_of_different_subtrees t = new class_q3_no_of_different_subtrees();
        {
            int A = 3;
            int[][] B = {{1, 2}, {1, 3}};
            int result = t.solve(A, B);
            System.out.println(result); // 6
        }
        {
            int A = 4;
            int[][] B = {{1, 2}, {1, 3}, {1, 4}};
            int result = t.solve(A, B);
            System.out.println(result); // 11
        }
        {
            int A = 7;
            int[][] B = {{1, 2}, {1, 4}, {1, 5}, {2, 3}, {5, 6}, {5, 7}};
            int result = t.solve(A, B);
            System.out.println(result); // 40
        }
    }

    public int solve(int A, int[][] B) {
        List<List<Integer>> adjList = buildAdjacencyList(A, B);

        // f[i] = no of subtrees in subtree of (i) including node i
        // f[i] = multiplication of  [1 + f[child]] for all children of node i
        // e.g. if node 1 has 2 children 2 and 3
        // f[1] = (1 + f[2]) * (1 + f[3])
        // f[i] = 1 when there are no children for node i

        // g[i] = no of subtrees in subtree of (i) excluding node i
        // g[i] = summation of (f[child] + g[child]) for every child of i
        // g[i] = 0 when there are no children for node i

        int[] f = new int[A + 1];
        Arrays.fill(f, -1);
        dfs_populate_f(1, -1, adjList, f);

        int[] g = new int[A + 1];
        Arrays.fill(g, -1);
        dfs_populate_g(1, -1, adjList, f, g);

        // answer = f[root] + g[root]
        return f[1] + g[1];
    }

    // TC: O(N + E)
    // SC: O(n for g array + logN for stack space) = O(n)
    public int dfs_populate_g(int curr, int parent, List<List<Integer>> adjList, int[] f, int[] g) {
        if (g[curr] != -1) return g[curr];
        int value = 0;
        boolean isLeaf = true;
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                if (isLeaf) isLeaf = false;
                int currValue = f[neighbor] + dfs_populate_g(neighbor, curr, adjList, f, g);
                value = value + currValue;
            }
        }
        return g[curr] = isLeaf ? 0 : value;
    }

    // TC: O(N + E)
    // SC: O(n for f array + logN for stack space) = O(n)
    public int dfs_populate_f(int curr, int parent, List<List<Integer>> adjList, int[] f) {
        if (f[curr] != -1) return f[curr];
        int value = 1;
        boolean isLeaf = true;
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                if (isLeaf) isLeaf = false;
                int currValue = 1 + dfs_populate_f(neighbor, curr, adjList, f);
                value = value * currValue;
            }
        }
        return f[curr] = isLeaf ? 1 : value;
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
