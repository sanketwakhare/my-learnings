import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* Prim's algorithm implementation */
public class Prims_algorithm {

    class Pair {
        int weight;
        int u;
        int v;

        public Pair(int _u, int _v, int _w) {
            this.u = _u;
            this.v = _v;
            this.weight = _w;
        }
    }

    class WeightComparator implements Comparator<Pair> {

        @Override
        public int compare(Prims_algorithm.Pair o1, Prims_algorithm.Pair o2) {
            return o1.weight - o2.weight;
        }

    }

    public int getMinCost(int A, int[][] B) {

        int totalCost = 0;

        // consider first node as 1
        List<List<Pair>> edges = buildAdjList(A, B);
        boolean[] visited = new boolean[A + 1];

        // initialize minHeap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new WeightComparator());

        // insert node 1 in queue and mark as visited
        queue.add(new Pair(1, 1, 0));

        while (!queue.isEmpty()) {
            Pair x = queue.poll();
            int x_target = x.v;
            if (!visited[x_target]) {

                // mark current target as visited and add weight to final cost
                visited[x_target] = true;
                totalCost += x.weight;

                // traverse all neighbors of node v
                for (Pair e : edges.get(x_target)) {
                    int source = e.u;
                    int target = e.v;
                    if (visited[source] && visited[target]) {
                        continue;
                    } else if (!visited[source] || !visited[target]) {
                        queue.add(e);
                    }
                }
            }
        }

        return totalCost;
    }

    private List<List<Pair>> buildAdjList(int A, int[][] B) {
        List<List<Pair>> edges = new ArrayList<List<Pair>>();
        for (int i = 0; i <= A; i++) {
            edges.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            edges.get(u).add(new Pair(u, v, w));
            edges.get(v).add(new Pair(v, u, w));
        }
        return edges;
    }

    public static void main(String[] args) {

        Prims_algorithm t1 = new Prims_algorithm();
        int A;
        int[][] B;

        // test case 1
        A = 4;
        B = new int[][] { { 1, 2, 1 },
                { 2, 3, 4 },
                { 1, 4, 3 },
                { 4, 3, 2 },
                { 1, 3, 10 } };
        System.out.println(t1.getMinCost(A, B));

    }

}
