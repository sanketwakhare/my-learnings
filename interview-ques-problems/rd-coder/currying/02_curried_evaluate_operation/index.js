// Evaluate Operation - Currying

// evaluate("sum")(4)(2); // 6
// evaluate("multiply")(4)(2); // 8
// evaluate("divide")(4)(2); // 2
// evaluate("subtract")(4)(2); // 2

const evaluate = function (operation) {
    return function (a) {
        return function (b) {
            switch (operation) {
                case "sum":
                    return a + b;
                case "multiply":
                    return a * b;
                case "divide":
                    return a / b;
                case "subtract":
                    return a - b;
            }
        }
    }
}
const sum = evaluate("sum");
const multiply = evaluate("multiply");
const divide = evaluate("divide");
const subtract = evaluate("subtract");

console.log(sum(4)(2)); // 6
console.log(multiply(4)(2)); // 8
console.log(divide(10)(2)); // 5
console.log(subtract(4)(2)); // 2

console.log(sum(4)(multiply(4)(3))); // 16