const test = (A, B) => {
  let sumArray = [];
  // sum array
  let sum = A.reduce((sum, x) => {
    sum = sum + x;
    sumArray.push(sum);
    return sum;
  }, 0);

  // console.log(sumArray);

  const output = B.map((element) => {
    return searchItemIndex(sumArray, 0, sumArray.length - 1, element);
  });

  console.log(output);
  return output;
};

const searchItemIndex = (inputArray, start, end, find) => {
  let mid = Math.floor((start + end) / 2);
  if (start > end) {
    return mid + 1;
  }
  if (find === inputArray[mid]) {
    return mid;
  } else if (find < inputArray[mid]) {
    // search in left subtree
    return searchItemIndex(inputArray, start, mid - 1, find);
  } else if (find > inputArray[mid]) {
    // search in right subtree
    return searchItemIndex(inputArray, mid + 1, end, find);
  }
};

test([3, 4, 4, 6], [20, 4, 10, 2]);
