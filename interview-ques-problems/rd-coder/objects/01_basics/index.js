// ------------IIFE coding example--------------------
// IIFE
const func = (function (a) {
    delete a; // delete cannot delete local variable
    return a;
})(5);

console.log(func); // 5

// -------------delete, store and get object properties -----------

const user = {
    name: 'John Doe',
    age: 25,
    "roll number": 4
};

console.log(user);
delete user.age; // delete age
console.log(user);

console.log(user["roll number"]);
console.log(user["name"]);


// ------------Store and Access Dynamic property--------------------

const propName = 'hobby';
const propValue = 'cycling';

user[propName] = propValue;

console.log(user); // { name: 'John Doe', 'roll number': 4, hobby: 'cycling' }

// ------------Iterate over objects--------------------

for (let propName in user) {
    console.log(propName, user[propName]);
}

// ------------ output based questions q1 ------------------

const obj = {
    a: "one",
    b: "two",
    a: "three"
}
console.log(obj); // { a: 'three', b: 'two' }

// ------------ output based questions q2 ------------------
// create function which multiplies every numeric property by x

const sampleObj = {
    name: 'John',
    age: 20,
    rollNumber: 100,
    country: 'India'
}

const multiplyBy = function (obj, x) {
    for (let key in obj) {
        if (typeof obj[key] === 'number')
            obj[key] = obj[key] * x;
    }
}

multiplyBy(sampleObj, 5);
console.log(sampleObj);  // { name: 'John', age: 100, rollNumber: 500, country: 'India' }

// ------------ output based questions q3 ------------------
// What is output?
const a = {};
const b = { key: "b" };
const c = { key: "c" };
a[b] = 100;
a[c] = 200;

console.log(a[b]); // 200

// as key is not String here, the key is set to this "[object Object]"
// and hence 100 will be replaced by 200 as key will be same


// ------------ output based questions q4 ------------------
// difference between JSON.stringify and JSON.parse
const userString = JSON.stringify(user);
console.log(`string format:  + ${userString}`); // string format:  + {"name":"John Doe","roll number":4,"hobby":"cycling"}
console.log(JSON.parse(userString)); // { name: 'John Doe', 'roll number': 4, hobby: 'cycling' }

// can be used to store data in localStorage

// ------------ output based questions q5 ------------------
// spread operator over string
console.log([..."apples"]); // [ 'a', 'p', 'p', 'l', 'e', 's' ]

// ------------ output based questions q6 ------------------
// spread properties of one object into another object's properties
const user1 = { name: 'John', age: 25 };
const admin1 = { admin: true, ...user1 }

console.log(user1, admin1); // { name: 'John', age: 25 } { admin: true, name: 'John', age: 25 }

// ------------ output based questions q7 ------------------
// JSON.stringify only given properties
const settings = {
    name: 'John',
    age: 25,
    country: 'India'
};
console.log(JSON.stringify(settings, ["age", "country"])); // {"age":25,"country":"India"}


// ------------ output based questions q8 ------------------

// var radius = 5; this goes to global scope directly
// let radius = 5; this does not go to window object
const shape = {
    radius: 10,
    diameter() {
        // this refers to the shape object
        return this.radius * 2;
    },
    perimeter: () => {
        // this refers to the window object
        return 2 * Math.PI * this.radius // NaN
    }
}
console.log(shape.diameter()); // 20
console.log(shape.perimeter()); // NaN

// ------------ output based questions q9 ------------------
// destructuring and nested destructuring
const newMovie = {
    name: 'movie',
    year: 2022,
    producer: {
        firstName: 'abc',
        lastName: 'def'
    }
};
const { name, year, producer } = newMovie;
console.log(name, year, producer); // movie 2022 { firstName: 'abc', lastName: 'def' }

const { producer: { firstName: customFirstName } } = newMovie;
const { producer: { lastName: customLastName } } = newMovie;
console.log(customFirstName); // abc
console.log(customLastName); // def

// ------------ rest vs spread operators q10------------------------


function add(fruit1, fruit2, ...rest) { // rest is always at the last argument
    return [...rest, fruit1, fruit2]; // spread
}

console.log(add('apple', ...['banana', 'mango', 'pineapple'], 'orange')); // spread

// ------------ Object referencing ----------------

// ------------ output based questions q11 ------------------
console.log({ a: 1 } == { a: 1 }); // false
console.log({ a: 1 } === { a: 1 }); // false


// ------------ output based questions q12 ------------------
// object reference 
let movie = {
    name: "movie",
    year: 2000,
};

let movie2 = movie;
movie2.name = "new movie";
console.log(movie); // { name: 'new movie', year: 2000 }
console.log(movie2); // { name: 'new movie', year: 2000 }


// ------------ output based questions q13 ------------------
// array reference 
let person1 = {
    name: "person"
}

let persons = [person1];

// making person1 reference to null does not change the object
person1 = null;
console.log(persons);
// person1 -> // obj memory location{}
// persons[0] -> // obj memory location{}

// making person1 properties will change the object
person1 = persons[0];
person1.name = 'test';
console.log(persons);

// --------------------------------------------------------------

// ------------ output based questions q14 ------------------
//  default value of argument
const value = { number: 10 };
const mul = (x = { ...value }) => {
    console.log(x.number *= 2);
}
mul(); // 20
mul(); // 20
mul(value); // 20 [value.number will change]
mul(value); // 40
