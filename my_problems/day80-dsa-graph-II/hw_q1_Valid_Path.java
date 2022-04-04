/* Valid Path */

/* Problem Description

There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjacent neighbors and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints
0 <= x , y, R <= 100
1 <= N <= 1000

Center of each circle would lie within the grid


Input Format

1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x coordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y coordinate of ith circle



Output Format
Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).


Example Input

Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:

 x = 1
 y = 1
 N = 1
 R = 1
 A = [1]
 B = [1]

Example Output

Output 1:
 NO
Output 2:
 NO


Example Explanation

Explanation 1:

 There is NO valid path in this case
Explanation 2:

 There is NO valid path in this case */
public class hw_q1_Valid_Path {

    public String solve(int x, int y, int c, int r, int[] A, int[] B) {
        int n = x + 1;
        int m = y + 1;
        int[][] visited = new int[n][m];

        // initialize visited array and mark blocked cells/cells which falls within
        // circle with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < c; k++) {
                    if (Math.sqrt(Math.pow(A[k] - i, 2) + Math.pow(B[k] - j, 2)) <= r) {
                        visited[i][j] = -1;
                    }
                }
            }
        }
        ArrayUtils.print2DArray(visited);

        if (visited[0][0] == -1 || visited[x][y] == -1) {
            return "NO";
        }
        visited[0][0] = 1;
        // apply DFS from source (0,0)
        dfs(0, 0, n, m, visited);

        return visited[x][y] == 1 ? "YES" : "NO";
    }

    // dfs traversal
    private void dfs(int i, int j, int n, int m, int[][] visited) {

        int[] rows = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] cols = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // if current coordinate is unvisited
        if (visited[i][j] == 0) {
            visited[i][j] = 1;
        }

        // check for all possible directions
        for (int z = 0; z < rows.length; z++) {
            int new_i = i + rows[z];
            int new_j = j + cols[z];
            if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m && visited[new_i][new_j] == 0) {
                dfs(new_i, new_j, n, m, visited);
            }
        }
    }

    public static void main(String[] args) {
        hw_q1_Valid_Path t1 = new hw_q1_Valid_Path();
        int x, y, n, r;
        int[] A, B;

        // test case 1
        x = 2;
        y = 3;
        n = 1;
        r = 1;
        A = new int[] { 2 };
        B = new int[] { 1 };
        System.out.println(t1.solve(x, y, n, r, A, B));

        // test case 2
        x = 2;
        y = 3;
        n = 1;
        r = 1;
        A = new int[] { 2 };
        B = new int[] { 2 };
        System.out.println(t1.solve(x, y, n, r, A, B));

    }
}
