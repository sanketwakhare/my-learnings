console.log(sum2(3, 40));

function sum2(a, b) {
  return a + b;
}

const sum = function (x, y) {
  return x + y;
};

const callSumAfter2sec = function (a) {
  // let ctx = this;
  // let a = args[0];
  // let b = args[1];
  return function (b) {
    return sum(a, b);
  };
};

console.log(callSumAfter2sec(3)(4));

const callA2 = (x) => {
  return function (y) {
    return sum(x, y);
  };
};
