/* Assign Mice to Holes - Greedy approach */

//param A : array of integers
//param B : array of integers
//return an integer
const mice = function (A, B) {
    A.sort((a, b) => Number(a) - Number(b));
    B.sort((a, b) => Number(a) - Number(b));
    let time = 0;
    for (let i = 0; i < A.length; i++) {
        time = Math.max(time, Math.abs(A[i] - B[i]));
    }
    return time;
}

let answer;
answer = mice([-49, 58, 72, -78, 9, 65, -42, -3], [30, -13, -70, 58, -34, 79, -36, 27]); // 28
console.log(answer);

answer = mice([-4, 2, 3], [0, -2, 4]); //2
console.log(answer);
