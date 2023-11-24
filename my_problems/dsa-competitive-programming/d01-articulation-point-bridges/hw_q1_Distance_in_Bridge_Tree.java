/* Distance in Bridge Tree

Problem Description
A country named Scaler has A citied labelled from 1 to A connected by M bi-directional roads given in a form of 2D-matrix B of size M * 2 where (B[i][0], B[i][1]) denotes two cities connected by an road.

You have to answer Q queries, in each query you are given two integers (u, v), you have to find how many edges are there which you encounter in every path you take to go from city u to city v. If there is no such edge, return "-1".(without quotes)

NOTE:

The given graph is connected without any self-loops and multiple edges.
The path between (u, v) is sequence of vertices traversed to go from city u to city v where each city and road must be visited atmost once.

Problem Constraints
1 <= N <= 10^4
0 <= M <= 10^5
1 <= u,v <= N
1 <= Q <= 10^4

Input Format
First argument is an integer A denoting number of cities.

Second argument is an two-dimensional matrix B of size M * 2 where (B[i][0], B[i][1]) denotes two cities connected by an bi-directional road.

Third argument is an two-dimensional matrix C of size Q denoting the queries where (C[i][0], C[i][1]) denotes u and v for ith query.

Output Format
Return a one-dimensional array of size Q denoting answer for each query.

Example Input
Input 1:

 A = 4
 B = [  [1, 2]
        [1, 3]
        [2, 4]
     ]
 C = [  [1, 2]
        [1, 4]
        [3, 4]
        [4, 4]
     ]
Input 2:

 A = 4
 B = [  [1, 2]
        [2, 3]
        [1, 3]
        [2, 4]
     ]
 C = [  [1, 4]
        [2, 4]
     ]


Example Output
Output 1:

 [1, 2, 3, -1]
Output 2:

 [1, 1]


Example Explanation
Explanation 1:

 Query 1: Possible Paths between city 1 and city 2: (1 -> 2) so only one edge (1, 2) is been traversed each
    time you go from city 1 to city 2 so answer for this query will be 1.
Query 2: Possible Paths between city 1 and city 4: (1 -> 2 -> 4) so edges [ (1, 2), (2, 4) ] is been traversed
    each time you go from city 1 to city 4 so answer for this query will be 2.
Query 3: Possible Paths between city 3 and city 4: (3 -> 1 -> 2 -> 4) so edges [ (3,1), (1, 2) , (2, 4) ]
    is been traversed each time you go from city 3 to city 4 so answer for this query will be 3.
 Query 4: There is no path between city 4 and city 4 as no edges is been traversed so answer for this query will be -1.
Explanation 2:

Query 1: Possible paths between city 1 and city 4 are :   (1 -> 2 -> 4)
                                                           (1 -> 3 -> 2 -> 4)
    So only one edge (2, 4) is been traversed in every path you go from city 1 to city 4 so answer for this query
    will be 1.
Query 2: Possible path between city 2 and city 4 are:     (2 -> 4)
    So only one edge (2, 4) is been traversed in every time you go from city 2 to city 4 so answer for this query
    will be 1.
* */

import java.util.*;
import java.util.stream.Collectors;

// Approach:
// find bridges in the graph
// mark bridges with weight 1 and non bridges as weight 0
// apply BFS from u -> v and find total bridges between path u -> v
public class hw_q1_Distance_in_Bridge_Tree {

    public static void main(String[] args) {
        hw_q1_Distance_in_Bridge_Tree t = new hw_q1_Distance_in_Bridge_Tree();

        int a1 = 4;
        int[][] b1 = new int[][]{{1, 2}, {1, 3}, {2, 4}};
        int[][] c1 = new int[][]{{1, 2}, {1, 4}, {3, 4}, {4, 4}};
        int[] res1 = t.solve(a1, b1, c1);
        System.out.println(Arrays.toString(res1));

        int a2 = 4;
        int[][] b2 = new int[][]{{1, 2}, {2, 3}, {1, 3}, {2, 4}};
        int[][] c2 = new int[][]{{1, 4}, {2, 4}};
        int[] res2 = t.solve(a2, b2, c2);
        System.out.println(Arrays.toString(res2));

        int a3 = 1;
        int[][] b3 = new int[][]{};
        int[][] c3 = new int[][]{{1, 1}};
        int[] res3 = t.solve(a3, b3, c3);
        System.out.println(Arrays.toString(res3));
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

    public int[] solve(int A, int[][] B, int[][] C) {
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

        int[] result = new int[C.length];
        for (int i = 0; i < C.length; i++) {
            int src = C[i][0];
            int dst = C[i][1];
            boolean[] visited = new boolean[A + 1];
            int[] count = {0};
            dfs_find_bridges_in_a_path(src, dst, 0, visited, adjMap, count);
            result[i] = count[0] == 0 ? -1 : count[0];
        }
        return result;
    }

    private boolean dfs_find_bridges_in_a_path(int src, int tgt, int currDepth, boolean[] visited, Map<Integer, List<WeightedNode>> adjMap,
                                               int[] count) {
        visited[src] = true;
        count[0] = currDepth;

        if (src == tgt) return true;
        for (WeightedNode neighbor : adjMap.get(src)) {
            if (!visited[neighbor.target]) {
                if (dfs_find_bridges_in_a_path(neighbor.target, tgt, neighbor.weight == 1 ? currDepth + 1 : currDepth,
                        visited, adjMap, count)) return true;
            }
        }
        return false;
    }

    private void dfs(int curr, int parent, int[] d, int[] l, boolean[] vis, Map<Integer, List<WeightedNode>> adjMap, List<Node> bridges) {
        d[curr] = l[curr] = ++time;
        vis[curr] = true;

        List<WeightedNode> list = adjMap.get(curr);
        if (!Objects.isNull(list)) {
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
}
