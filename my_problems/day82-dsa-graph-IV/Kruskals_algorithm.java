import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskals_algorithm {

    // custom object type to store the edge and weight information
    static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int weight;

        public Pair(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.weight + ",");
            sb.append(this.u + "-" + this.v);
            return sb.toString();
        }

    }

    public int solve(int A, int[][] B) {

        int minCost = 0;

        // build edge list
        List<Pair> list = new ArrayList<>();
        for (int[] nodesInfo : B) {
            int u = nodesInfo[0];
            int v = nodesInfo[1];
            int weight = nodesInfo[2];
            list.add(new Pair(u, v, weight));
        }
        // sort the edges by weight in ascending order
        Collections.sort(list);
        System.out.println(list);

        // initialize parent array. this means every node is parent of itself[each node
        // represents unique connect component initially]
        int[] parent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        // check for edge if it can be considered in minimum spanning tree
        for (Pair edge : list) {
            // union method combines 2 different components at a given time
            if (union(edge, parent)) {
                // if edge is considered, add weight to cost
                minCost += edge.weight;
            }
        }

        return minCost;
    }

    private boolean union(Pair edge, int[] parent) {

        // find parent of source and target node of edge
        int x = edge.u;
        int y = edge.v;
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);

        // if x and y are part of different components, only then combine them
        if (parent_x != parent_y) {
            parent[parent_x] = parent_y;
            return true;
        }
        // return false when x and y are part of same component
        return false;
    }

    private int findParent(int x, int[] parent) {

        // base condition when parent of x = x
        if (parent[x] == x)
            return x;

        // find top most parent of x
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {

        Kruskals_algorithm t1 = new Kruskals_algorithm();

        int A = 4;
        int[][] B = new int[][] {
                { 1, 2, 1 },
                { 2, 3, 4 },
                { 1, 4, 3 },
                { 4, 3, 2 },
                { 1, 3, 10 }
        };
        System.out.println(t1.solve(A, B)); // 6
    }
}
