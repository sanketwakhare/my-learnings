// Polyfill for forEach

const arr = [3, 4, 2, 6, 5, 1, 9, 7, 8];

arr.forEach(function (x, index) {
    console.log(x, index);
});

// --------------------Polyfill for forEach-------------------------
console.log('.................');
Array.prototype.myForEach = function (callback) {
    for (let i = 0; i < this.length; i++) {
        callback(this[i], i, this);
    }
};

arr.myForEach(function (x, index) { console.log(x, index) });