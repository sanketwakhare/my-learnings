/**
 * Sort the array A in ascending order based on no of factors
 */

/**
 * Find no of factors for a given input integer n
 * @param {Number} n integer
 * @returns 
 */
const countFactors = (n) => {
    let count = 0;
    for (let i = 1; i <= n; i++) {
        if (n % i === 0) {
            count++;
        }
    }
    return count;
}

/**
 * Iteration: N logN + N
 * TC: O(N logN)
 * Custom sort function to sort the array in ascending order based on no of factors
 * @param {Array} A array of integers
 */
const sortBasedOnFactors = (A) => {

    console.log('input array ->', A);
    A.sort(function(a, b) {

        const x = countFactors(a);
        const y = countFactors(b);

        return x - y;

    });
    console.log('sorted array based on no of factors ->', A);

    let factorsArray = new Array(A.length).fill(0);
    for (let i = 0; i < A.length; i++) {
        factorsArray[i] = countFactors(A[i]);
    }
    console.log('no of factors for sorted array ->', factorsArray);

}

sortBasedOnFactors([4, 3, 5, 6, 2, 1, 7, 8, 9, 15, 12, 13, 11]);
sortBasedOnFactors([17, 32, 12, 45, 34, 90, 18, 3, 7]);