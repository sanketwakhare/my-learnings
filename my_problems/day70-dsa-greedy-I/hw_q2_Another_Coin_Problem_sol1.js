//param A : integer
//return an integer
const solve = function (A) {
    let coins = 0;
    while (A > 0) {
        let power = getClosestPower(A);
        let maxPow = Math.pow(5, power);
        coins += Math.floor(A / maxPow);
        A = A % maxPow;
    }
    return coins;
}

function getClosestPower(A) {
    return Math.floor(getBaseLog(5, A));
}

function getBaseLog(x, y) {
    return Math.log(y) / Math.log(x);
}

console.log(solve(47));
console.log(solve(9));