import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given an undirected graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 * <p>
 * You have to find all the bridges in the graph.
 * An edge in an undirected connected graph is a bridge if removing it disconnects the graph. For a disconnected undirected graph, the definition is similar, a bridge is an edge removing which increases the number of disconnected components.
 * <p>
 * Return an two-dimensional arrays which contains all the edges that are bridges.
 * <p>
 * You can return the bridges in any order but for nodes in a bridge order them in ascending order.
 * <p>
 * For example:
 * <p>
 * If there are 3 bridges in the graph having 7 nodes, (2, 1), (5, 3), (1, 7) Then you can return any one of the following array of array integers:
 * <p>
 * [ [1, 2], [3, 5], [1, 7] ]
 * [ [1, 2], [1, 7], [3, 5] ]
 * [ [3, 5], [1, 2], [1, 7] ]
 * [ [3, 5], [1, 7], [1, 2] ]
 * [ [1, 7], [1, 2], [3, 5] ]
 * [ [1, 7], [3, 5], [1, 2] ]
 * NOTE:
 * <p>
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 105
 * <p>
 * 1 <= B[i][0], B[i][1] <= A
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 * <p>
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the two-dimensional integer array C where C[i][0] and C[i][1] represents a bridge make sure that C[i][0]<=C[i][1].
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 5
 * B = [  [1, 2]
 * [4, 1]
 * [2, 4]
 * [3, 4]
 * [5, 2]
 * [3, 1] ]
 * Input 2:
 * <p>
 * A = 5
 * B = [  [1, 2]
 * [2, 3]
 * [3, 4]
 * [4, 5] ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [ [2,5] ]
 * Output 2:
 * <p>
 * [   [1, 2]
 * [2, 3]
 * [3, 4]
 * [4, 5] ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Edge (2, 5) is the only bridge as removing it graphs breaks down into two component one
 * which contains nodes [5] and another with [1, 2, 3, 4].
 * Explanation 2:
 * <p>
 * Edge (1, 2) is a bridge as removing it graphs breaks down into two component one which contains
 * nodes [1] and another with [2, 3, 4, 5].
 * Edge (2, 3) is a bridge as removing it graphs breaks down into two component one which contains
 * nodes [1, 2] and another with [3, 4, 5].
 * Edge (3, 4) is a bridge as removing it graphs breaks down into two component one which contains
 * nodes [1, 2, 3] and another with [4, 5].
 * Edge (4, 5) is a bridge as removing it graphs breaks down into two component one which contains
 * nodes [1, 2, 3, 4] and another with [5].
 */
public class q2_BridgesInGraph {

    int time = 0;

    private static class Node {
        int u;
        int v;

        public Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        q2_BridgesInGraph t = new q2_BridgesInGraph();

        int a1 = 5;
        int[][] b1 = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {3, 1}};
        int[][] res1 = t.solve(a1, b1);
        System.out.println(Arrays.deepToString(res1));

        int a2 = 5;
        int[][] b2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] res2 = t.solve(a2, b2);
        System.out.println(Arrays.deepToString(res2));
    }

    public int[][] solve(int A, int[][] B) {
        time = 0;
        List<Node> bridges = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] vis = new boolean[A + 1];
        int[] d = new int[A + 1];
        int[] l = new int[A + 1];

        for (int i = 1; i <= A; i++) {
            if (!vis[i]) {
                dfs(i, -1, d, l, vis, list, bridges);
            }
        }

        int[][] result = new int[bridges.size()][2];
        int ind = 0;
        for (Node bridge : bridges) {
            int smaller = Math.min(bridge.u, bridge.v);
            int greater = Math.max(bridge.u, bridge.v);
            result[ind++] = new int[]{smaller, greater};
        }
        return result;
    }

    private void dfs(int curr, int parent, int[] d, int[] l, boolean[] vis, List<List<Integer>> list, List<Node> bridges) {
        d[curr] = l[curr] = ++time;
        vis[curr] = true;

        for (int neighbor : list.get(curr)) {
            if (neighbor != parent) {
                if (!vis[neighbor]) {
                    dfs(neighbor, curr, d, l, vis, list, bridges);
                    l[curr] = Math.min(l[curr], l[neighbor]);
                    if (l[neighbor] > d[curr]) {
                        bridges.add(new Node(curr, neighbor));
                    }
                } else {
                    l[curr] = Math.min(l[curr], l[neighbor]);
                }
            }
        }
    }
}
