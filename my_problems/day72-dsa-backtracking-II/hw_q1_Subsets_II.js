/* Subsets-II */

//param A : array of integers
//return a array of array of integers
const subsetsWithDup = function (A) {

    A.sort((a, b) => Number(a) - Number(b));
    let temp = [];
    let result = [];
    backtrack(A, 0, temp, result);

    // filter out duplicate subsets
    result = Array.from(new Set(result.map(JSON.stringify)), JSON.parse);
    return result;

    function backtrack(A, index, temp, result) {
        // add subset to result array
        result.push([...temp]);
        for (let k = index; k < A.length; k++) {
            temp.push(A[k]);
            backtrack(A, k + 1, temp, result);
            temp.pop(A[k]);
        }
    }
}

console.log(subsetsWithDup([1, 2, 2]));
console.log(subsetsWithDup([1, 1]));
console.log(subsetsWithDup([1, 2, 4, 4, 2]));