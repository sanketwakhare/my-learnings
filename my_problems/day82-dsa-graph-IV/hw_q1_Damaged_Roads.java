import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/* Damaged Roads */
public class hw_q1_Damaged_Roads {

    // Node
    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return "[i=" + i + ", j=" + j + "]";
        }
    }

    // Edge
    class Edge {
        Node u;
        Node v;
        int weight;

        public Edge(Node u, Node v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public String toString() {
            return "[u=" + u + ", v=" + v + ", weight=" + weight + "]";
        }

    }

    class WeightComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.weight < o2.weight)
                return -1;
            if (o1.weight > o2.weight)
                return 1;
            return 0;
        }

    }

    public int solve(int[] A, int[] B) {
        int minCost = 0;
        int n = A.length + 1;
        int m = B.length + 1;

        // build adjacency list
        Map<String, Node> nodeMap = new HashMap<String, Node>();
        Map<Node, List<Edge>> map = new HashMap<Node, List<Edge>>();
        Map<Node, Boolean> visited = new HashMap<Node, Boolean>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node node = new Node(i, j);
                nodeMap.put(i + "+" + j, node);
                map.put(node, new ArrayList<Edge>());
                visited.put(node, false);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node u = nodeMap.get(i + "+" + j);
                Node v = null;
                if (i < n - 1) {
                    v = nodeMap.get((i + 1) + "+" + j);
                    map.get(u).add(new Edge(u, v, A[i]));
                    map.get(v).add(new Edge(v, u, A[i]));
                }
                Node w = null;
                if (j < m - 1) {
                    w = nodeMap.get(i + "+" + (j + 1));
                    map.get(u).add(new Edge(u, w, B[j]));
                    map.get(w).add(new Edge(w, u, B[j]));
                }
            }
        }

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(new WeightComparator());

        // insert first node into Priority List
        Node firstNode = nodeMap.get("0+0");
        queue.add(new Edge(firstNode, firstNode, 0));

        while (!queue.isEmpty()) {
            Edge parentEdge = queue.poll();
            Node v = parentEdge.v;

            if (!visited.get(v)) {
                visited.put(v, true);
                minCost += parentEdge.weight;
                System.out.println("edge:" + parentEdge);

                // traverse all neighbors of node v
                List<Edge> neighbors = map.get(v);
                for (Edge neighbor : neighbors) {
                    Node sourceNode = neighbor.u;
                    Node targetNode = neighbor.v;
                    if (!visited.get(targetNode) || !visited.get(sourceNode)) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {

        hw_q1_Damaged_Roads t1 = new hw_q1_Damaged_Roads();
        int[] A, B;

        // test case 1
        A = new int[] { 1, 1, 1 };
        B = new int[] { 1, 1, 2 };
        System.out.println(t1.solve(A, B)); // 16

        // test case 2
        A = new int[] { 1, 2, 3 };
        B = new int[] { 4, 5, 6 };
        System.out.println(t1.solve(A, B)); // 39

    }
}
