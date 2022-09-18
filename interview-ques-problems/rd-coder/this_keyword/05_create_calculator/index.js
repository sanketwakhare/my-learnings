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