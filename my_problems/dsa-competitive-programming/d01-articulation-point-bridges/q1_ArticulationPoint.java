import java.util.*;

/**
 Q1. Articulation Points
 Problem Description
 Given an undirected graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 <p>
 You have to find all the Articulation Points in the graph.
 <p>
 A vertex in an undirected connected graph is an articulation point iff removing it (and edges through it) disconnects the graph.
 <p>
 For a disconnected undirected graph, an articulation point is a vertex removing which increases number of connected components.
 <p>
 Return an one-dimensional array which contains all the Articulation Points .
 <p>
 You can return the Articulation points in any order.
 <p>
 NOTE:
 <p>
 There are no self-loops in the graph.
 There are no multiple edges between two nodes.
 The graph may or may not be connected.
 Nodes are numbered from 1 to A.
 Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 <p>
 <p>
 Problem Constraints
 1 <= A, M <= 3×105
 <p>
 1 <= B[i][0], B[i][1] <= A
 <p>
 <p>
 <p>
 Input Format
 The first argument given is an integer A representing the number of nodes in the graph.
 <p>
 The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 <p>
 <p>
 <p>
 Output Format
 Return an one-dimensional array which contains all the Articulation Points .
 <p>
 <p>
 <p>
 Example Input
 Input 1:
 <p>
 A = 5
 B = [  [1, 2]
 [4, 1]
 [2, 4]
 [3, 4]
 [5, 2]
 [3, 1] ]
 Input 2:
 <p>
 A = 5
 B = [  [1, 2]
 [2, 3]
 [3, 4]
 [4, 5] ]
 <p>
 <p>
 Example Output
 Output 1:
 <p>
 [2]
 Output 2:
 <p>
 [2, 3, 4]
 <p>
 <p>
 Example Explanation:

 Explanation 1:
 <p>
 Node 2 is the only articulation point in the graph as removing it graphs breaks down into two
 component one which contains nodes [5] and another with [1, 3, 4].
 Explanation 2:
 <p>
 <p>
 Node 2 is an articulation point in the graph as removing it graphs breaks down into two component,
 one which contains nodes [1] and another with [3, 4, 5].
 Node 3 is an articulation point in the graph as removing it graphs breaks down into two component,
 one which contains nodes [1, 2] and another with [4, 5].
 Node 4 is an articulation point in the graph as removing it graphs breaks down into two component,
 one which contains nodes [1, 2, 3] and another with [5].
 */
public class q1_ArticulationPoint {

    int time = 0;

    public static void main(String[] args) {
        q1_ArticulationPoint q1ArticulationPoint = new q1_ArticulationPoint();

        int[][] a1 = new int[][]{{1, 2}, {2, 3}, {3, 1}, {2, 4}, {2, 5}, {2, 7}, {4, 6}, {5, 6}};
        int[] res1 = q1ArticulationPoint.solve(7, a1);
        System.out.println(Arrays.toString(res1)); // [2]

        int[][] a2 = new int[][]{{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {3, 1}};
        int[] res2 = q1ArticulationPoint.solve(5, a2);
        System.out.println(Arrays.toString(res2)); // [2]

        int[][] a3 = new int[][]{{4, 39}, {12, 93}, {49, 70}, {17, 66}, {80, 87}, {45, 54}, {70, 77}, {45, 65}, {37, 81}, {87, 89}, {63, 91}, {13, 15}, {77, 89}, {15, 23}, {23, 32}, {8, 41}, {44, 50}, {15, 84}, {20, 23}, {12, 24}, {32, 84}, {12, 21}, {9, 68}, {29, 78}, {33, 90}, {37, 78}, {28, 58}, {21, 63}, {32, 55}, {4, 31}, {7, 64}, {23, 53}, {40, 78}, {21, 44}, {10, 67}, {9, 94}, {17, 18}, {82, 85}, {5, 86}, {17, 81}, {28, 65}, {53, 54}, {67, 71}, {17, 42}, {30, 54}, {12, 16}, {26, 29}, {76, 94}, {38, 91}, {19, 40}, {41, 83}, {23, 81}, {48, 79}, {50, 80}, {40, 93}, {57, 83}, {71, 78}, {20, 58}, {76, 84}, {47, 85}, {44, 61}, {55, 89}, {58, 87}, {11, 83}, {23, 71}, {12, 63}, {45, 69}, {10, 94}, {9, 93}, {8, 55}, {26, 35}, {69, 72}, {66, 82}, {2, 92}, {30, 58}, {14, 23}, {53, 78}, {29, 59}, {28, 90}, {24, 50}, {14, 59}, {8, 65}, {24, 38}, {11, 89}, {36, 55}, {3, 46}, {78, 81}, {7, 74}, {4, 40}, {15, 89}, {70, 75}, {31, 68}, {5, 40}, {26, 77}, {15, 56}, {47, 77}, {18, 47}, {7, 65}, {17, 62}, {31, 60}, {60, 67}, {19, 86}, {23, 38}, {18, 65}, {6, 88}, {54, 86}, {17, 68}, {72, 92}, {17, 40}, {31, 44}, {23, 56}, {34, 83}, {26, 91}, {31, 72}, {36, 52}, {66, 92}, {51, 58}, {24, 72}, {26, 28}, {25, 88}, {17, 48}, {14, 40}, {13, 85}, {29, 38}, {37, 91}, {3, 20}, {20, 85}, {50, 64}, {3, 56}, {35, 40}, {15, 20}, {13, 24}, {62, 65}, {8, 86}, {1, 82}, {2, 27}, {53, 94}, {38, 65}, {19, 94}, {53, 84}, {69, 80}, {8, 15}, {12, 92}, {37, 51}, {34, 91}, {54, 61}, {48, 90}, {10, 32}, {39, 48}, {5, 66}, {12, 94}, {29, 51}, {7, 82}, {40, 77}, {80, 91}, {64, 71}};
        int[] res3 = q1ArticulationPoint.solve(94, a3);
        System.out.println(Arrays.toString(res3)); // expected output [2, 3, 7, 12, 17, 36, 48, 55, 70, 77, 82, 83, 88, 90, 92]
    }

    public void dfs(int curr, int parent, int[] disc, int[] low, Set<Integer> artPoints, List<List<Integer>> adj, boolean[] vis) {
        int children = 0;
        disc[curr] = low[curr] = ++time;
        vis[curr] = true;

        for (int neighbor : adj.get(curr)) {
            if (!vis[neighbor]) {
                children++;
                dfs(neighbor, curr, disc, low, artPoints, adj, vis);
                low[curr] = Math.min(low[curr], low[neighbor]);

                if (parent != -1 && low[neighbor] >= disc[curr]) {
                    artPoints.add(curr);
                }
            } else {
                low[curr] = Math.min(low[curr], disc[neighbor]);
            }
        }

        if (parent == -1 && children > 1) {
            artPoints.add(curr);
        }
    }

    public int[] solve(int A, int[][] B) {
        time = 0;
        Set<Integer> artPoints = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] disc = new int[A + 1];
        int[] low = new int[A + 1];
        boolean[] vis = new boolean[A + 1];

        for (int i = 1; i <= A; i++) {
            if (!vis[i]) {
                dfs(i, -1, disc, low, artPoints, adj, vis);
            }
        }

        int[] output = artPoints.stream().mapToInt(i -> i).toArray();
        Arrays.sort(output);
        return output;
    }
}
