package graph.problems_on_dfs_and_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Detect_cycle_in_undirected_graph_dfs {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(new FileInputStream("gfg/resources/Detect_cycle_in_undirected_graph.txt")));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Detect_cycle_in_undirected_graph_dfs obj = new Detect_cycle_in_undirected_graph_dfs();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0 && dfs(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int curr, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[curr] = 1;
        for (int neighbor : adj.get(curr)) {
            if (visited[neighbor] == 0) {
                if (dfs(neighbor, curr, adj, visited))
                    return true;
            } else if (neighbor != parent && visited[neighbor] == 1) {
                return true;
            }
        }
        return false;
    }
}
