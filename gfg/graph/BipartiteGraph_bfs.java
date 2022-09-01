package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*Bipartite Graph*/

/* https://practice.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph */

public class BipartiteGraph_bfs {
    // Driver code
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("gfg/resources/BipartiteGraph.txt")));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            BipartiteGraph_bfs obj = new BipartiteGraph_bfs();
            boolean ans = obj.isBipartite(V, adj);
            if (ans)
                System.out.println("1");
            else System.out.println("0");
        }
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, adj, colors))
                    return false;
            }
        }
        return true;
    }

    public boolean bfs(int i, ArrayList<ArrayList<Integer>> adj, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        colors[i] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int currColor = colors[curr];
            ArrayList<Integer> neighbors = adj.get(curr);
            for (int neighbor : neighbors) {
                if (colors[neighbor] == -1) {
                    int oppisiteColor = currColor == 1 ? 0 : 1;
                    colors[neighbor] = oppisiteColor;
                    queue.offer(neighbor);
                } else if (colors[neighbor] == currColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
