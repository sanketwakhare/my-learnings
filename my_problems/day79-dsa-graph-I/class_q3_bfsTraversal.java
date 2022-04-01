import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class class_q3_bfsTraversal {

    public List<Integer> bfsTraversal(int n, int[][] B) {

        List<List<Integer>> list = buildAdjacencyList(n, B);

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> bfsPath = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            // source
            int source = i;
            if (!visited[source]) {
                queue.add(source);
                visited[source] = true;

                while (!queue.isEmpty()) {

                    int x = queue.poll();
                    bfsPath.add(x);
                    List<Integer> dest = list.get(x);
                    for (int j = 0; j < dest.size(); j++) {
                        int nextNode = dest.get(j);
                        if (!visited[nextNode]) {
                            queue.add(nextNode);
                            visited[nextNode] = true;
                        }
                    }
                }
            }
        }
        return bfsPath;
    }

    public List<List<Integer>> buildAdjacencyList(int n, int[][] B) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int source = B[i][0];
            int target = B[i][1];
            list.get(source).add(target);
        }
        return list;
    }

    public static void main(String[] args) {

        class_q3_bfsTraversal t1 = new class_q3_bfsTraversal();
        int A;
        int[][] B;

        // test case 1
        // @formatter:off
        /* ________________
        * |               |
        *  --> 4--> 1 --> 2 <-- 5  
        *       | 
        *       ---->3
        */
        // @formatter:on
        A = 5;
        B = new int[][] { { 1, 2 },
                { 4, 1 },
                { 2, 4 },
                { 3, 4 },
                { 5, 2 },
                { 1, 3 } };
        System.out.println(t1.bfsTraversal(A, B)); // [1, 2, 3, 4, 5]

        // test case 3
        A = 5;
        B = new int[][] { { 1, 4 },
                { 2, 1 }, { 4, 3 }, { 4, 5 }, { 2, 3 }, { 2, 4 }, { 1, 5 }, { 5, 3 },
                { 2, 5 }, { 5, 1 }, { 4, 2 }, { 3, 1 }, { 5, 4 }, { 3, 4 }, { 1, 3 }, { 4, 1 }, { 3, 5 }, { 3, 2 },
                { 5, 2 } };
        System.out.println(t1.bfsTraversal(A, B)); // [1, 4, 5, 3, 2]
    }

}
