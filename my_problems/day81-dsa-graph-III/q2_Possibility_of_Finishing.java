import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* Possibility of Finishing */

/* Problem Description

There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.


Problem Constraints

1 <= A <= 6*10^4
1 <= length(B) = length(C) <= 10^5
1 <= B[i], C[i] <= A


Input Format

The first argument of input contains an integer A, representing the number of courses.

The second argument of input contains an integer array, B.

The third argument of input contains an integer array, C.



Output Format
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.


Example Input

Input 1:
 A = 3
 B = [1, 2]
 C = [2, 3]
Input 2:
 A = 2
 B = [1, 2]
 C = [2, 1]


Example Output

Output 1:
 1
Output 2:
 0


Example Explanation

Explanation 1:

 It is possible to complete the courses in the following order:
    1 -> 2 -> 3
Explanation 2:

 It is not possible to complete all the courses. */

/**
 * Topological sorting - dependency graph resolution
 * TC: O(n + m)
 * SC: O(n + m)
 */
public class q2_Possibility_of_Finishing {

    public int solve(int A, int[] B, int[] C) {

        int[] inDegree = new int[A + 1];
        List<List<Integer>> list = buildAdjList(A, B, C, inDegree);

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 1; i <= A; i++) {
            // add all the nodes with in degree 0 into priority queue(min heap)
            if (inDegree[i] == 0)
                queue.add(i);
        }

        // BFS traversal
        List<Integer> path = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            path.add(x);
            List<Integer> neighbors = list.get(x);
            for (int i = 0; i < neighbors.size(); i++) {
                int temp = neighbors.get(i);
                // decrement the in degree of neighbor
                inDegree[temp]--;
                if (inDegree[temp] == 0) {
                    queue.add(temp);
                }
            }
        }
        // if path contains all the nodes, that means no cycle is detected
        if (path.size() == A)
            return 1;
        return 0;
    }

    public List<List<Integer>> buildAdjList(int A, int[] B, int[] C, int[] inDegree) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= A; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i];
            int v = C[i];
            list.get(u).add(v);
            // increase the in degree of node v
            inDegree[v]++;
        }
        return list;
    }

}
