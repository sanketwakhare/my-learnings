// Polyfill for reduce

const arr = [4, 3, 2, 6, 7, 8, 5, 9, 10, 11, 12, 13, 14, 15];

const totalSum = (prev, curr) => prev + curr;

let sum = arr.reduce(totalSum, 0);
console.log(sum);


// -----------------------Polyfill for reduce------------------------------

Array.prototype.myReduce = function (cb, initialValue) {
    let accumulator = initialValue;
    for (let i = 0; i < this.length; i++) {
        if (!accumulator) accumulator = this[i];
        else accumulator = cb(accumulator, this[i], i, this);
    }
    return accumulator;
}

let mySum = arr.myReduce(totalSum, 0);
console.log(mySum);


console.log(sum / arr.length);
console.log(mySum / arr.length);