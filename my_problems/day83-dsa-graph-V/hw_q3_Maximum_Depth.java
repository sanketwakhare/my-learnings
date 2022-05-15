import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hw_q3_Maximum_Depth {

    /**
     * Structure of TreeNode
     */
    class TreeNode {
        int node;
        int value;
        List<TreeNode> neighbors;

        public TreeNode(int node) {
            this.node = node;
            this.neighbors = new LinkedList<TreeNode>();
        }

        public TreeNode(int node, int value) {
            this.node = node;
            this.value = value;
            this.neighbors = new LinkedList<TreeNode>();
        }
    }

    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {

        // create adjacency list
        List<TreeNode> list = buildAdjacencyList(A, B, C, D);

        // level order traversal and get all elements in level
        List<List<Integer>> levels = performLevelOrderTraversal(A, list);

        // for each query get the ceil from respective level
        int[] output = new int[E.length];
        int totalLevels = levels.size();
        for (int i = 0; i < E.length; i++) {
            int L = E[i] % totalLevels;
            int X = F[i];
            int ceil = getCeil(X, levels.get(L));
            output[i] = ceil;
        }

        return output;

    }

    /**
     * Get Ceil of x using Binary Search
     */
    private int getCeil(int x, List<Integer> list) {

        int start = 0;
        int end = list.size() - 1;

        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = list.get(mid);
            if (midValue == x) {
                return x;
            } else if (midValue < x) {
                start = mid + 1;
            } else {
                answer = midValue;
                end = mid - 1;
            }
        }

        return answer;
    }

    /**
     * Level Order Traversal
     */
    private List<List<Integer>> performLevelOrderTraversal(int A, List<TreeNode> list) {
        boolean[] visited = new boolean[A + 1];
        TreeNode source = list.get(1);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(source);
        queue.add(null);
        visited[source.node] = true;

        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        levels.add(new ArrayList<Integer>());

        List<Integer> currentLevel = levels.get(levels.size() - 1);
        while (queue.size() > 1) {

            TreeNode x = queue.poll();

            if (x == null) {
                // end of current level
                // sort previous level
                Collections.sort(currentLevel);
                // add new level
                levels.add(new ArrayList<Integer>());
                currentLevel = levels.get(levels.size() - 1);
                // add null to denote end of current level
                queue.add(null);
            } else {
                currentLevel.add(x.value);

                // add neighbors in queue
                List<TreeNode> neighbors = x.neighbors;
                for (TreeNode neighbor : neighbors) {
                    if (!visited[neighbor.node]) {
                        queue.add(neighbor);
                        visited[neighbor.node] = true;
                    }
                }
            }
        }

        // sort last level
        Collections.sort(currentLevel);
        return levels;
    }

    /**
     * Build Adjacency List
     */
    public List<TreeNode> buildAdjacencyList(int A, int[] B, int[] C, int[] D) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (int i = 0; i <= A; i++) {
            list.add(new TreeNode(i));
            if (i > 0)
                list.get(i).value = D[i - 1];
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i];
            int v = C[i];
            // undirected graph
            TreeNode sourceNode = list.get(u);
            TreeNode targetNode = list.get(v);
            sourceNode.neighbors.add(targetNode);
            targetNode.neighbors.add(sourceNode);
        }
        return list;
    }

    public static void main(String[] args) {
        hw_q3_Maximum_Depth t1 = new hw_q3_Maximum_Depth();

        {
            // test case 1
            int A = 5;
            int[] B = new int[] { 1, 4, 3, 1 };
            int[] C = new int[] { 5, 2, 4, 4 };
            int[] D = new int[] { 7, 38, 27, 37, 1 };
            int[] E = new int[] { 1, 1, 2 };
            int[] F = new int[] { 32, 18, 26 };
            int[] result = t1.solve(A, B, C, D, E, F);
            ArrayUtils.printArray(result);
        }
        {
            // test case 2
            int A = 3;
            int[] B = new int[] { 1, 2 };
            int[] C = new int[] { 3, 1 };
            int[] D = new int[] { 7, 15, 27 };
            int[] E = new int[] { 1, 10, 1 };
            int[] F = new int[] { 29, 6, 26 };
            int[] result = t1.solve(A, B, C, D, E, F);
            ArrayUtils.printArray(result);
        }
    }
}
