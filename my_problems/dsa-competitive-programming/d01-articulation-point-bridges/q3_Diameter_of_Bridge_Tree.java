import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Diameter of Bridge Tree
 * <p>
 * Problem Description
 * <p>
 * Given a undirected graph with A nodes labelled from 1 to A containing M edges given in a form of 2D-matrix B of size M * 2 where there is a edge between node B[i][0] and B[i][1]
 * <p>
 * For the given graph, the edges, which on deletion do not disconnect the graph are compressed into a node and the edges which on deletion disconnect the graph form an edge between these nodes.
 * <p>
 * The resultant structure will be a tree of course!
 * <p>
 * You have to find and return the diameter of this resultant tree.
 * <p>
 * NOTE:
 * <p>
 * Input graph is connected.
 * No multiple edges and self loops are present.
 * Diameter of a tree is defined as the number of edges on the longest path in the tree.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 3*105
 * <p>
 * A-1 <= M <= 3*105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is an integer A representing the number of nodes in the graph.
 * <p>
 * The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a single integer denoting the diameter of the resultant tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 4
 * B = [ [1, 2]
 * [1, 3]
 * [2, 4]
 * ]
 * Input 2:
 * <p>
 * A = 6
 * B = [ [1, 2]
 * [2, 3]
 * [3, 1]
 * [3, 4]
 * [4, 5]
 * [5, 6]
 * [6, 4]
 * ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Each edge has to be there in the resulting tree as removing any of them disconnects the graph.
 * So the longest path is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so we will return 3
 * Explanation 2:
 * <p>
 * Initially the graph looks like :            1         5
 * /   \     /  \
 * 2 --- 3---4----6
 * Edge (1, 2), (1, 3), (2, 3) (4, 5), (4, 6), (5,6) are of no use as removing them doesn't disconnect the graph.
 * But Edge (3, 4) has to be there in the resulting tree as removing this edge disconnects the graph.
 * So the resulting tree looks like:
 * A --- B
 * Where A is a compressed node formed by nodes (1, 2, 3) and B is compressed node formed by nodes (4, 5, 6)
 * So the answer will be the diameter of this tree which is clearly visible as 1.
 */
public class q3_Diameter_of_Bridge_Tree {


    public static void main(String[] args) {
        q3_Diameter_of_Bridge_Tree t = new q3_Diameter_of_Bridge_Tree();

        int a1 = 4;
        int[][] b1 = {{1, 2}, {1, 3}, {2, 4}};
        int res1 = t.solve(a1, b1);
        System.out.println(res1);

        int a2 = 6;
        int[][] b2 = {{1, 2}, {2, 3}, {3, 1}, {3, 4}, {4, 5}, {5, 6}, {6, 4}};
        int res2 = t.solve(a2, b2);
        System.out.println(res2);
    }

    int time = 0;

    private static class Node {
        int u;
        int v;

        public Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private static class WeightedNode {
        int target;
        int weight;

        public WeightedNode(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public int solve(int A, int[][] B) {
        time = 0;
        List<Node> bridges = new ArrayList<>();
        Map<Integer, List<WeightedNode>> adjMap = new HashMap<>();
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            List<WeightedNode> targets;

            if (adjMap.containsKey(u)) {
                targets = adjMap.get(u);
            } else {
                targets = new ArrayList<>();
            }
            targets.add(new WeightedNode(v, 0));
            adjMap.put(u, targets);

            if (adjMap.containsKey(v)) {
                targets = adjMap.get(v);
            } else {
                targets = new ArrayList<>();
            }
            targets.add(new WeightedNode(u, 0));
            adjMap.put(v, targets);
        }

        boolean[] vis = new boolean[A + 1];
        int[] d = new int[A + 1];
        int[] l = new int[A + 1];

        for (int i = 1; i <= A; i++) {
            if (!vis[i]) {
                dfs(i, -1, d, l, vis, adjMap, bridges);
            }
        }

        for (Node bridge : bridges) {
            List<WeightedNode> srcTargets = adjMap.get(bridge.u);
            List<WeightedNode> targets = srcTargets.stream().filter(t -> t.target == bridge.v).collect(Collectors.toList());
            for (WeightedNode nd : targets) {
                nd.weight = 1;
            }

            List<WeightedNode> dstTargets = adjMap.get(bridge.v);
            List<WeightedNode> dTargets = dstTargets.stream().filter(t -> t.target == bridge.u).collect(Collectors.toList());
            for (WeightedNode nd : dTargets) {
                nd.weight = 1;
            }
        }

        // perform dfs
        boolean[] visited = new boolean[A + 1];
        int[] depth = new int[A + 1];

        // 1st dfs to find farthest node
        dfs_find_diameter(1, 0, visited, adjMap, depth);
        int maxDepth = 0;
        int maxSource = 1;
        for (int i = 0; i < depth.length; i++) {
            if (depth[i] > maxDepth) {
                maxDepth = depth[i];
                maxSource = i;
            }
        }

        // apply dfs again from source which is one of the farthest
        depth = new int[A + 1];
        visited = new boolean[A + 1];
        dfs_find_diameter(maxSource, 0, visited, adjMap, depth);

        maxDepth = 0;
        for (int currDepth : depth) {
            if (currDepth > maxDepth) {
                maxDepth = currDepth;
            }
        }
        return maxDepth;
    }

    private void dfs_find_diameter(int curr, int currDepth, boolean[] visited, Map<Integer, List<WeightedNode>> adjMap,
                                   int[] depth) {
        visited[curr] = true;
        depth[curr] = currDepth;

        for (WeightedNode neighbor : adjMap.get(curr)) {
            if (!visited[neighbor.target]) {
                dfs_find_diameter(neighbor.target, neighbor.weight == 1 ? currDepth + 1 : currDepth,
                        visited, adjMap, depth);
            }
        }
    }

    private void dfs(int curr, int parent, int[] d, int[] l, boolean[] vis, Map<Integer, List<WeightedNode>> adjMap, List<Node> bridges) {
        d[curr] = l[curr] = ++time;
        vis[curr] = true;

        List<WeightedNode> list = adjMap.get(curr);
        for (WeightedNode neighbor : list) {
            if (neighbor.target != parent) {
                if (!vis[neighbor.target]) {
                    dfs(neighbor.target, curr, d, l, vis, adjMap, bridges);
                    l[curr] = Math.min(l[curr], l[neighbor.target]);
                    if (l[neighbor.target] > d[curr]) {
                        bridges.add(new Node(curr, neighbor.target));
                    }
                } else {
                    l[curr] = Math.min(l[curr], l[neighbor.target]);
                }
            }
        }
    }
}
