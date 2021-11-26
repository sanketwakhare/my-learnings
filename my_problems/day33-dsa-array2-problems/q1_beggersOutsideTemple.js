/**
 * There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.

Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.

Example:

Input:
N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

Return: [10, 55, 45, 25, 25]

Explanation:
=> First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]

=> Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]

=> Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 */


/**
 * TC: O(N + Q) => N for generating prefix array + Q for queries
 * SC: O(N for prefix sum array
 * @param {Number} N array size
 * @param {Array} Q 2d array of N Queries where each Query contains [startIndex, endIndex, coins]
 * @returns {Array} final array with coins
 */
const beggersOutsideTemple = (N, Q) => {

    // extract the input

    // initialize the array of size N with value 0
    let A = new Array(N).fill(0);

    // for every query, update the array A
    for (let i = 0; i < Q.length; i++) {
        // 1 based indexing as per input
        const startIndex = Q[i][0];
        const endIndex = Q[i][1];
        const coins = Q[i][2];

        // add coins to startIndex (for 0 based indexing)
        A[startIndex - 1] += coins;

        if (endIndex - 1 < N) {
            // remove coins from endIndex+1 (for 0 based indexing)
            A[endIndex] -= coins;
        }
    }

    // generate prefix sum array and return
    let pf = new Array(N).fill(0);
    pf[0] = A[0];
    for (let i = 1; i < N; i++) {
        pf[i] = pf[i - 1] + A[i];
    }

    console.log(pf);
    return pf;

}

beggersOutsideTemple(5, [[1, 2, 10], [2, 3, 20], [2, 5, 25]]);
beggersOutsideTemple(7, [[3, 5, 10], [2, 4, 20], [1, 4, 25], [5, 7, 5]]);