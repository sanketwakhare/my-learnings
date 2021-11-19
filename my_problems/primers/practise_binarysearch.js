const A = [44, 59, 59, 61, 65, 83, 94, 99];
const B = [539, 742];
//expected output: 7 8
// test
let k = 0;
let sum = 0;
let sums = [];
for (let j = 0; j < A.length; j++) {
  sum = sum + A[j];
  sums.push(sum);
}

sums.forEach((ele) => console.log(ele));

for (let index = 0; index < B.length; index++) {
  const query = B[index];
  const end = sums.length;
  const start = 0;
  let count = findIndex(sums, start, end, query);
  console.log(count);
}

function findIndex(sums, start, end, query) {
  const mid = start + parseInt((end - start) / 2);
  if (start >= end) {
    return mid;
  }

  if (sums[mid] === query) {
    return mid;
  } else if (query < sums[mid]) {
    return findIndex(sums, start, mid, query);
  } else if (query > sums[mid]) {
    return findIndex(sums, mid + 1, end, query);
  }
}


