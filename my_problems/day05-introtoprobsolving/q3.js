const test = (A) => {
  // find max even
  // find min odd
  let maxEven = 0;
  let minOdd = 0;

  A.forEach((ele) => {
    if (ele % 2 === 0) {
      // even
      if (ele > maxEven || maxEven === 0) {
        maxEven = ele;
      }
    } else {
      //odd
      if (ele < minOdd || minOdd === 0) {
        minOdd = ele;
      }
    }
  });
  console.log(maxEven - minOdd);
  return maxEven - minOdd;
};

// test([0, 2, 9]);
// test([5, 17, 100, 1]);
test([-15, -45, 43, 23, -63, 69, 35, 19, 37, -52]);
