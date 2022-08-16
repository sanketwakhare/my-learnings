/* Combination Sum */

/* return all subsets with sum K with repeated numbers in sorted order */

//param A : array of integers
//param B : integer
//return an array of array of integers
const combinationSum = function (A, B) {

    // sort and remove duplicates from array
    A.sort((a, b) => Number(a) - Number(b));
    let set = new Set();
    for (let a of A) {
        set.add(a);
    }
    A = Array.from(set);

    // initialize variables and call backtrack method
    let temp = [];
    let sum = 0;
    let result = [];
    backtrack(A, 0, B, temp, sum, result);
    return result;

    function backtrack(A, index, B, temp, sum, result) {

        if (sum === B) {
            result.push([...temp]);
        }
        if (sum > B) return;

        for (let k = index; k < A.length; k++) {
            sum += A[k];
            temp.push(A[k]);
            backtrack(A, k, B, temp, sum, result);
            sum -= A[k];
            temp.pop(A[k]);
        }
    }
}

console.log(combinationSum([2, 3, 6, 7], 7));
console.log(combinationSum([2, 3], 2));