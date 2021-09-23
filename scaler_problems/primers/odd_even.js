const A = [2, 1, 6, 4];
function solve() {
  let count = 0;
  A.forEach((ele, index) => {
    let prefixEven = 0;
    let prefixOdd = 0;
    for (let i = 0; i < index; i++) {
      if (i % 2 === 0) {
        prefixEven = prefixEven + A[i];
      }
      if (i % 2 !== 0) {
        prefixOdd = prefixOdd + A[i];
      }
    }
    let suffixEven = 0;
    let suffixOdd = 0;
    for (let i = index + 1; i < A.length; i++) {
      if (i % 2 === 0) {
        suffixEven = suffixEven + A[i];
      }
      if (i % 2 !== 0) {
        suffixOdd = suffixOdd + A[i];
      }
    }
    let sumEven = prefixEven + suffixOdd;
    let sumOdd = prefixOdd + suffixEven;
    if (sumEven === sumOdd && sumEven !== 0) {
      count++;
    }
  });
  console.log(count);
  return count;
}
solve();
