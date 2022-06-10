/* Implement Min Stack using 2 stacks */

function solve() {
    // Initialize your variables here
    this.mainStack = [];
    this.minStack = [];
}

solve.prototype.push = function (e) {
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
solve.prototype.pop = function () {
    // pop element from both stacks and return from mainStack
    if (this.mainStack.length > 0) {
        this.minStack.pop();
        return this.mainStack.pop();
    }
};
solve.prototype.top = function () {
    // return top
    if (this.mainStack.length === 0) return -1;
    return this.mainStack[this.mainStack.length - 1];
};
solve.prototype.getMin = function () {
    // return minimum
    if (this.minStack.length === 0) return -1;
    return this.minStack[this.minStack.length - 1];
};
module.exports = {
    solve: solve
};

