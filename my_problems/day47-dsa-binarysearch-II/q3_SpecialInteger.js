/**
 * Special Integer
 */
const solve = (A, B) => {

    // find search space
    let left = 0;
    let right = A.length;
    let ans;

    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (check(A, B, mid)) {
            ans = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return ans;
}

const check = (A, B, mid) => {

    // find sum of first window of size mid
    let sum = 0;
    for (let i = 0; i < mid; i++) {
        sum += A[i];
    }
    // if sum is > target, return false
    if (sum > B) return false;

    // check for every subarray/window
    let n = A.length;
    for (let i = 1; i < n - mid + 1; i++) {
        sum -= A[i - 1];
        sum += A[i + mid - 1];
        // if sum is > target, return false
        if (sum > B) return false;
    }
    return true;
}

console.log(solve([1, 2, 3, 4, 5, 100], 10));
console.log(solve([1, 2, 3, 4, 5], 10));
console.log(solve([5, 17, 100, 11], 130));