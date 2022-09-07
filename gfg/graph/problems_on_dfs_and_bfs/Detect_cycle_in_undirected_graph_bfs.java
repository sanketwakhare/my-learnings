package graph.problems_on_dfs_and_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Detect cycle in undirected graph */
/* https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/0 */
class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Detect_cycle_in_undirected_graph_bfs {

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
            Detect_cycle_in_undirected_graph_bfs obj = new Detect_cycle_in_undirected_graph_bfs();
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
        for(int i=0; i<V; i++) {
            if(visited[i] == 0) {
                if(bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }

    public boolean bfs(int curr, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[curr] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(curr, -1));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int node = p.first;
            int parent = p.second;
            for(int neighbor : adj.get(node)) {
                if(visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    queue.add(new Pair(neighbor, node));
                } else if(neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
