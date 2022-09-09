package graph.toposort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* Eventual Safe States */
/* https://practice.geeksforgeeks.org/problems/eventual-safe-states/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states */
class EventualSafeStates_dfs {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("gfg/graph/resources/eventual_safe_states.txt"));
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            EventualSafeStates_dfs obj = new EventualSafeStates_dfs();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<Integer> result = new ArrayList<>();
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                // if node is not visited yet, call dfs
                boolean isSafe = dfs(i, adj, visited, pathVisited);
                if (isSafe) result.add(i);
            } else if (pathVisited[i] == 0) {
                // if pathVisited is 0 and visited is 1, then it is safe node
                result.add(i);
            }
        }
        return result;
    }

    // check if cycle is present in directed graph and update visited and pathVisited
    public boolean dfs(int curr, List<List<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[curr] = 1;
        pathVisited[curr] = 1;
        for (int neighbor : adj.get(curr)) {
            if (visited[neighbor] == 0) {
                if (!dfs(neighbor, adj, visited, pathVisited)) {
                    return false;
                }
            } else if (pathVisited[neighbor] == 1) {
                return false;
            }
        }
        pathVisited[curr] = 0;
        return true;
    }
}
