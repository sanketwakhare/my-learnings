
const empty = () => 0;
const square = (a) => a * a;
const add = (a, b) => a + b;
const mulThree = (a, b, c) => a * b * c;


console.log(curry(square)(3));
console.log(curry(empty));
console.log(curry(square)(2));
console.log(curry(add)(2, 5));
console.log(curry(mulThree)(2, 5, 3));
