// Playground
const myObject = {
  firstName: "John",
  lastName: "Doe",
  fullName: function () {
    console.log(this.firstName + " " + this.lastName);
  },
};

console.log(myObject.fullName());

const person = {
  fullName: function (city, country) {
    console.log(
      this.firstName + " " + this.lastName + " " + city + " " + country
    );
  },
};

const person1 = {
  firstName: "John",
  lastName: "Doe",
};

const person2 = {
  firstName: "Mary",
  lastName: "Doe",
};

person.fullName.call(person1, "Mumbai", "India");
person.fullName.call(person2, "Pune", "India");

person.fullName.apply(person1, ["Mumbai", "India"]);
person.fullName.apply(person2, ["Pune", "India"]);

const test = person.fullName;

console.log(test.call(person1, "test", "t2", "t3"));
// console.log(Math.max(1, 2, 3));
// console.log(Math.max.apply(undefined, [1, 2, 3]));
// console.log(Math.max.apply("", [1, 2, 3]));
// console.log(Math.max.apply(0, [1, 2, 3]));
// console.log(Math.max.apply(100, [1, 2, 3]));

function outer() {
  let counter = 0;
  return function inner() {
    counter += 1;
    return counter;
  };
}

const counter = outer();

console.log(counter());
console.log(counter());
console.log(counter());
console.log(counter());
