const square = function (number) {
    function map() {
        return 0;
    }
    map();
    return number * number;
}

console.log(square(3));

function map(f, a) {
    const result = new Array(a.length);
    for (let i = 0; i < a.length; i++) {
        result[i] = f(a[i]);
    }
    return result;
}

console.log(map(square, [2, 4, 3, 6, 5]));

console.log(Object.getPrototypeOf(square));

console.log(cube(5)); // 25

// hoisted function - called as function declaration
function cube(n) {
    return n * n * n;
}


const foo = function bar() {
    // statements go here
    console.log('bar called', arguments.callee);
    console.log('bar called', bar);
    console.log('bar called', foo);
};
foo();

function addSquares(a, b) {
    var defaultValue = 1;
    function square(x) {
        // var defaultValue = 5; // closure will not be create in this case
        console.log('default value', defaultValue);
        return x * x;
    }
    return square(a) + square(b);
}

console.log(addSquares(4, 5));

var defaultValue = 10;

function sum(a) {
    return function (b) {
        console.log(arguments);
        if (arguments.length === 1) {
            return sum(a + b);
        } else if (arguments.length > 1) {
            let addition = 0;
            for (let i = 0; i < arguments.length; i++) {
                addition += arguments[i];
            }
            return sum(a + addition);
        }
        return a;
    }
}

const curriedSum = sum(3)(4)(5, 6, 3)(2, 2)(4)();
console.log(curriedSum);

const myArray = ["1", "2", "3", "4", "5"];
myArray.splice(1, 3, "a", "b", "c", "d");
// myArray is now ["1", "a", "b", "c", "d", "5"]
// This code started at index one (or where the "2" was),
// removed 3 elements there, and then inserted all consecutive
// elements in its place.
console.log(myArray);

const a = [10, 20, 30];
const total = a.reduce(
    (accumulator, currentValue) => accumulator + currentValue,
    0,
);
console.log(total); // 60

function f() {
    console.log('function called');
}

function f1() {
    console.log('f1');
}

function f2() {
    console.log('f2');
}

function fn(f, f1, f2) {
    console.log("fn called");
}

new Promise((resolve, reject) => {
    console.log("Initial");

    resolve();
})
    .then(() => {
        throw new Error("Something failed");
        console.log("Do this");
    })
    .catch(() => {
        console.error("Do that");
    })
    .then(() => {
        console.log("Do this, no matter what happened before");
    });

