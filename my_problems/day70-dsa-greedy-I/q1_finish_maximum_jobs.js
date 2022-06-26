/* Finish Maximum Jobs - Activity Selection Problem*/

//param A : array of integers
//param B : array of integers
//return an integer
const solve = function (A, B) {

    // sort the intervals based on end time
    let intervals = [];
    for (let i = 0; i < A.length; i++) {
        intervals.push(new Interval(A[i], B[i]));
    }
    intervals.sort((i1, i2) => i1.end - i2.end);

    let prevEnd = 0;
    let count = 0;
    // iterate and check if current job can be picked
    for (let interval of intervals) {
        // if curretn start time >= previous end time, pick the task
        if (interval.start >= prevEnd) {
            count++;
            prevEnd = interval.end;
        }
    }
    return count;
}

class Interval {
    constructor(start, end) {
        this.start = start;
        this.end = end;
    }
}

let A = [1, 5, 7, 1];
let B = [7, 8, 8, 8];

console.log(solve(A, B)); // 2

A = [8, 12, 1, 3, 4, 6, 13];
B = [11, 14, 5, 4, 5, 6, 19];

console.log(solve(A, B)); // 5