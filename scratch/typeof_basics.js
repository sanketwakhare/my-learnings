let value = true;
console.log(typeof value);

value = String(value);
console.log(typeof value);

console.log(typeof {});
console.log(typeof []);
console.log(typeof true);

const arr = [1, 2, 3, 4, 5];
console.log(typeof arr);

console.log(typeof { 3.4: decodeURI });

console.log(Number("4"));
console.log(Number("4Test"));

console.log(Number("43" / "3"));

for (let i = 0; 0; i++) {
  console.log("inside for");
}
console.log("test");
