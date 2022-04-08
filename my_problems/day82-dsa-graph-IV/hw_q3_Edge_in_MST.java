import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* Edge in MST */

/* Problem Description

Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].

For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.

Return an one-dimensional binary array of size M denoting answer for each edge.

NOTE:

The graph may be disconnected in that case consider mst for each component.
No self-loops and no multiple edges present.
Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].


Problem Constraints

1 <= A, M <= 3*10^5

1 <= B[i][0], B[i][1] <= A

1 <= B[i][1] <= 10^3



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].



Output Format

Return an one-dimensional binary array of size M denoting answer for each edge.



Example Input

Input 1:

 A = 3
 B = [ [1, 2, 2]
       [1, 3, 2]
       [2, 3, 3]
     ]


Example Output

Output 1:

 [1, 1, 0]


Example Explanation

Explanation 1:

 Edge (1, 2) with weight 2 is included in the MST           1
                                                          /   \
                                                         2     3
 Edge (1, 3) with weight 2 is included in the same MST mentioned above.
 Edge (2,3) with weight 3 cannot be included in any of the mst possible.
 So we will return [1, 1, 0] 
 */
public class hw_q3_Edge_in_MST {

    class Edge {
        int u;
        int v;
        int weight;
        // store index along with nodes and weight
        int index;

        public Edge(int _u, int _v, int _weight, int _index) {
            this.u = _u;
            this.v = _v;
            this.weight = _weight;
            this.index = _index;
        }
    }

    class WeightComparator implements Comparator<Edge> {

        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public int[] solve(int A, int[][] B) {

        int[] parent = new int[A + 1];
        int[] minSpanningTree = new int[B.length];

        // build min Heap - contains all edges with weight and index
        Map<Integer, List<Edge>> map = new TreeMap<Integer, List<Edge>>();
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int weight = B[i][2];
            List<Edge> list;
            if (!map.containsKey(weight)) {
                list = new ArrayList<Edge>();
            } else {
                list = map.get(weight);
            }
            list.add(new Edge(u, v, weight, i));
            map.put(weight, list);
        }

        // initialize parent array.
        // Initially all nodes are independent connected components
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (Map.Entry<Integer, List<Edge>> entry : map.entrySet()) {

            List<Edge> equalWeightEdges = entry.getValue();
            for (Edge edge : equalWeightEdges) {
                if (checkUnion(edge, parent)) {
                    // edge can be part of minimum spanning tree
                    minSpanningTree[edge.index] = 1;
                }
            }

            for (Edge edge : equalWeightEdges) {
                union(edge, parent);
            }
        }
        return minSpanningTree;
    }

    // check if given edge can be part of min spanning tree
    private boolean checkUnion(Edge edge, int[] parent) {
        int x = edge.u;
        int y = edge.v;
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);
        if (parent_x != parent_y) {
            // if parent of x and y are different
            return true;
        }
        return false;
    }

    // if edge can be part of minimum spanning tree, merge connect components of x
    // and y
    private void union(Edge edge, int[] parent) {
        int x = edge.u;
        int y = edge.v;
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);
        if (parent_x != parent_y) {
            // if parent of x and y are different, combine x and y into same connected
            // component
            parent[parent_x] = parent_y;
        }
    }

    // find top most parent
    private int findParent(int x, int[] parent) {

        if (parent[x] == x) {
            return x;
        }
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }
}
