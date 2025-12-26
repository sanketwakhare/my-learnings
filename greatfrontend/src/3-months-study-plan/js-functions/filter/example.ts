// run this npx tsx <file-path>
// e.g.: npx tsx greatfrontend/src/3-months-study-plan/js-functions/filter/example.ts

import "./array-filter.ts";

const user = { minAge: 18 };
const people = [
  { name: "Alice", age: 25 },
  { name: "Bob", age: 17 },
];

const adults = people.myFilter(function (this: any, person) {
  return person.age > this.minAge; // 'this' refers to the 'user' object
}, user);

console.log(adults); // [{ name: 'Alice', age: 25 }]
