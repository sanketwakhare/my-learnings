// Pattern Printing -1

const N = 3;

let outerArray = [];

for (let i = 1; i <= N; i++) {
  let innerArray = [];
  for (let j = 1; j <= i; j++) {
    // console.log(j);
    innerArray.push(j);
  }
  for (let j = i + 1; j <= N; j++) {
    // console.log(0);
    innerArray.push(0);
  }
  outerArray.push(innerArray);
}

return outerArray;

console.log(outerArray);
