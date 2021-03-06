/*******
 * K Occurrences
Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
He wants to select some trees to replace his broken branches.
But he wants uniformity in his selection of trees.
So he picks only those trees whose heights have frequency K.
He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).
But the sum he ended up getting was huge so he prints it modulo 10^9+7.
In case no such cluster exists, Groot becomes sad and prints -1.

Constraints:
1.   1<=N<=100000
2.   1<=K<=N
3.   0<=H[i]<=10^9

Input: Integers N and K and array of size A
Output: Sum of all numbers in the array that occur exactly K times.

Example:
Input:
N=5 ,K=2 ,A=[1 2 2 3 3]
Output:
5

Explanation:
There are 3 distinct numbers in the array which are 1,2,3.
Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.
 */

const getSumOfKOccurrence = (N, K, A) => {
    // find frequency of each number in hashMap
    let hashMap = new Map();
    for (let i = 0; i < N; i++) {
        if (hashMap.has(A[i])) {
            let currentFrequency = hashMap.get(A[i]);
            hashMap.set(A[i], currentFrequency + 1);
        } else {
            hashMap.set(A[i], 1);
        }
    }

    // store sum of K occurrences
    let sum = 0;
    let ifElementWithKOccurrencesPresent = false;
    const allKeys = hashMap.keys()
    for (let key of allKeys) {
        if (hashMap.get(key) === K) {
            sum = sum + key;
            ifElementWithKOccurrencesPresent = true;
        }
    }
    if (!ifElementWithKOccurrencesPresent) {
        console.log(-1);
        return -1;
    }
    console.log(sum);
    return sum;
}

getSumOfKOccurrence(5, 2, [1, 2, 2, 3, 3]);