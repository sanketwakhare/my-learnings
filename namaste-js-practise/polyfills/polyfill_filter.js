const input = [4, 2, 3, 5, 6, 2];

const greaterThan3 = function (element) {
  return element > 3 ? true : false;
};

// Polyfill for filter method
Array.prototype.myFilter = function (callback) {
  let output = [];
  for (let i = 0; i < this.length; i++) {
    if (callback(this[i])) {
      output.push(this[i]);
    }
  }
  return output;
};
console.log(input.myFilter(greaterThan3));
