import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* Clone Graph */

/* Problem Description

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

Note: The test cases are generated in the following format (use the following format to use See Expected Output option):
First integer N is the number of nodes.
Then, N integers follow denoting the label (or hash) of the N nodes.
Then, N2 integers following denoting the adjacency matrix of a graph, where Adj[i][j] = 1 denotes presence of an undirected edge between the ith and jth node, O otherwise.


Problem Constraints
1 <= Number of nodes <= 10^5


Input Format
First and only argument is a node A denoting the root of the undirected graph.


Output Format
Return the node denoting the root of the new clone graph.


Example Input
Input 1:
      1
    / | \
   3  2  4
        / \
       5   6
Input 2:
      1
     / \
    3   4
   /   /|\
  2   5 7 6

Example Output
Output 1:
 Output will the same graph but with new pointers:
      1
    / | \
   3  2  4
        / \
       5   6
Output 2:
      1
     / \
    3   4
   /   /|\
  2   5 7 6

Example Explanation

Explanation 1:

 We need to return the same graph, but the pointers to the node should be different. */

public class hw_q2_Clone_Graph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        // map to store the address of source and cloned nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        // visited list as we do not know the size of the nodes in graph
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        // Queue for BFS traversal
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        // add source to queue
        queue.add(node);
        visited.put(node, true);

        // create cloned node od source node
        UndirectedGraphNode clone_node = new UndirectedGraphNode(node.label);
        map.put(node, clone_node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode s_node = queue.poll();
            System.out.println("node " + s_node.label);

            List<UndirectedGraphNode> neighbors = s_node.neighbors;
            for (int i = 0; i < neighbors.size(); i++) {
                UndirectedGraphNode s_neighbor = neighbors.get(i);
                if (!visited.containsKey(s_neighbor)) {
                    visited.put(s_neighbor, true);
                    queue.add(s_neighbor);
                    // as this neighbor is being visited for the first time, create cloned node and
                    // add it to map
                    map.put(s_neighbor, new UndirectedGraphNode(s_neighbor.label));
                }
                // update neighbors for every cloned node
                map.get(s_node).neighbors.add(map.get(s_neighbor));
            }
        }
        // return cloned graph's head element
        return map.get(node);
    }

    public static void main(String[] args) {

        hw_q2_Clone_Graph t1 = new hw_q2_Clone_Graph();
        // test case 1
        // @formatter:off
        //       1
        //     / | \
        //    3  2  4
        //         / \
        //        5   6
        // @formatter:on
        {
            UndirectedGraphNode node_1 = new UndirectedGraphNode(1);
            UndirectedGraphNode node_2 = new UndirectedGraphNode(2);
            UndirectedGraphNode node_3 = new UndirectedGraphNode(3);
            UndirectedGraphNode node_4 = new UndirectedGraphNode(4);
            UndirectedGraphNode node_5 = new UndirectedGraphNode(5);
            UndirectedGraphNode node_6 = new UndirectedGraphNode(6);

            node_1.neighbors.add(node_2);
            node_1.neighbors.add(node_3);
            node_1.neighbors.add(node_4);

            node_2.neighbors.add(node_1);

            node_3.neighbors.add(node_1);

            node_4.neighbors.add(node_1);
            node_4.neighbors.add(node_5);
            node_4.neighbors.add(node_6);

            node_5.neighbors.add(node_4);
            node_6.neighbors.add(node_4);

            t1.cloneGraph(node_1);
        }
    }
}
