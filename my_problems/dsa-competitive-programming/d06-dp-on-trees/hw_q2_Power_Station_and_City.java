import java.util.ArrayList;
import java.util.Arrays;
/*
Power station and city

Code Solution
 */
public class hw_q2_Power_Station_and_City {

    public static void main(String[] args) {
        hw_q2_Power_Station_and_City t = new hw_q2_Power_Station_and_City();
        int[] A = {9, 4, 1, 7, 10, 1, 6, 5};
        int[][] B = {{1, 2}, {2, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        System.out.println(t.solve(A, B));
    }

    final int mod = (int) 1e9 + 7;
    final int maxN = (int) 1e5 + 5;
    ArrayList<ArrayList<Integer>> adj;
    long[] f = new long[maxN];
    long[] sum = new long[maxN];
    long ans;

    void init() {
        adj = new ArrayList<>(maxN);
        for (int i = 0; i < maxN; i++) {
            adj.add(new ArrayList<>());
        }
        Arrays.fill(f, 0);
        Arrays.fill(sum, 0);
        ans = 0;
    }

    void dfs(int node, int parent, int[] A) {
        sum[node] = A[node - 1];
        for (int i = 0; i < adj.get(node).size(); i++) {
            int child = adj.get(node).get(i);
            if (child == parent) {
                continue;
            }
            dfs(child, node, A);
            sum[node] += sum[child];
            f[node] += f[child] + sum[child];
        }
    }

    void dfs2(int node, int parent, long res) {
        ans = Math.max(ans, res);
        for (int i = 0; i < adj.get(node).size(); i++) {
            int child = adj.get(node).get(i);
            if (child == parent) {
                continue;
            }
            res += sum[1] - 2 * sum[child];
            dfs2(child, node, res);
            res -= (sum[1] - 2 * sum[child]);
        }
    }

    public int solve(int[] A, int[][] B) {
        init();
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(1, -1, A);
        dfs2(1, -1, f[1]);
        return (int) (ans % mod);
    }

}
