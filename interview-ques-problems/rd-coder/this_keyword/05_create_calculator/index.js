// create calculator

class Calculator {
    constructor() {
        this.a = 0;
        this.b = 0;
    }

    readValues() {
        this.a = +prompt("a = ", 0);
        this.b = +prompt("b = ", 0);
    }

    add() {
        return this.a + this.b;
    }

    multiply() {
        return this.a * this.b;
    }
}

let calculator = new Calculator();
calculator.readValues();
console.log(calculator.add());
console.log(calculator.multiply());

// ----------------------------------------------
// Q2) implement calculator to support below operations

// const result = calc.add(10).multiply(2).subtract(3).add(8);
// console.log(result.total);

class Calc {
    total = 0;

    constructor() {
        this.total = 0;
    }

    add(num) {
        this.total += num;
        return this;
    }

    subtract(num) {
        this.total -= num;
        return this;
    }

    multiply(num) {
        this.total *= num;
        return this;
    }
}

const result = new Calc().add(10).multiply(2).subtract(3).add(8);
console.log(result.total);
// ----------------------------------------------