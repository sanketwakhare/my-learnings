import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a tree with N nodes and values representing each node.
Given Q queries
Perform below operation for given type of query
Type 1: given x and k, update value of all nodes in subtree of x with value k.
Type 2: given x, find sum of subtree of x
 */
public class class_q3_update_subtree_queries {
    public static void main(String[] args) {
        class_q3_update_subtree_queries t = new class_q3_update_subtree_queries();
        {
            int[] values = {1, 3, 4, 2, 6, 5};
            int[][] B = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}};
            int[][] Q = {{2, 1}, {2, 5}, {1, 5, 2}, {2, 2}, {2, 5}, {2, 1}, {2, 3}, {1, 2, 10}, {2, 5}, {2, 2}, {2, 1}, {2, 3}, {1, 3, 20}, {2, 1}, {2, 5}, {2, 2}};
            System.out.println(Arrays.toString(t.solve(values, B, Q))); // [21, 6, 7, 2, 17, 9, 10, 30, 40, 9, 71, 10, 30]
        }
    }

    // TC: O(Q * logN) using segment tree on flattened tree array
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
        // seg[i][0] = sum
        // seg[i][1] = count of nodes in subtree
        int[][] seg = new int[length * 4][2];
        int[] lazy = new int[length * 4];
        buildSeg(0, 0, length - 1, flattened, seg);

        // get result for each query
        List<Integer> result = new ArrayList<>();
        for (int[] q : Q) {
            int type = q[0];
            int x = q[1];
            if (type == 1) {
                // update
                int k = q[2];
                int l = startTime[x];
                int r = endTime[x];
                // perform range update for index [l, r]
                update(0, 0, length - 1, l, r, k, seg, lazy);
            } else {
                // query
                int l = startTime[x];
                int r = endTime[x];
                int sum = get(0, 0, length - 1, l, r, seg, lazy);
                // observation: each node value appears twice in flattened tree
                result.add(sum / 2);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int get(int currIndex, int start, int end, int l, int r, int[][] seg, int[] lazy) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex] != 0) {
            seg[currIndex][0] = lazy[currIndex];
            // retrieve k from count of current nodes in subtree
            int k = lazy[currIndex] / seg[currIndex][1];
            if (start != end) {
                lazy[leftChildIndex] = k * seg[leftChildIndex][1];
                lazy[rightChildIndex] = k * seg[rightChildIndex][1];
            }
            // reset
            lazy[currIndex] = 0;
        }

        // disjoint
        if (end < l || r < start) {
            return 0;
        }
        // overlapping
        if (start >= l && end <= r) {
            return seg[currIndex][0];
        }
        int mid = start + (end - start) / 2;
        int leftSum = get(leftChildIndex, start, mid, l, r, seg, lazy);
        int rightSum = get(rightChildIndex, mid + 1, end, l, r, seg, lazy);
        return leftSum + rightSum;
    }

    private void update(int currIndex, int start, int end, int l, int r, int k, int[][] seg, int[] lazy) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex] != 0) {
            seg[currIndex][0] = lazy[currIndex];
            if (start != end) {
                lazy[leftChildIndex] = k * seg[leftChildIndex][1];
                lazy[rightChildIndex] = k * seg[rightChildIndex][1];
            }
            // reset
            lazy[currIndex] = 0;
        }

        // disjoint range
        if (end < l || r < start) {
            return;
        }

        // overlapping range
        if (start >= l && end <= r) {
            seg[currIndex][0] = k * seg[currIndex][1];
            if (start != end) {
                lazy[leftChildIndex] = k * seg[leftChildIndex][1];
                lazy[rightChildIndex] = k * seg[rightChildIndex][1];
            }
            return;
        }

        int mid = start + (end - start) / 2;
        update(leftChildIndex, start, mid, l, r, k, seg, lazy);
        update(rightChildIndex, mid + 1, end, l, r, k, seg, lazy);

        seg[currIndex][0] = seg[leftChildIndex][0] + seg[rightChildIndex][0];
    }

    private void buildSeg(int currIndex, int start, int end, int[] flattened, int[][] seg) {
        if (start == end) {
            // value of node
            seg[currIndex][0] = flattened[start];
            // count of nodes
            seg[currIndex][1] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        buildSeg(leftChildIndex, start, mid, flattened, seg);
        buildSeg(rightChildIndex, mid + 1, end, flattened, seg);

        seg[currIndex][0] = seg[leftChildIndex][0] + seg[rightChildIndex][0];
        seg[currIndex][1] = seg[leftChildIndex][1] + seg[rightChildIndex][1];
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
