/* Implement Min Stack using 2 stacks */

class MinStack {
    constructor() {
        // Initialize your variables here
        this.mainStack = [];
        this.minStack = [];
    }


    push = function (e) {
        this.mainStack.push(e);
        if (this.minStack.length === 0) {
            this.minStack.push(e);
        } else {
            if (e < this.minStack[this.minStack.length - 1]) {
                // update min
                this.minStack.push(e);
            } else {
                // do not update min
                this.minStack.push(this.minStack[this.minStack.length - 1]);
            }
        }
    };
    pop = function () {
        // pop element from both stacks and return from mainStack
        if (this.mainStack.length > 0) {
            this.minStack.pop();
            return this.mainStack.pop();
        }
    };

    top = function () {
        // return top
        if (this.mainStack.length === 0) return -1;
        return this.mainStack[this.mainStack.length - 1];
    };

    getMin = function () {
        // return minimum
        if (this.minStack.length === 0) return -1;
        return this.minStack[this.minStack.length - 1];
    };
}

let minStack = new MinStack();
minStack.push(6);
minStack.push(4);
minStack.push(7);
minStack.push(2);

console.log('top', minStack.top());
console.log('min', minStack.getMin());
console.log('pop', minStack.pop());

console.log('top', minStack.top());
console.log('min', minStack.getMin());
console.log('pop', minStack.pop());

console.log('top', minStack.top());
console.log('min', minStack.getMin());
console.log('pop', minStack.pop());
