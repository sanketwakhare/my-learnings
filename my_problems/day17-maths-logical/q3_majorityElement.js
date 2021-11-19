/*******
 * 
Majority Element
Problem Description
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example :
Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.
 * 
 */

/**
 * TC: O(N)
 * Iteration: N+N
 * SC: O(1)
 * @param {Array} A 
 * @returns 1 if majority element is found else return -1
 */
const majorityElement = function (A) {

    // no of bags = 1
    // no of dustbins - 1

    const N = A.length;
    let ele = A[0];
    let freq = 1;

    for (let i = 1; i < N; i++) {
        let x = A[i];
        // if element is already present in bag
        if (x === ele) {
            freq++;
        }
        // if bag is empty
        else if (freq === 0) {
            ele = x;
            freq++;
        } else {
            freq--;
        }
    }

    let count = 0;
    let nByTwo = Math.floor(N / 2);
    for (let i = 0; i < N; i++) {
        if (A[i] === ele) {
            count++;
        }
    }

    if (count > nByTwo) {
        return ele;
    }

    return -1;
}