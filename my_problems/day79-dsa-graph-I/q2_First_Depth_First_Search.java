import java.util.ArrayList;
import java.util.List;

/*  First Depth First Search */

/* Problem Description

You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i.

NOTE: Array A is 0-indexed.


Problem Constraints
1 <= n <= 100000


Input Format

First argument is vector A
Second argument is integer B
Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input

Input 1:
 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:
 A = [1, 1, 2]
 B = 2
 C = 1


Example Output

Output 1:
 0
Output 2:
 1

Example Explanation

Explanation 1:
 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:
 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */

public class q2_First_Depth_First_Search {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(int[] A, final int B, final int C) {
        // create adjacency list
        List<List<Integer>> lst = buildList(A);
        boolean[] visited = new boolean[A.length + 1];
        return isPathPresent(lst, C, B, visited) ? 1 : 0;
    }

    public List<List<Integer>> buildList(int[] A) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        for (int i = 0; i <= A.length; i++) {
            lst.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < A.length; i++) {
            lst.get(A[i]).add(i + 1);
        }
        return lst;
    }

    /* DFS traversal - recursion */
    public boolean isPathPresent(List<List<Integer>> list, int source, int dest, boolean[] visited) {

        if (source == dest)
            return true;

        if (!visited[source]) {
            visited[source] = true;
            List<Integer> adjList = list.get(source);
            for (int i = 0; i < adjList.size(); i++) {
                int nextNode = adjList.get(i);
                if (isPathPresent(list, nextNode, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        q2_First_Depth_First_Search t1 = new q2_First_Depth_First_Search();
        int[] A;
        int B, C;

        // test case 1
        A = new int[] { 1, 1, 2 };
        B = 1;
        C = 2;
        System.out.println(t1.solve(A, B, C));

        // test case 2
        A = new int[] { 1, 1, 2 };
        B = 2;
        C = 1;
        System.out.println(t1.solve(A, B, C));
    }

}
