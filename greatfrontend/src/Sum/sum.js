/**
 * Implement a sum function that accepts a number and allows for repeated calling with more numbers. Calling the function without an argument will sum up all the arguments thus far and return the total.
 */

// export default function sum(x) {
//   return (y) => {
//     if (y !== undefined) return sum(x + y);
//     return x;
//   };
// }

const sum = (x) => {
  return (y) => {
    if (y !== undefined) return sum(x + y);
    return x;
  };
};

export default sum;
