/* Sheldon and Pair of Cities */

/* Problem Description

Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.

Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities and F[i] denotes the distance between the cities.

Now he has many lectures to give in the city and is running short of time, so he asked you C queries, for each query i, find the shortest distance between city G[i] and H[i].

If the two cities are not connected then the distance between them is assumed to be -1.



Problem Constraints

1 <= A <= 200

1 <= B <= 200000

1 <= C <= 100000

1 <= F[i] <= 1000000

1 <= D[i], E[i], G[i], H[i] <= A



Input Format

First argument is an integer A.
Seocnd argument is an integer B.
Third argument is an integer C.
Fourth argument is an integer array D.
Fifth argument is an integer array E.
Sixth argument is an integer array F.
Seventh argument is an integer array G.
Eight argument is an integer array H.



Output Format

Return an integer array of size C, for each query denoting the shortest distance between the given two vertices.
If the two vertices are not connected then output -1.



Example Input

Input 1:

 A = 4
 B = 6
 C = 2
 D = [1, 2, 3, 2, 4, 3]
 E = [2, 3, 4, 4, 1, 1]
 F = [4, 1, 1, 1, 1, 1]
 G = [1, 1]
 H = [2, 3]
Input 2:

 A = 3
 B = 3
 C = 2
 D = [1, 2, 1]
 E = [2, 3, 3]
 F = [3, 1, 1]
 G = [2, 1]
 H = [3, 2]


Example Output

Output 1:

 [2, 1]
Output 2:

 [1, 2]


Example Explanation

Explanation 1:

 Distance between (1,2) will 2 if we take path 1->4->2.
 Distance between (1,3) will 1 if we take path 1->3.
Explanation 2:

 Distance between (2,3) will 1 if we take path 1->3.
 Distance between (1,2) will 2 if we take path 1->3->2. */

import java.util.Arrays;

public class hw_q1_Sheldon_and_Pair_of_Cities {
    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {

        // I am using 0 based indexing here
        int arr[][] = new int[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = arr[j][i] = 1000001;
                }
            }
        }

        // initialize 2d array with initial weights - fill distance of nodes with direct
        // edge between them
        for (int i = 0; i < B; i++) {
            int u = D[i] - 1;
            int v = E[i] - 1;
            int wt = F[i];
            // take minimum of out of current element and weight
            arr[u][v] = Math.min(arr[u][v], wt);
            arr[v][u] = Math.min(arr[v][u], wt);
        }

        // Apply Floyd Warshall's Algorithm
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    arr[j][i] = Math.min(arr[j][i], arr[j][k] + arr[k][i]);
                }
            }
        }

        // now for C queries, find the shortest distance between nodes
        int[] answer = new int[C];
        for (int i = 0; i < C; i++) {
            int src = G[i] - 1;
            int tgt = H[i] - 1;
            if (arr[src][tgt] == 1000001) {
                answer[i] = -1;
            } else {
                answer[i] = arr[src][tgt];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        hw_q1_Sheldon_and_Pair_of_Cities t1 = new hw_q1_Sheldon_and_Pair_of_Cities();
        int A, B, C;
        int[] D, E, F, G, H;

        {
            A = 4;
            B = 6;
            C = 2;
            D = new int[] { 1, 2, 3, 2, 4, 3 };
            E = new int[] { 2, 3, 4, 4, 1, 1 };
            F = new int[] { 4, 1, 1, 1, 1, 1 };
            G = new int[] { 1, 1 };
            H = new int[] { 2, 3 };
            int[] out = t1.solve(A, B, C, D, E, F, G, H);
            ArrayUtils.printArray(out);
        }
        {
            A = 15;
            B = 18;
            C = 29;
            D = new int[] { 11, 2, 2, 6, 2, 8, 9, 3, 14, 15, 4, 14, 8, 7, 8, 6, 2, 12 };
            E = new int[] { 2, 1, 1, 2, 1, 1, 7, 3, 2, 13, 2, 1, 6, 1, 7, 1, 2, 10 };
            F = new int[] { 8337, 6651, 29, 7765, 3428, 5213, 6431, 2864, 3137, 4024,
                    8169, 5013, 7375, 3786, 4326,
                    6415, 8982, 6864 };
            G = new int[] { 6, 2, 1, 15, 12, 2, 14, 10, 13, 15, 15, 4, 8, 7, 9, 4, 15,
                    13, 12, 5, 2, 10, 1, 11, 14, 7,
                    3, 13, 12 };
            H = new int[] { 5, 2, 15, 13, 6, 2, 8, 6, 3, 13, 15, 3, 1, 1, 4, 4, 5, 8, 1,
                    3, 1, 10, 15, 9, 2, 1, 1, 10,
                    2 };
            int[] out = t1.solve(A, B, C, D, E, F, G, H);
            ArrayUtils.printArray(out);
        }
    }
}
