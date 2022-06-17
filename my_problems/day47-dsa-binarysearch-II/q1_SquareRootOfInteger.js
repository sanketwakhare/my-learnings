const sqrt = function (A) {

    let start = 1;
    let end = A;
    let ans = 0;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        let sqr = mid * mid;
        if (sqr === A) {
            return mid;
        } else if (sqr < A) {
            ans = mid;
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return ans;
}

console.log(sqrt(100));
console.log(sqrt(803820));