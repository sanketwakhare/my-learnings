/* Floor of K */

const findFloorOfK = (A, K) => {

    let start = 0;
    let end = A.length - 1;
    let answer = Number.MIN_SAFE_INTEGER;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid] === K) {
            return A[mid];
        } else if (A[mid] > K) {
            end = mid - 1;
        } else {
            // update possible answer
            answer = A[mid];
            start = mid + 1;
        }
    }
    return answer;
}

console.log(findFloorOfK([1, 3, 5, 6, 7, 10, 23], 9));
console.log(findFloorOfK([1, 3, 5, 6, 20], 5));