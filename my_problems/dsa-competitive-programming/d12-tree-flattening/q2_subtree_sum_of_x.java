import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a tree with N nodes and values representing each node.
Given Q queries
Perform below operation for given type of query
Type 1: given x and value, update value of node x to value. [set val[x] = value]
Type 2: given x, find sum of subtree of x
 */
public class q2_subtree_sum_of_x {
    public static void main(String[] args) {
        q2_subtree_sum_of_x t = new q2_subtree_sum_of_x();
        {
            int[] values = {1, 3, 4, 2, 6, 5};
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}};
            int[][] Q = {{2, 1}, {1, 5, 2}, {2, 2}, {2, 1}, {2, 3}};
            System.out.println(Arrays.toString(t.solve(values, B, Q))); // [21, 7, 17, 9]
        }
    }

    // TC: O(Q * logN) where N is length of flattened tree which is 2 times no of nodes in tree
    public int[] solve(int[] values, int[][] B, int[][] Q) {
        // build adjacency list
        int n = values.length;
        List<List<Integer>> adjList = buildAdjList(n, B);

        // populate startTime, endTime and flattened arrays
        int[] startTime = new int[n + 1];
        int[] endTime = new int[n + 1];
        int[] flattened = new int[n * 2];
        dfs(1, -1, adjList, startTime, endTime, new int[]{0}, values, flattened);

        // build segment tree on flattened array
        int length = flattened.length;
        int[] seg = new int[length * 4];
        buildSeg(0, 0, length - 1, flattened, seg);

        // get result for each query
        List<Integer> result = new ArrayList<>();
        for (int[] q : Q) {
            int type = q[0];
            int x = q[1];
            if (type == 1) {
                // update
                int value = q[2];
                int l = startTime[x];
                int r = endTime[x];
                // perform 2 updates, one at index l and index r
                update(0, 0, length - 1, l, value, flattened, seg);
                update(0, 0, length - 1, r, value, flattened, seg);
            } else {
                // query
                int l = startTime[x];
                int r = endTime[x];
                int sum = get(0, 0, length - 1, l, r, seg);
                // observation: each node value appears twice in flattened tree
                result.add(sum / 2);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int get(int currIndex, int start, int end, int l, int r, int[] seg) {
        // disjoint
        if (end < l || r < start) {
            return 0;
        }
        // overlapping
        if (start >= l && end <= r) {
            return seg[currIndex];
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int leftSum = get(leftChildIndex, start, mid, l, r, seg);
        int rightSum = get(rightChildIndex, mid + 1, end, l, r, seg);
        return leftSum + rightSum;
    }

    private void update(int currIndex, int start, int end, int index, int value, int[] flattened, int[] seg) {
        if (start == end) {
            seg[currIndex] = value;
            flattened[index] = value;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        if (index <= mid) {
            update(leftChildIndex, start, mid, index, value, flattened, seg);
        } else {
            update(rightChildIndex, mid + 1, end, index, value, flattened, seg);
        }
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    private void buildSeg(int currIndex, int start, int end, int[] flattened, int[] seg) {
        if (start == end) {
            seg[currIndex] = flattened[start];
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        buildSeg(leftChildIndex, start, mid, flattened, seg);
        buildSeg(rightChildIndex, mid + 1, end, flattened, seg);
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    private void dfs(int curr, int parent, List<List<Integer>> adjList,
                     int[] startTime, int[] endTime, int[] time,
                     int[] values, int[] flattened) {
        int startIndex = startTime[curr] = time[0]++;
        flattened[startIndex] = values[curr - 1];
        for (int neighbor : adjList.get(curr)) {
            if (neighbor != parent) {
                dfs(neighbor, curr, adjList, startTime, endTime, time, values, flattened);
            }
        }
        int endIndex = endTime[curr] = time[0]++;
        flattened[endIndex] = values[curr - 1];
    }


    List<List<Integer>> buildAdjList(int A, int[][] B) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
