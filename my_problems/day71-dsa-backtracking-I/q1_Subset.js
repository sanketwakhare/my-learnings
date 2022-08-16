/* Generate subset in non descending order */

//param A : array of integers
//return a array of array of integers
const subsets = function (A) {
    A.sort((a, b) => Number(a) - Number(b));
    const temp = [];
    const result = [];
    backtrack(A, 0, temp, result);
    return result;

    function backtrack(A, index, temp, result) {
        const t = [...temp];
        result.push(t);

        for (let k = index; k < A.length; k++) {
            temp.push(A[k]);
            backtrack(A, k + 1, temp, result);
            temp.pop(A[k]);
        }
    }
}

console.log(subsets([1, 2, 3]));
console.log(subsets([1, 2, 5, 8, 7, 3]));

