// Playground
const test = function (A) {
  // sum of adjacent elements should always be even
  const odds = A.filter((ele) => ele % 2 !== 0);
  const evenCount = A.length - odds.length;
  //   const even = A.filter((ele) => ele % 2 === 0);

  const output = Math.min(odds.length, evenCount);
  console.log(output);
  return output;
};

s([1, 2, 3, 4, 5]);
s([
  33, 82, 75, 4, 52, 74, 79, 46, 18, 73, 1, 83, 46, 94, 44, 86, 40, 1, 46, 24,
  99, 16, 88, 6, 66, 17, 1,
]);
