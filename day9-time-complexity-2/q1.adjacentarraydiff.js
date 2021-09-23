const adjacentArrayDiff = (A) => {
  let output = [];
  for (let i = 0; i < A.length - 1; i++) {
    output.push(A[i + 1] - A[i]);
  }
  console.log(output);
  return output;
};

adjacentArrayDiff([6, 2, 4, 4, 3]);
adjacentArrayDiff([2]);
