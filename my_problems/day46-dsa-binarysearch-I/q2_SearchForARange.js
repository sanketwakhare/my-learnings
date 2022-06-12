/* Search for a Range */

const searchRange = (A, K) => {
    let result = [];
    result.push(firstOccurrenceIndex(A, K));
    result.push(lastOccurrenceIndex(A, K));
    return result;
}

const firstOccurrenceIndex = (A, K) => {
    let start = 0;
    let end = A.length - 1;
    let answer = -1;
    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid] === K) {
            // update possible answer
            answer = mid;
            end = mid - 1;
        } else if (A[mid] < K) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return answer;
}

const lastOccurrenceIndex = (A, K) => {
    let start = 0;
    let end = A.length - 1;
    let answer = -1;
    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid] === K) {
            // update possible answer
            answer = mid;
            start = mid + 1;
        } else if (A[mid] < K) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return answer;
}

console.log(searchRange([2, 4, 4, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 9, 10, 10, 10], 7));
console.log(searchRange([2, 4, 4, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 9, 10, 10, 10], 4));
console.log(searchRange([2, 4, 4, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 9, 10, 10, 10], 14));