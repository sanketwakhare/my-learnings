/**
 * Find Local Minima
 */

const findLocalMinima = (A) => {

    let n = A.length;
    if (n === 1) return A[0];
    if (A[0] < A[1]) return A[0];
    if (A[n - 1] < A[n - 2]) return A[n - 1];

    let start = 1;
    let end = n - 2;
    let answer = A[1];

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
            return A[mid];
        } else if (A[mid - 1] < A[mid]) {
            // update possible answer
            answer = A[mid - 1];
            // move to lesser element
            end = mid - 1;
        } else {
            // update possible answer
            answer = A[mid + 1];
            // move to lesser element
            start = mid + 1;
        }
    }
    return answer;
}

console.log(findLocalMinima([35, 30, 45, 65, 70, 54, 82, 12, 24, 50, 60]));
console.log(findLocalMinima([110, 75, 34, 15, 17, 100, 11, 201]));