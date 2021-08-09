const inputArr = [20, 3, 4, 5, 1];

console.log(inputArr);

let res = inputArr.every(function (ele) {
  return ele < 10;
});

console.log(res);

inputArr.forEach(function (ele) {
  console.log(ele);
});

res = inputArr.some(function (ele) {
  return ele < 6;
});
console.log(res);
