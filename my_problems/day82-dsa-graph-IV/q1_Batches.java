import java.util.HashMap;
import java.util.Map;

public class q1_Batches {

    public int solve(int A, int[] B, int[][] C, int D) {

        int[] parent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < C.length; i++) {
            int x = C[i][0];
            int y = C[i][1];

            union(x, y, parent);
        }

        // find parent of each node
        for (int i = 1; i <= A; i++) {
            parent[i] = findParent(i, parent);
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= A; i++) {
            int strength = B[i - 1];
            if (!map.containsKey(parent[i])) {
                map.put(parent[i], strength);
            } else {
                map.put(parent[i], map.get(parent[i]) + strength);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= D) {
                count++;
            }
        }
        return count;

    }

    public void union(int x, int y, int[] parent) {

        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);
        if (parent_x != parent_y) {
            // assign new parent for y. x and y will be combined into single connected
            // component
            parent[parent_x] = parent_y;
        }
    }

    public int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        // this will override the existing parent of x
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {

        q1_Batches t1 = new q1_Batches();
        int A, D;
        int[][] C;
        int[] B;

        A = 10;
        B = new int[] { 7, 9, 3, 2, 9, 1, 6, 4, 10, 8 };
        C = new int[][] {
                { 1, 5 },
                { 2, 6 },
                { 3, 7 },
                { 3, 9 },
                { 3, 10 },
                { 4, 5 },
                { 4, 7 },
                { 4, 10 },
                { 5, 7 },
                { 7, 9 }
        };
        D = 26;
        System.out.println(t1.solve(A, B, C, D)); // 1

        A = 9;
        B = new int[] { 10, 8, 2, 3, 4, 8, 3, 5, 9 };
        C = new int[][] {
                { 1, 4 },
                { 1, 6 },
                { 2, 7 },
                { 2, 9 },
                { 3, 5 },
                { 3, 8 },
                { 4, 9 },
                { 5, 8 },
                { 6, 8 }
        };
        D = 25;
        System.out.println(t1.solve(A, B, C, D)); // 1

    }

}
