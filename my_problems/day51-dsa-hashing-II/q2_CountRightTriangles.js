/* Count Right Triangles */

/**
 * Iterations: 2N
 * TC: O(N)
 * SC: 2N => O(N)
 */

module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return an integer
    solve: function(A, B) {

        let xMap = new Map();
        let yMap = new Map();
        // store x and y coordinates in separate hashMap
        for (let i = 0; i < A.length; i++) {
            if (xMap.has(A[i])) {
                xMap.set(A[i], xMap.get(A[i]) + 1);
            } else {
                xMap.set(A[i], 1);
            }
            if (yMap.has(B[i])) {
                yMap.set(B[i], yMap.get(B[i]) + 1);
            } else {
                yMap.set(B[i], 1);
            }
        }

        let count = BigInt(0);
        let p = BigInt(1000000007);
        for (let i = 0; i < A.length; i++) {
            count = ((count % p) + (BigInt(xMap.get(A[i]) - 1) * BigInt(yMap.get(B[i]) - 1) % p)) % p;
        }

        return Number(count);

    }
};