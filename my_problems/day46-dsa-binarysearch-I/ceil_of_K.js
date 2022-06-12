/* Ceil of K */

const findCeilOfK = (A, K) => {

    let start = 0;
    let end = A.length - 1;
    let answer = Number.MAX_SAFE_INTEGER;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid] === K) {
            return A[mid];
        } else if (A[mid] > K) {
            // update possible answer
            answer = A[mid];
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return answer;
}

console.log(findCeilOfK([1, 3, 5, 6, 7, 10, 23], 19));
console.log(findCeilOfK([1, 3, 5, 6, 20], 5));