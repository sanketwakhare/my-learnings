package graph.problems_on_dfs_and_bfs;

import java.util.*;
import java.io.*;
import java.lang.*;

/*Detect cycle in a directed graph*/

/* https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph */

public class Detect_cycle_in_a_directed_graph_dfs {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("gfg/resources/Detect_cycle_in_a_directed_graph.txt"));
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
            if (new Detect_cycle_in_a_directed_graph_dfs().isCyclic(V, list))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for (int curr = 0; curr < V; curr++) {
            if (visited[curr] == 0)
                if (checkCycleDfs(curr, adj, visited, pathVisited)) return true;
        }
        return false;
    }

    public boolean checkCycleDfs(int currNode, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {

        visited[currNode] = 1;
        pathVisited[currNode] = 1;
        ArrayList<Integer> neighbors = adj.get(currNode);
        for (int neighbor : neighbors) {
            if (visited[neighbor] == 0) {
                if (checkCycleDfs(neighbor, adj, visited, pathVisited)) return true;
            } else if (pathVisited[neighbor] == 1) return true;
        }
        // revert pathVisited when we come out from the path
        pathVisited[currNode] = 0;
        return false;
    }
}