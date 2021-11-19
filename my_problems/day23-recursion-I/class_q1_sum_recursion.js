/**
 * For a given N, find sum from 1 to N
 */
const sum = (N) => {
    // base condition
    if (N === 0) {
        return 0;
    }
    // add N to final sum and return
    return N + sum(N - 1);
}

console.log(sum(5));
console.log(sum(15));
console.log(sum(10));
