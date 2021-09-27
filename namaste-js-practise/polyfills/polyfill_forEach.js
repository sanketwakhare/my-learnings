const input = [4, 2, 3, 5, 6, 2];

input.forEach((element) => {
  console.log(element + 5);
});

// Polyfill for forEach method
Array.prototype.myForEach = function (callback) {
  for (let i = 0; i < this.length; i++) {
    callback(this[i], i, this);
  }
};

input.myForEach(function (element) {
  console.log(element);
});
