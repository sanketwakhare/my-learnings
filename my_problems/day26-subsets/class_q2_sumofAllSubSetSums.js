/* Given array A of length N, find sum of all subset sums*/

/**
 * Subset means we can delete zero or more elements from array from any position and can form subset. order does not matter in subset
 * TC: O(N)
 * Find sum of all subset sums
 * @param {Array} A input array
 */
const sumOfSubsetSums = (A) => {
    // contribution of each element in subset is  2^(N-1) ~ (1 << N - 1)
    const N = A.length;
    let sum = 0;
    for (let i = 0; i < A.length; i++) {
        sum = sum + A[i] * (1 << N - 1);
    }
    console.log(sum);
    return sum;
}

sumOfSubsetSums([4, 3, 6]);