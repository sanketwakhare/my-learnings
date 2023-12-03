import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a tree with N nodes, find diameter of the tree. The diameter need not have to be passing from the root element
 */
public class class_q2_find_diameter_of_tree {
    public static void main(String[] args) {
        class_q2_find_diameter_of_tree t = new class_q2_find_diameter_of_tree();
        {
            int A = 11;
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {5, 9}, {5, 10}, {7, 11}};
            int diameter = t.solve(A, B);
            System.out.println(diameter); // 6
        }
        {
            int A = 7;
            int[][] B = {{1, 2}, {2, 3}, {2, 4}, {3, 7}, {4, 5}, {4, 6}};
            int diameter = t.solve(A, B);
            System.out.println(diameter); // 4
        }
    }

    public int solve(int A, int[][] B) {
        List<List<Integer>> adjList = buildAdjacencyList(A, B);
        // populate height array. considering height of edges
        // height[i] = max length path starting from root to ith element in its subtree
        //           = 1 + Max(height[child])
        int[] height = new int[A + 1];
        Arrays.fill(height, -1);
        dfs_height(1, -1, height, adjList);

        // populate diameter considering height of the edges
        // g[i] = max length path within subtree of ith node if we are going to change the direction at ith node
        //      = 2 + sum of maximum of 2 height[child]
        //      = 2 + max1 height of child + max2 height of child
        int[] g = new int[A + 1];
        Arrays.fill(g, -1);
        dfs_diameter(1, -1, height, g, adjList);

        // find maximum value from g array which will diameter of the tree
        int diameter = 0;
        for (int e : g) {
            diameter = Math.max(diameter, e);
        }
        return diameter;
    }

    // TC: O(N + E)
    // SC: O(N + E) for adjacency list + N for g array + logN stack space
    public void dfs_diameter(int curr, int parent, int[] height, int[] g, List<List<Integer>> adjList) {
        if (g[curr] != -1) return;
        int max1 = -1;
        int max2 = -1;
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                // find max 2 heights of the curr's any 2 children
                int tmp = height[neighbor];
                if (tmp > max1) {
                    max2 = max1;
                    max1 = tmp;
                } else if (tmp > max2) {
                    max2 = tmp;
                }
                dfs_diameter(neighbor, curr, height, g, adjList);
            }
        }
        // update g array with diameter value
        g[curr] = 2 + max1 + max2;
    }

    // TC: O(N + E)
    // SC: O(N + E) for adjacency list + N for height + logN stack space
    public int dfs_height(int curr, int parent, int[] height, List<List<Integer>> adjList) {
        if (height[curr] != -1) return height[curr];
        int maxHeightOutOfchildren = -1;
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                int thisNeighborHeight = dfs_height(neighbor, curr, height, adjList);
                maxHeightOutOfchildren = Math.max(maxHeightOutOfchildren, thisNeighborHeight);
            }
        }
        return height[curr] = 1 + maxHeightOutOfchildren;
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
