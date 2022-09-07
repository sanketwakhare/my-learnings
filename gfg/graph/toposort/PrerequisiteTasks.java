package graph.toposort;//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

/* Prerequisite Tasks - application of topo sort */
/* https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prerequisite-tasks */
class PrerequisiteTasks {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("gfg/resources/prerequisite_tasks.txt"));
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int[][] prerequisites = new int[P][2];
            for (int i = 0; i < P; i++) {
                for (int j = 0; j < 2; j++) {
                    prerequisites[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            if (ob.isPossible(N, prerequisites)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            t--;
        }
    }

}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites) {
        // apply topological sort alogiruthm - Kahn's algorithm and figure out if cycle is present or not

        // initialize indegree array
        int[] indegree = new int[N];

        // prepare adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] row : prerequisites) {
            int dest = row[0];
            int src = row[1];
            adj.get(src).add(dest);
            indegree[dest]++;
        }

        // add all nodes with indegree as 0 into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
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
        return result.size() == N;
    }

}