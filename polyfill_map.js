const input = [6, 2, 3, 5, 6, 2];

const square = function (element) {
  return element * element;
};
console.log(input.map(square));

// Polyfill for map method
Array.prototype.myMap = function (callback) {
  let output = [];
  for (let i = 0; i < this.length; i++) {
    output.push(callback(this[i]));
  }
  return output;
};

console.log(input.myMap(square));
