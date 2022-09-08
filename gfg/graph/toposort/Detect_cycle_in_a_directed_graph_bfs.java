package graph.toposort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/*Detect cycle in a directed graph*/

/* https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph */

public class Detect_cycle_in_a_directed_graph_bfs {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("gfg/graph/resources/Detect_cycle_in_a_directed_graph.txt"));
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Detect_cycle_in_a_directed_graph_bfs().isCyclic(V, list))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // apply topological sort - Kahn's algorithm
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int dest : adj.get(i)) {
                indegree[dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return result.size() != V;
    }
}