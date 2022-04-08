import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* Commutable Islands */

/* Problem Description

There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints

1 <= A, M <= 6*10^4

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 10^3



Input Format

The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format

Return an integer representing the minimal cost required.



Example Input

Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output

Output 1:

 6
Output 2:

 6


Example Explanation

Explanation 1:

 We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
Explanation 2:

 We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6. */

// Apply Kruskal's algorithm or Prims algorithm to find minimum cost
public class q2_Commutable_Islands {

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
        public int compare(Pair o1, Pair o2) {
            return o1.weight - o2.weight;
        }
    }

    public int solve(int A, int[][] B) {

        int totalCost = 0;
        // build adjacency list
        List<List<Pair>> edges = buildAdjList(A, B);
        boolean[] visited = new boolean[A + 1];
        // initialize minHeap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new WeightComparator());

        // insert node 1 (with cost 0) in queue
        queue.add(new Pair(1, 1, 0));

        while (!queue.isEmpty()) {
            Pair x = queue.poll();
            int x_target = x.v;
            if (!visited[x_target]) {

                // mark current target node as visited and add weight to final cost
                visited[x_target] = true;
                totalCost += x.weight;

                // traverse all neighbors of target node
                for (Pair e : edges.get(x_target)) {
                    int source = e.u;
                    int target = e.v;
                    if (visited[source] && visited[target]) {
                        continue;
                    } else if (!visited[source] || !visited[target]) {
                        // if one th node of current neighbor is unvisited, add edge into queue
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

        q2_Commutable_Islands t1 = new q2_Commutable_Islands();
        int A;
        int[][] B;

        // test case 1
        A = 4;
        B = new int[][] { { 1, 2, 1 },
                { 2, 3, 4 },
                { 1, 4, 3 },
                { 4, 3, 2 },
                { 1, 3, 10 } };
        System.out.println(t1.solve(A, B)); // 6

    }
}
