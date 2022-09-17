// Polyfill for filter

const arr = [4, 3, 5, 7, 6, 8];

// return true if num is even
// else return false
const even = (num) => {
    return num % 2 === 0;
}

// get even numbers
console.log(arr.filter(even));

// -------------Polyfill for filter-----------------

Array.prototype.myFilter = function (cb) {
    let result = [];
    for (let i = 0; i < this.length; i++) {
        if (cb(this[i], i, this)) {
            result.push(this[i]);
        }
    }
    return result;
};

console.log(arr.myFilter(even));