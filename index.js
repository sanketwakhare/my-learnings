// Playground
const test = (A) => {
  // find second largest element from array
  let largest = 0;
  let secondLargest = 0;

  A.forEach((ele) => {
    if (ele > largest) {
      if (largest !== 0) {
        secondLargest = largest;
      }
      largest = ele;
    } else if (ele > secondLargest && ele < largest) {
      secondLargest = ele;
    }
  });

  console.log(secondLargest);
};

test([1, 2, 44, 3]);
test([2, 6, 4]);
test([927, 707, 374, 394, 279, 799, 878, 937, 431, 112]);
