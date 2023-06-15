// let sum = function (a) {
//   return function (b) {
//     if (b) {
//       return sum(a + b);
//     }
//     return a;
//   };
// };

function sum(a) {
  return function(b) {
    if(b) {
      return sum(a + b);
    }
    return a;
  }
}

const eighteen = sum(1)(2)(5)(10);
console.log(eighteen(5)());
