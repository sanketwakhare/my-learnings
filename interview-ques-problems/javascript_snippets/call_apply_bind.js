const arr = [4, 5, 7, 105, 2, 3, 1, 9, 8, 44, 66, 22, 88, 77, 33, 99];
console.log(Math.max(...arr));

console.log(Math.max.call(null, ...arr));
console.log(Math.max.apply(null, arr));

// swap using destructuring

let a = 10;
let b = 20;
[a, b] = [b, a];
console.log('a =', a);
console.log('b =',b);