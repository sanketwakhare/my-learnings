import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/network-delay-time/ */

// LeetCode problem - Application of Dijkstra's algorithm
public class Network_Delay_Time {

    class Edge implements Comparable<Edge> {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        List<List<Edge>> list = buildAdjList(n, times);

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        dist[k] = 0;
        queue.add(new Edge(k, k, 0));

        while (!queue.isEmpty()) {
            Edge parentEdge = queue.poll();
            int dest = parentEdge.v;
            int wt = parentEdge.w;

            if (wt == dist[dest]) {
                List<Edge> neighbors = list.get(dest);
                for (Edge edge : neighbors) {
                    if (dist[edge.v] > dist[dest] + edge.w) {
                        dist[edge.v] = dist[dest] + edge.w;
                        queue.add(new Edge(edge.u, edge.v, edge.w + parentEdge.w));
                    }
                }
            }
        }

        int maxWt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxWt = Math.max(maxWt, dist[i]);
        }

        return maxWt;

    }

    public List<List<Edge>> buildAdjList(int n, int[][] times) {

        List<List<Edge>> list = new ArrayList<List<Edge>>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            list.get(u).add(new Edge(u, v, w));
        }
        return list;
    }

    public static void main(String[] args) {

        Network_Delay_Time t1 = new Network_Delay_Time();
        {
            int[][] times = new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
            int n = 4;
            int k = 2;

            int result = t1.networkDelayTime(times, n, k);
            System.out.println(result); // 2
        }
        {
            int[][] times = new int[][] { { 1, 2, 1 }, { 2, 3, 2 }, { 1, 3, 4 } };
            int n = 3;
            int k = 1;

            int result = t1.networkDelayTime(times, n, k);
            System.out.println(result); // 3
        }
    }
}
