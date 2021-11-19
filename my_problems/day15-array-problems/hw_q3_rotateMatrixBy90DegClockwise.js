const rotateMatrixBy90DegClockwise = (A) => {
    //take transpose - traverse lowe triangular matrix

    console.log('input', A);
    for (let i = 1; i < A.length; i++) {
        for (let j = 0; j < i; j++) {
            A[i][j] = A[i][j] ^ A[j][i];
            A[j][i] = A[i][j] ^ A[j][i];
            A[i][j] = A[i][j] ^ A[j][i];
        }
    }
    console.log('transpose: ', A);

    //reverse each row elements
    for (let i = 0; i < A.length; i++) {
        // reverse each row
        let start = 0;
        let end = A.length - 1;
        while (start < end) {
            A[i][start] = A[i][end] ^ A[i][start];
            A[i][end] = A[i][end] ^ A[i][start];
            A[i][start] = A[i][end] ^ A[i][start];
            start++;
            end--;
        }
    }

    console.log('90 deg clockwise', A);

    return A;
}

rotateMatrixBy90DegClockwise([
    [1, 2],
    [3, 4]
]);

rotateMatrixBy90DegClockwise([
    [1, 2, 5],
    [-2, 3, 4],
    [3, 6, 9]
]);