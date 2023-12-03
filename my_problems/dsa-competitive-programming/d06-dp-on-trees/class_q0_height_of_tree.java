import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class class_q0_height_of_tree {

    public static void main(String[] args) {
        class_q0_height_of_tree t = new class_q0_height_of_tree();
        {
            int A = 4;
            int[][] B = {{1, 2}, {2, 3}, {2, 4}};
            int[] result = t.solve(A, B);
            System.out.println(Arrays.toString(result)); // [0, 3, 2, 1, 1]
        }
        {
            int A = 8;
            int[][] B = {{1, 2}, {2, 3}, {3, 4}, {2, 5}, {4, 6}, {3, 7}, {1, 8}};
            int[] result = t.solve(A, B);
            System.out.println(Arrays.toString(result)); // [0, 5, 4, 3, 2, 1, 1, 1, 1]
        }
    }

    public int[] solve(int A, int[][] B) {
        List<List<Integer>> adjList = buildAdjacencyList(A, B);
        int[] height = new int[A + 1];
        dfs_height(1, -1, height, adjList);
        return height;
    }

    public int dfs_height(int curr, int parent, int[] height, List<List<Integer>> adjList) {
        int currHeight = 0;
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                currHeight = Math.max(currHeight, dfs_height(neighbor, curr, height, adjList));
            }
        }
        return height[curr] = 1 + currHeight;
    }

    // build adjacency list
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
