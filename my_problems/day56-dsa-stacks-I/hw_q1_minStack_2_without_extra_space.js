/* Min Stack */

/* Implement getMin() using single stack */

class MinStack {

    // Initialize your variables here
    constructor() {
        this.mainStack = [];
        this.min = -1;
    }

    push = (e) => {
        if (this.mainStack.length === 0) {
            this.mainStack.push(e);
            this.min = e;
        } else {
            if (e < this.min) {
                // update min
                let newTop = (2 * e) - this.min;
                this.mainStack.push(newTop);
                this.min = e;
            } else {
                // do not update min
                this.mainStack.push(e);
            }
        }
    };

    pop = () => {
        // pop element from both stacks and return from mainStack
        if (this.mainStack.length > 0) {
            const poppedEle = this.mainStack.pop();
            if (poppedEle < this.min) {
                // update min
                let newMin = (this.min * 2) - poppedEle;
                this.min = newMin;
                return this.min;
            }
            return poppedEle;
        }
    };

    top = () => {
        // return top
        if (this.mainStack.length === 0) return -1;
        if (this.mainStack[this.mainStack.length - 1] < this.min) {
            return this.min;
        }
        return this.mainStack[this.mainStack.length - 1];
    };

    getMin = () => {
        // return minimum
        if (this.mainStack.length === 0) return -1;
        return this.min;
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

console.log('top', minStack.top());
console.log('min', minStack.getMin());
console.log('pop', minStack.pop());
