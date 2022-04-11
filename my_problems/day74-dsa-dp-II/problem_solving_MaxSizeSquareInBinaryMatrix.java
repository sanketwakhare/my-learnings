/* Find Maximum size of square matrix in binary matrix formed by only 1s*/
public class problem_solving_MaxSizeSquareInBinaryMatrix {

    public int solve(int[][] A) {

        int N = A.length;
        int M = A[0].length;
        int dp[][] = new int[N][M];

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (i == N - 1 || j == M - 1) {
                    dp[i][j] = A[i][j];
                } else {
                    if (A[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i + 1][j + 1]) + 1;
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println("answer: " + answer);
        return 0;
    }

    public static void main(String[] args) {

        problem_solving_MaxSizeSquareInBinaryMatrix t1 = new problem_solving_MaxSizeSquareInBinaryMatrix();

        int[][] A = new int[][] {
                { 1, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 0 } }; // 2
        t1.solve(A);

        A = new int[][] {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 } }; // 3
        t1.solve(A);

        A = new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } }; // 1
        t1.solve(A);
    }
}
