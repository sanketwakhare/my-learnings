const generateMatrix = function (A) {

    let N = A;
    let M = A;
    let spiralMatrix = [];
    for (let i = 0; i < N; i++) {
        let row = [];
        for (let j = 0; j < M; j++) {
            row.push(0);
        }
        spiralMatrix.push(row);
    }

    count = 1;
    let i = 0;
    let j = 0;
    while (N > 1 && M > 1) {
        // traverse column M-1 steps
        for (let k = 1; k <= M - 1; k++) {
            spiralMatrix[i][j] = count++;
            j++;
        }

        // traverse rows N-1 steps
        for (let k = 1; k <= N - 1; k++) {
            spiralMatrix[i][j] = count++;
            i++;
        }

        // traverse columns M-1 steps
        for (let k = 1; k <= M - 1; k++) {
            spiralMatrix[i][j] = count++;
            j--;
        }

        // traverse rows N-1 steps
        for (let k = 1; k <= N - 1; k++) {
            spiralMatrix[i][j] = count++;
            i--;
        }

        M = M - 2;
        N = N - 2;
        i++;
        j++;
    }

    if (N === 0 || M === 0) {
        return spiralMatrix;
    }

    if (N === 1 || M === 1) {
        if (N > 1) {
            // print entire column
            for (let k = 1; k <= N; k++) {
                spiralMatrix[i][j] = count++;
                i++;
            }
        } else {
            // print entire row
            for (let k = 1; k <= M; k++) {
                spiralMatrix[i][j] = count++;
                j++;
            }
        }
    }

    return spiralMatrix;
}