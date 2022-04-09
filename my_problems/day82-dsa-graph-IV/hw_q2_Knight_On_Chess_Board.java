import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Knight On Chess Board */

/* Problem Description
Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.


The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints
1 <= A, B <= 500



Input Format
The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.



Output Format
If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.



Example Input
Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8
Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4


Example Output
Output 1:

 6
Output 2:

 -1


Example Explanation
Explanation 1:

 The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 The minimum number of moves required for this is 6.
Explanation 2:

 It is not possible to move knight to position (4, 4) from (2, 1) */

/* TC (A*B + A*B*8) 
SC: O(A*B + A*B*8)*/
public class hw_q2_Knight_On_Chess_Board {

    // Node class represents the coordinate
    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    // Edge
    class Edge {
        // source node
        Node u;
        // target node
        Node v;
        // weight from u to v
        int weight;

        public Edge(Node u, Node v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {

        // base case in case the source or destination is out of board
        if (C > A || D > B || E > A || F > B)
            return -1;

        // maintain the variable to store the min cost to reach source to
        // destination
        int minCost = 0;
        // flag to determine if path exist from source to destination
        boolean isPathExist = false;

        // build adjacency list for AxB elements
        List<List<Node>> list = buildAdjList(A, B, C, D, E, F);

        // Apply Prim's algorithm
        Queue<Edge> queue = new LinkedList<Edge>();
        boolean visited[][] = new boolean[A][B];

        // create source node
        // insert an edge from source to destination with weight as 0
        Node sourceNode = new Node(C - 1, D - 1);
        queue.add(new Edge(sourceNode, sourceNode, 0));

        while (!queue.isEmpty()) {
            Edge parent = queue.poll();
            Node x = parent.v;
            if (!visited[x.i][x.j]) {
                // mark target node as visited
                visited[x.i][x.j] = true;
                if (x.i == E - 1 && x.j == F - 1) {
                    // if destination is found, break out and get minCost
                    minCost = parent.weight;
                    isPathExist = true;
                    break;
                }

                // fetch all the neighbors of the parent node
                int nodeIndex = x.i * B + x.j;
                List<Node> neighbors = list.get(nodeIndex);
                for (Node neighbor : neighbors) {
                    if (!visited[neighbor.i][neighbor.j]) {
                        // if neighbor is not yet visited
                        // add an edge from current parent to its neighbor with unit weight and insert
                        // into queue
                        queue.add(new Edge(x, neighbor, parent.weight + 1));
                    }
                }
            }
        }

        // if path exist, return min cost else return -1
        return isPathExist ? minCost : -1;
    }

    private List<List<Node>> buildAdjList(int A, int B, int C, int D, int E, int F) {

        List<List<Node>> list = new ArrayList<List<Node>>();

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                list.add(new ArrayList<Node>());
            }
        }

        // there are only 8 possibilities from any node
        int[] rows = new int[] { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] cols = new int[] { -1, 1, -2, 2, -2, 2, -1, 1 };

        // there are AxB nodes for AxB size board
        int x, y;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                // get the index of node
                int nodeIndex = (i * B) + j;
                for (int k = 0; k < rows.length; k++) {
                    x = i + rows[k];
                    y = j + cols[k];
                    // insert only valid edge/coordinate which is part of board
                    if (x >= 0 && x < A && y >= 0 && y < B) {
                        list.get(nodeIndex).add(new Node(x, y));
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        hw_q2_Knight_On_Chess_Board t1 = new hw_q2_Knight_On_Chess_Board();
        int A, B, C, D, E, F;

        // {
        // A = 8;
        // B = 8;
        // C = 1;
        // D = 1;
        // E = 8;
        // F = 8;
        // System.out.println(t1.knight(A, B, C, D, E, F));
        // }
        // {
        // A = 8;
        // B = 8;
        // C = 5;
        // D = 6;
        // E = 3;
        // F = 3;
        // System.out.println(t1.knight(A, B, C, D, E, F));
        // }
        // {
        // A = 2;
        // B = 4;
        // C = 2;
        // D = 1;
        // E = 4;
        // F = 4;
        // System.out.println(t1.knight(A, B, C, D, E, F));
        // }
        {
            A = 10;
            B = 3;
            C = 3;
            D = 1;
            E = 10;
            F = 1;
            System.out.println(t1.knight(A, B, C, D, E, F));
        }
    }
}