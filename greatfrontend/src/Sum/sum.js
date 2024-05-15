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
