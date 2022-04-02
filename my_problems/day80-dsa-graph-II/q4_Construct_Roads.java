import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Construct Roads */

/* Problem Description
A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.

Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.

Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.

NOTE: All cities can be visited from any city.

Problem Constraints
1 <= A <= 10^5
1 <= B[i][0], B[i][1] <= N


Input Format
First argument is an integer A denoting the number of cities, N.

Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .

Output Format
Return an integer denoting the maximum number of roads king can construct.

Example Input
Input 1:

 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]
Input 2:

 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]

Example Output
Output 1:
 0
Output 2:
 2


Example Explanation
Explanation 1:

 We can't construct any new roads such that the country remains bipartite.
Explanation 2:

 We can add two roads between cities (4, 2) and (4, 5). */

/**
 * Idea: As country is already Bipartite, try to divide existing cities into 2
 * sets.
 * As there are already B.length roads built we need to find the road which can
 * be possible to build after dividing the cities into 2 sets
 */
public class q4_Construct_Roads {

    public int solve(int n, int[][] B) {
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        // build adjacency list
        List<List<Integer>> list = buildAdjacencyList(n, B);

        // it is given that country are already bipartite
        // try to divide the cities into 2 sets
        visited[1] = 1;
        dfs(1, list, visited);

        // separate out the two sets
        int set1Count = 0, set2Count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0)
                set1Count++;
            else if (visited[i] == 1)
                set2Count++;
        }

        // totalRoads = (x * y)
        // roads already built = n-1 (B.length)
        long m = 1000000007;
        long totalRoads = (set1Count % m * set2Count % m) % m;
        long newRoads = totalRoads - B.length;

        return (int) newRoads;
    }

    private void dfs(int source, List<List<Integer>> list, int[] visited) {

        // neighbors
        List<Integer> neighbors = list.get(source);
        for (int i = 0; i < neighbors.size(); i++) {
            int currNode = neighbors.get(i);
            if (visited[currNode] == -1) {
                // divide the neighboring city into opposite set
                visited[currNode] = 1 ^ visited[source];
                dfs(currNode, list, visited);
            }
        }
    }

    // build adjacency list for undirected graph
    private List<List<Integer>> buildAdjacencyList(int n, int[][] B) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return list;
    }

    public static void main(String[] args) {

        q4_Construct_Roads t1 = new q4_Construct_Roads();
        int A;
        int[][] B;

        // test case 1
        A = 5;
        B = new int[][] {
                { 1, 3 },
                { 1, 4 },
                { 3, 2 },
                { 3, 5 } };
        System.out.println(t1.solve(A, B)); // 2 [as 4 roads are already built, 2 more roads can be constructed]

        // test case 2
        A = 2;
        B = new int[][] {
                { 2, 1 } };
        System.out.println(t1.solve(A, B)); // 0

        // test case 3
        A = 15;
        B = new int[][] {
                { 7, 5 },
                { 15, 14 },
                { 11, 2 },
                { 8, 7 },
                { 10, 3 },
                { 5, 3 },
                { 4, 2 },
                { 6, 4 },
                { 13, 2 },
                { 3, 2 },
                { 14, 11 },
                { 12, 9 },
                { 2, 1 },
                { 9, 2 } };
        System.out.println(t1.solve(A, B)); // 42
    }

}
