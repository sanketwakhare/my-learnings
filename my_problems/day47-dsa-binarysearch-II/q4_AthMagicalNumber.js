/**
 * Ath Magical number
 */

const solve = (A, B, C) => {
    let lcmValue = lcm(B, C);
    let start = Math.min(B, C);
    let end = start * A;
    let ans = start;
    let m = 1000000007;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        let count = getCount(mid, B, C, lcmValue);
        if (count === A) {
            ans = mid % m;
            end = mid - 1;
        } else if (count > A) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return ans;
}

const getCount = (n, a, b, lcmValue) => {
    return Math.floor(n / a) + Math.floor(n / b) - Math.floor(n / lcmValue);
}

const lcm = (a, b) => {
    let multiplication = a * b;
    return multiplication / gcd(a, b);
}

const gcd = (a, b) => {

    // make sure a is always min out of 2
    if (a > b) {
        let temp = a;
        a = b;
        b = temp;
    }

    if (a === 0) {
        return b;
    }
    if (a === 1) {
        return 1;
    }

    return gcd(a, b % a);
}

console.log(solve(12, 10, 13));
console.log(solve(19, 11, 13));
console.log(solve(807414236, 3788, 38141));