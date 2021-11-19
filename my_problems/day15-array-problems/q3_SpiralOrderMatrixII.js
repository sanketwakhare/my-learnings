/**
 * Spiral Order Matrix II
Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is integer A

Output Format
Return a 2-D matrix which consists of the elements in spiral order.

Example Input
Input 1:
1
Input 2:
2

Example Output
Output 1:
[ [1] ]
Output 2:
[ [1, 2], [4, 3] ]

Example Explanation
Explanation 1:
 
Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
 */

const generateSpiralMatrix = (A) => {
    let N = A;
    let M = A;
    let resultMatrix = [];

    // initialize Square Matrix A
    for (let i = 0; i < N; i++) {
        let row = [];
        for (let j = 0; j < N; j++) {
            row.push(0);
        }
        resultMatrix.push(row);
    }

    let element = 1;
    let i = 0;
    let j = 0;
    while (N > 1 && M > 1) {
        for (let k = 1; k <= M - 1; k++) {
            // print row
            resultMatrix[i][j] = element++;
            j++;
        }

        for (let k = 1; k <= N - 1; k++) {
            // print column
            resultMatrix[i][j] = element++;
            i++;
        }

        for (let k = 1; k <= M - 1; k++) {
            // print row
            resultMatrix[i][j] = element++;
            j--;
        }

        for (let k = 1; k <= N - 1; k++) {
            // print column
            resultMatrix[i][j] = element++;
            i--;
        }

        N = N - 2;
        M = M - 2;
        i++;
        j++;

    }

    if (M === 0 || N === 0) {
        // everything is printed
        console.log(resultMatrix);
        return resultMatrix;
    }

    // edge conditions to print entire row/column when N === 1 or M === 1
    if (M === 1 || N === 1) {
        if (N > 1) {
            // print entire column
            for (let k = 1; k <= N; k++) {
                resultMatrix[i][j] = element++;
                i++;
            }
        } else {
            // print entire row
            for (let k = 1; k <= M; k++) {
                resultMatrix[i][j] = element++;
                j++;
            }
        }
    }

    console.log(resultMatrix);
    return resultMatrix;
}

generateSpiralMatrix(1);
generateSpiralMatrix(4);
generateSpiralMatrix(2);
generateSpiralMatrix(3);
generateSpiralMatrix(7);
generateSpiralMatrix(10);
