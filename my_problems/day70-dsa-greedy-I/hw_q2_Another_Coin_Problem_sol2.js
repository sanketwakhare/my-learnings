//param A : integer
//return an integer
const solve = function (A) {
    let coins = 0;
    while(A > 0) {
        coins += A % 5;
        A =  Math.floor(A / 5);
    }
    return coins;
}

console.log(solve(47));
console.log(solve(9));