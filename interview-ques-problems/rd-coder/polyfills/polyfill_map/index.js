// Polyfill for map

const arr = [1, 2, 3, 4, 5];

const square = (num) => {
    return num * num;
}

const result = arr.map(square);
console.log(result);

// Polyfill for map

Array.prototype.myMap = function (cb) {
    let result = [];
    for (let i = 0; i < this.length; i++) {
        let temp = cb(this[i], i, this);
        result.push(temp);
    }
    return result;
}

console.log(arr.myMap(square));
// add 10 to values
console.log(arr.myMap((x) => x + 10));
// add 10 to indexes
console.log(arr.myMap((_, index) => index + 10));