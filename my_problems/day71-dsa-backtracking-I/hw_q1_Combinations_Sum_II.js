/* Combination Sum II */

const combinationSum = function (A, B) {

    // sort the given array
    A.sort((a, b) => Number(a) - Number(b));

    // initialize arrays ans sum
    let result = new Set();
    let temp = [];
    let sum = 0;

    backtrack(A, 0, B, sum, temp, result);

    // eliminate duplicates from all combinations
    return Array.from(result, JSON.parse);

    function backtrack(A, index, B, sum, temp, result) {

        // if sum is matching with target sum
        if (sum === B) {
            result.add(JSON.stringify([...temp]));
            return;
        }

        // as array is sorted, considering next set of elements from array would not give target sum
        if (sum > B) {
            return;
        }

        // consider every possibility
        for (let i = index; i < A.length; i++) {
            // pick A[i]
            sum += A[i];
            temp.push(A[i]);
            backtrack(A, i + 1, B, sum, temp, result);
            // undo operation
            sum -= A[i];
            temp.pop(A[i]);
        }
    }
}

console.log(combinationSum([15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17], 33));
console.log(combinationSum([10, 1, 2, 7, 6, 1, 5], 8));
console.log(combinationSum([2, 1, 3], 3));