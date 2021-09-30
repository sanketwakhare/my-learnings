/**
 * bookmark-empty
Beggars Outside Temple
There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.
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

const findMoneyOfEachBeggar = (N, Q) => {
    // N - no of Beggars
    // Q - array of queries which each query in form of [L, R, x]

    // create initial array of size N with all elements as 0
    // initially pots are empty
    let A = [];
    let i = 0;
    while (i < N) {
        A.push(0);
        i++;
    }

    // iterate each query and update array A with x
    let noOfQueries = Q.length;
    i = 0;
    while (noOfQueries--) {
        const query = Q[i];
        const L = query[0];
        const R = query[1];
        const x = query[2];

        A[L - 1] += x;
        if (R - 1 < N - 1) {
            A[R - 1 + 1] -= x;
        }
        i++;
    }

    // construct the prefix sum array using updated array
    let pf = [];
    pf.push(A[0]);
    // console.log(pf[0]);
    for (i = 1; i < N; i++) {
        valueAtI = pf[pf.length - 1] + A[i];
        pf.push(valueAtI);
        // console.log(valueAtI);
    }

    return pf;

}

console.log(findMoneyOfEachBeggar(5, [[1, 2, 10], [2, 3, 20], [2, 5, 25]]));