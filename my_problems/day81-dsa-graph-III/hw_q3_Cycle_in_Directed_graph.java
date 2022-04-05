import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Cycle in Directed Graph */

/* Idea: use topological sorting to identify the cycle in directed graph */

public class hw_q3_Cycle_in_Directed_graph {

    public int solve(int A, int[][] B) {

        // build in-degree array and adjacency list
        int[] inDegree = new int[A + 1];
        List<List<Integer>> list = buildAdjList(A, B, inDegree);

        // add all nodes with inDegree 0 into Queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // for each node, visit all it's neighbors and decrease inDegree and insert into
        // Queue
        List<Integer> path = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            path.add(x);
            List<Integer> neighbors = list.get(x);
            for (int i = 0; i < neighbors.size(); i++) {
                int temp = neighbors.get(i);
                inDegree[temp]--;
                if (inDegree[temp] == 0) {
                    queue.add(temp);
                }
            }
        }

        // at the end, if the no of elements in the path array/list are equal to A then
        // cycle does not exist.
        if (path.size() == A)
            return 0;
        // if no of elements in path array are != A, then cycle exist in directed graph
        return 1;
    }

    public List<List<Integer>> buildAdjList(int A, int[][] B, int[] inDegree) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= A; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            list.get(u).add(v);
            // increase in-degree of target node
            inDegree[v]++;
        }
        return list;
    }

    public static void main(String[] args) {
        hw_q3_Cycle_in_Directed_graph t1 = new hw_q3_Cycle_in_Directed_graph();
        int A;
        int[][] B;

        // test case 1
        A = 5;
        B = new int[][] { { 1, 2 },
                { 4, 1 },
                { 2, 4 },
                { 3, 4 },
                { 5, 2 },
                { 1, 3 } };
        System.out.println(t1.solve(A, B));

        // test case 2
        A = 5;
        B = new int[][] { { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 5 } };
        System.out.println(t1.solve(A, B));
    }
}
