package graph.toposort;


import java.util.*;
import java.io.*;
import java.lang.*;

/* Course Schedule */
/* https://practice.geeksforgeeks.org/problems/course-schedule/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=course-schedule */
class CourseSchedule {
    //{ Driver Code Starts
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(new FileInputStream("gfg/graph/resources/course_schedule.txt")));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String[] st = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String[] s = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new CourseSchedule().findOrder(n, m, prerequisites);

            if (res.length == 0)
                System.out.println("No Ordering Possible");
            else {
                if (check(list, n, res))
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
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
    // } Driver Code Ends

    //Initial template for JAVA
    public int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // apply topological sort algorithm - Kahn's algorithm and figure out if cycle is present or not

        // initialize indegree array
        int[] indegree = new int[n];

        // prepare adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> row : prerequisites) {
            int dest = row.get(0);
            int src = row.get(1);
            adj.get(src).add(dest);
            indegree[dest]++;
        }

        // add all nodes with indegree as 0 into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // traverse graph
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

        // if it is possible to complete all tasks, return true
        if (result.size() != n) return new int[]{};
        return result.stream().mapToInt(i -> i).toArray();
    }
}
