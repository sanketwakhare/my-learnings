package graph.toposort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Topological sort */
/* https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort */
public class TopologicalSort {

    public static void main(String[] args) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(new FileInputStream("gfg/graph/resources/TopologicalSort.txt")));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String[] st = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String[] s = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = topoSort(nov, list);

            if (check(list, nov, res))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {

        if (V != res.length)
            return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // create indegree array
        int[] indegree = new int[V];
        for (int src = 0; src < V; src++) {
            ArrayList<Integer> neighbors = adj.get(src);
            for (int dest : neighbors) {
                indegree[dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // push all nodes with indegree with 0 into queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            ArrayList<Integer> neighbors = adj.get(curr);
            for (int neighbor : neighbors) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        if (result.size() == V) {
            return result.stream().mapToInt(i -> i).toArray();
        }

        return new int[]{};

    }
}
