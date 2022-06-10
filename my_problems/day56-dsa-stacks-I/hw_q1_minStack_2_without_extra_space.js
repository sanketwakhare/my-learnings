/* Min Stack */

/* Implement getMin() using single stack */

function solve() {
    // Initalize your variables here
    this.mainStack = [];
    this.min = -1;
}

solve.prototype.push = function (e) {
    if (this.mainStack.length === 0) {
        this.mainStack.push(e);
        this.min = e;
    } else {
        if(e < this.min) {
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
solve.prototype.pop = function () {
    // pop element from both stacks and return from mainStack
    if (this.mainStack.length > 0) {
        const poppedEle = this.mainStack.pop();
        if (poppedEle < this.min) {
            // update min
            let newMin = (this.min * 2) - poppedEle;
            this.min = newMin;
        }
        return poppedEle;
    }
};
solve.prototype.top = function () {
    // return top
    if (this.mainStack.length === 0) return -1;
    if (this.mainStack[this.mainStack.length - 1] < this.min) {
        return this.min;
    }
    return this.mainStack[this.mainStack.length - 1];
};
solve.prototype.getMin = function () {
    // return minimum
    if (this.mainStack.length === 0) return -1;
    return this.min;
};
module.exports = {
    solve: solve
};