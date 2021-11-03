
// curried sum Optimization

const sum = (a) => {
    return function (b) {
        return a + b;
    }
}
const ans = sum(40)(5);
console.log(ans);

const array = [1, 2, 3, 4, 5, 6];
// memoization
let cache = [];
for (let i = 0; i < array.length - 1; i++) {
    let ans = 0;
    let temp1 = array[i];
    let temp2 = array[i + 1];
    if (cache[array[i]]) {
        // 
        temp1 = cache[array[i]];
        cache[array[i + 1]] = sum(array[i + 1]);
        console.log(temp1(array[i + 1]));
    } else {
        cache[array[i]] = sum(array[i]);
        cache[array[i + 1]] = sum(array[i + 1]);
        temp2 = cache[array[i + 1]];
        console.log(temp2(array[i]));
    }
}