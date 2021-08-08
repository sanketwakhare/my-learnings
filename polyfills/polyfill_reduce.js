const input = [4, 20, 3, 5, 6, 2];

const output = input.reduce(function (max, current) {
  if (current > max) {
    max = current;
  }
  return max;
}, 0);

console.log(output);

// Polyfill for reduce functions
Array.prototype.myReduce = function (callback, initialValue) {
  let output = initialValue;
  for (let i = 0; i < this.length; i++) {
    if (output === undefined) {
      output = 0;
    }
    output = callback(output, this[i]);
  }
  return output;
};

const output2 = input.myReduce(function (max, current) {
  if (current > max) {
    max = current;
  }
  return max;
});

console.log(output2);

const out = input.myReduce((acc, curr) => {
  return acc + curr;
});

console.log(out);
