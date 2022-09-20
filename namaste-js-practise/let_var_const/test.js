function xyz() {
  console.log(x, "xyz called");
}
xyz();
var x = 4;
let y = 6;
const z = 8;

xyz();

function abc() {
  let p = 44;
  return function () {
    console.log(x, y, p);
  };
}
abc()();

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
console.log(callA2(55));

// swap two elements using destructuring
let a = 10;
let b = 20;
console.log(a, b);
[a, b] = [b, a];
console.log(a, b);