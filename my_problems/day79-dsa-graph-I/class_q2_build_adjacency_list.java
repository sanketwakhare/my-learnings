import java.util.ArrayList;
import java.util.List;

public class class_q2_build_adjacency_list {

    public void buildAdjList(int n, int[][] B) {
        // 1 -> [4, 2]
        // 2 -> [1]
        // 3
        // 4 -> [1]
        // 5
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0]; // 1
            int v = B[i][1]; // 4
            // get 1 and insert 4
            adjacencyList.get(u).add(v);
            // get 4 and insert 1
            // adjacencyList.get(v).add(u);
        }

        System.out.println(adjacencyList);

    }

    public static void main(String[] args) {

        class_q2_build_adjacency_list t1 = new class_q2_build_adjacency_list();
        // test case 1
        int n = 5;
        // directed graph - the direction exist from both sides
        int[][] B = new int[][] { { 1, 4 },
                { 2, 1 }, { 4, 3 }, { 4, 5 }, { 2, 3 }, { 2, 4 }, { 1, 5 }, { 5, 3 },
                { 2, 5 }, { 5, 1 }, { 4, 2 }, { 3, 1 }, { 5, 4 }, { 3, 4 }, { 1, 3 }, { 4, 1 }, { 3, 5 }, { 3, 2 },
                { 5, 2 } };
        t1.buildAdjList(n, B);

    }
}
