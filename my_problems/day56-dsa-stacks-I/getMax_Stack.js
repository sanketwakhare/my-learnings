/* Max Stack */

/* Implement getMax() using single stack */

class GetMax_Stack {

    // Initialize your variables here
    constructor() {
        this.mainStack = [];
        this.max = -1;
    }

    push = (e) => {
        if (this.mainStack.length === 0) {
            this.mainStack.push(e);
            this.max = e;
        } else {
            if (e > this.max) {
                // update max
                let newTop = (2 * e) - this.max;
                this.mainStack.push(newTop);
                this.max = e;
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
            if (poppedEle > this.max) {
                // update max
                let newMin = (this.max * 2) - poppedEle;
                this.max = newMin;
                return this.max;
            }
            return poppedEle;
        }
    };

    top = () => {
        // return top
        if (this.mainStack.length === 0) return -1;
        if (this.mainStack[this.mainStack.length - 1] > this.max) {
            return this.max;
        }
        return this.mainStack[this.mainStack.length - 1];
    };

    getMax = () => {
        // return maximum
        if (this.mainStack.length === 0) return -1;
        return this.max;
    };
}

let maxStack = new GetMax_Stack();
maxStack.push(6);
maxStack.push(4);
maxStack.push(7);
maxStack.push(2);

console.log('top', maxStack.top());
console.log('max', maxStack.getMax());
console.log('pop', maxStack.pop());

console.log('top', maxStack.top());
console.log('max', maxStack.getMax());
console.log('pop', maxStack.pop());

console.log('top', maxStack.top());
console.log('max', maxStack.getMax());
console.log('pop', maxStack.pop());

console.log('top', maxStack.top());
console.log('max', maxStack.getMax());
console.log('pop', maxStack.pop());

console.log('top', maxStack.top());
console.log('max', maxStack.getMax());
console.log('pop', maxStack.pop());
