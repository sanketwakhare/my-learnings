/* Make Circle */

/* Problem Description
Given an array of strings A of size N, find if the given strings can be chained to form a circle.

A string X can be put before another string Y in circle if the last character of X is same as first character of Y.

NOTE: All strings consist of lower case characters.



Problem Constraints
1 <= N <= 105

Sum of length of all strings <= 106



Input Format
First and only argument is a string array A of size N.



Output Format
Return an integer 1 if it is possible to chain the strings to form a circle else return 0.



Example Input
Input 1:

 A = ["aab", "bac", "aaa", "cda"]
Input 2:

 A = ["abc", "cbc"]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 We can chain the strings aab -> bac -> cda -> aaa -> aab. So this forms a circle. So, output will be 1. 
Explanation 2:

 There is no way to chain the given strings such that they forms a circle. */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class q3_Make_Circle {

    // Maintain a count variable and apply DFS considering source as any node
    int count = 0;
    int[] inDegree, outDegree;

    public int solve(String[] A) {

        count = 0;
        inDegree = new int[26];
        outDegree = new int[26];

        // build adjacency list using HashMap.
        // Use Queue to remove visited element and add it to end of Queue so that
        // unvisited elements are visited first. Optimization to avoid TLE
        Map<Character, Queue<Integer>> map = buildAdjList(A);

        // if in degree and out degree are not matching, return false
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i])
                return 0;
        }

        // initialize visited array
        boolean[] visited = new boolean[A.length];
        boolean flag = false;

        // start with first string as source and perform DFS traversal
        int source = 0;
        flag = dfsTraversal(source, A, map, visited);

        return flag == true ? 1 : 0;
    }

    private Map<Character, Queue<Integer>> buildAdjList(String[] A) {

        // maintain Queue of index of all strings for each starting characters
        Map<Character, Queue<Integer>> map = new HashMap<Character, Queue<Integer>>();

        for (int i = 0; i < A.length; i++) {

            String str1 = A[i];
            char startChar = str1.charAt(0);
            if (map.containsKey(startChar)) {
                map.get(startChar).add(i);
            } else {
                Queue<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(startChar, list);
            }

            // maintain inDegree and outDegree array to eliminate the cases where they do
            // not match.
            // Observation is to form a circle, inDegree and outDegree of start and end
            // characters of strings should be equal.
            char endChar = str1.charAt(str1.length() - 1);
            inDegree[startChar - 'a']++;
            outDegree[endChar - 'a']++;
        }
        return map;
    }

    private boolean dfsTraversal(int source, String[] A, Map<Character, Queue<Integer>> map, boolean[] visited) {

        // base condition when count = no of nodes visited and last node is already
        // visited
        if (count == A.length && visited[source]) {
            return true;
        }

        if (!visited[source]) {
            // id nodes are unvisited, mark them as visited and increase the count
            visited[source] = true;
            count++;

            // access source string and get the end character of source string
            // get neighbors who start with end characters of source strings
            String sourceStr = A[source];
            Queue<Integer> neighbors = map.get(sourceStr.charAt(sourceStr.length() - 1));

            // if there are no neighbors, return false
            if (neighbors == null) {
                return false;
            }
            // iterate over each neighbor
            for (int i = 0; i < neighbors.size(); i++) {

                // remove neighbor from queue
                int target = neighbors.poll();

                // if no self loop
                // if current count is < length if input array strings
                // if count = length of input array string and target node is already visited,
                // apply DFS
                if (A[target] != A[source]
                        && ((!visited[target] && count < A.length) || (visited[target] && count == A.length))) {
                    if (dfsTraversal(target, A, map, visited)) {
                        // if circle is formed, return true
                        return true;
                    }
                }
                // add neighbor back to queue at last so that it will be visited last
                // as we need to try other paths/possibilities
                neighbors.add(target);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        q3_Make_Circle t1 = new q3_Make_Circle();
        String[] A;
        {
            A = new String[] { "aab", "bac", "aaa", "cda" };
            System.out.println(t1.solve(A));
            A = new String[] { "da", "bc", "cd", "ab" };
            System.out.println(t1.solve(A));
            A = new String[] { "ihgg", "gigfi", "hggii", "gh", "ihhfhfh" };
            System.out.println(t1.solve(A));
            A = new String[] { "g", "ggfhhgfi", "ihifhhgf" };
            System.out.println(t1.solve(A));
        }

    }
}
