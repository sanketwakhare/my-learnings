/* Number of Squareful Arrays */

/* check for combinations where the sum of each adjacent elements of array is perfect square  */
const solve = function (A) {

    let result = [];
    backtrack(A, 0, result);
    // eliminate duplicates
    result = Array.from(new Set(result.map(JSON.stringify)), JSON.parse);
    console.log(result);
    return result.length;

    function backtrack(A, index, result) {

        // if only single element is present in array
        if (A.length === 1) {
            if (isPerfectSquare(A[0])) {
                result.push([...A]);
            }
            return;
        }

        // add valid combination
        if (A.length === index) {
            result.push([...A]);
            return;
        }

        for (let i = index; i < A.length; i++) {
            swap(A, index, i);
            if (index === 0) {
                // edge case
                backtrack(A, index + 1, result);
            } else {
                const sum = A[index] + A[index - 1];
                // if sum of previous and current element is perfect square
                if (isPerfectSquare(sum)) {
                    backtrack(A, index + 1, result);
                }
            }
            swap(A, index, i);
        }
    }

    // swap index i and index j
    function swap(A, i, j) {
        let temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // check if n is perfect square
    function isPerfectSquare(n) {
        const sqrt = Math.sqrt(n);
        return Math.floor(sqrt) === Math.ceil(sqrt);
    }
}

console.log(solve([2, 2, 2]));
console.log(solve([1, 17, 8]));
console.log(solve([5]));
console.log(solve([100]));