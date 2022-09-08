package graph.problems_on_dfs_and_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Number of Provinces */
/* https://practice.geeksforgeeks.org/problems/number-of-provinces/0 */
public class NumberOfProvinces {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(new FileInputStream("gfg/graph/resources/NumberOfProvinces.txt")));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] S = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            NumberOfProvinces ob = new NumberOfProvinces();
            System.out.println(ob.numProvinces(adj, V));
        }
    }

    public int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        // build adjacency list from adjacency matrix
        int n = adj.size();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = adj.get(i);
            ArrayList<Integer> u = adjList.get(i);
            for (int j = 0; j < n; j++) {
                if (row.get(j) == 1 && i != j) {
                    ArrayList<Integer> v = adjList.get(j);
                    u.add(j);
                    v.add(i);
                }
            }
        }

        // initialize visited array
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int count = 0;

        // apply dfs on every node and count total connected components
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                dfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int currNode, ArrayList<ArrayList<Integer>> adjList, int[] visited) {
        visited[currNode] = 1;
        for (int neighbor : adjList.get(currNode)) {
            if (visited[neighbor] == -1) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
