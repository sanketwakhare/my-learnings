//param A : array of array of integers
//param B : array of integers
//param C : array of integers
//param D : array of integers
//param E : array of integers
//return a array of integers
const subMatrixSumQueries = (A, B, C, D, E) => {

    // Idea: Generate prefix sum array of 2d matrix and find sum for each submatrix using formula

    const P = 1000000000 + 7;
    const N = A.length;
    const M = A[0].length;
    // generate prefix sum
    let pf = [];
    // step 1: find row wise sum first
    for (let i = 0; i < N; i++) {
        let row = [];
        for (let j = 0; j < M; j++) {
            if (j > 0) {
                row.push(A[i][j] + row[j - 1]);
            } else {
                row.push(A[i][j]);
            }
        }
        pf.push(row);
    }

    // step 2: find column wise sum on prefix array from step 1
    for (let j = 0; j < M; j++) {
        for (let i = 1; i < N; i++) {
            pf[i][j] = pf[i - 1][j] + pf[i][j];
        }
    }

    // for every query, find sum
    let result = [];

    // length of B,C,D,E represents size of queries
    for (let i = 0; i < B.length; i++) {
        // convert to 1 based indexing
        const a1 = B[i] - 1;
        const b1 = C[i] - 1;
        const a2 = D[i] - 1;
        const b2 = E[i] - 1;

        let sum = pf[a2][b2];
        if (a1 > 0) {
            sum -= pf[a1 - 1][b2];
        }
        if (b1 > 0) {
            sum -= pf[a2][b1 - 1];
        }
        if (a1 > 0 && b1 > 0) {
            sum += pf[a1 - 1][b1 - 1];
        }

        result.push(sum);
    }
    console.log(result);
    return result;
}

subMatrixSumQueries(
    [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ], [1, 2], [1, 2], [2, 3], [2, 3]
);