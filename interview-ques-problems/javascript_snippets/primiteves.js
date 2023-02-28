console.log([1, 13, 4, 2].sort());

[1, 3, 4, 2]["sort"]["constructor"](console.log("Boom"));

console.log(typeof (1));
console.log(typeof 1);
console.log({1:'1'}.__proto__);
console.log((1).__proto__);
console.log((1).__proto__.__proto__);
console.log((1).__proto__.__proto__.__proto__);

class Person {}
class Employee extends Person {}
class Developer extends Employee {}
const tom = new Developer();

console.log(Object.getPrototypeOf(tom) === Developer.prototype);
console.log(Object.getPrototypeOf(tom) === Employee.prototype);
console.log(Developer.isPrototypeOf(tom));
console.log(Developer.prototype.isPrototypeOf(tom));
console.log(Employee.prototype.isPrototypeOf(tom));
console.log(Person.prototype.isPrototypeOf(tom));
console.log(Object.prototype.isPrototypeOf(tom));