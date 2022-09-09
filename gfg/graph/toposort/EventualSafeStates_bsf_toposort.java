package graph.toposort;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Eventual Safe States */
/* https://practice.geeksforgeeks.org/problems/eventual-safe-states/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states */
class EventualSafeStates_bsf_toposort {
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

            EventualSafeStates_bsf_toposort obj = new EventualSafeStates_bsf_toposort();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // idea:
        // reverse edges
        // apply topo sort - Kahn's algorithm

        List<List<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            reverseAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.size(); i++) {
            List<Integer> dest = adj.get(i);
            for (int v : dest) {
                reverseAdj.get(v).add(i);
            }
        }

        int[] inDegree = new int[V];
        for (List<Integer> nodes : reverseAdj) {
            for (int v : nodes) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // add all vertices with indegre as 0 into queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // bfs traversal
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int neighbor : reverseAdj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
