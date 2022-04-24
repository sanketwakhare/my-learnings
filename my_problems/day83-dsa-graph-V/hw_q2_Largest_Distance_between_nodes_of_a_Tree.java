import java.util.ArrayList;
import java.util.List;

/* Largest Distance between nodes of a Tree */

/* Diameter of a Graph */

/* Problem Description

Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints

2 <= |A| <= 40000



Input Format

First and only argument is vector A



Output Format

Return the length of the longest path



Example Input

Input 1:

 
A = [-1, 0]
Input 2:

 
A = [-1, 0, 0]


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 Path is 0 -> 1.
Explanation 2:

 Path is 1 -> 0 -> 2. */
public class hw_q2_Largest_Distance_between_nodes_of_a_Tree {

    int diameter;

    public int solve(int[] A) {

        // initialize diameter/answer
        diameter = 0;
        // build adjacency list
        List<List<Integer>> list = buildAdjacencyList(A);

        // find root
        int root = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1)
                root = i;
        }

        // create a visited array and mark root as visited
        boolean[] visited = new boolean[A.length];
        visited[root] = true;
        // apply DFS on root element
        dfs(root, list, visited);
        // return answer
        System.out.println(diameter);
        return diameter;
    }

    public int dfs(int root, List<List<Integer>> list, boolean[] visited) {

        // initialize max and second max heights, because at a given time onyl consider
        // heights of 2 children for a diameter
        int maxHeight = -1;
        int second_maxHeight = -1;

        // traverse all neighbors and apply dfs on eligible nodes
        List<Integer> neighbors = list.get(root);
        for (int i = 0; i < neighbors.size(); i++) {
            int child = neighbors.get(i);
            if (!visited[child]) {
                // mark as visited
                visited[child] = true;
                // apply DFS
                int childHeight = dfs(child, list, visited);
                // update the max and second max values
                if (childHeight > maxHeight) {
                    second_maxHeight = maxHeight;
                    maxHeight = childHeight;
                } else if (childHeight > second_maxHeight) {
                    second_maxHeight = childHeight;
                }
            }
        }

        // find the max diameter of a graph
        int currentDiameter = maxHeight + second_maxHeight + 2;
        diameter = Math.max(diameter, currentDiameter);

        // return max height of a node
        if (neighbors.size() > 0)
            return maxHeight + 1;
        return 0;
    }

    // build adjacency list
    public List<List<Integer>> buildAdjacencyList(int[] A) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < A.length; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < A.length; i++) {
            int u = i;
            int v = A[i];
            if (A[i] != -1) {
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        hw_q2_Largest_Distance_between_nodes_of_a_Tree t1 = new hw_q2_Largest_Distance_between_nodes_of_a_Tree();
        int[] A;
        {
            A = new int[] { -1, 0 };
            t1.solve(A);
        }
        {
            A = new int[] { -1, 0, 0 };
            t1.solve(A);
        }
        {
            A = new int[] { -1, 0, 0, 1, 2, 1, 3 };
            t1.solve(A);
        }
    }
}
