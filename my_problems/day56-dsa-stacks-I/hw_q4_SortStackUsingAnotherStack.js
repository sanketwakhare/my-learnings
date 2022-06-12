const solve = function (A) {

    // assume given input array A is a stack

    // maintain the second stack in descending order
    let anotherStack = [];

    while (A.length !== 0) {
        // take top element from input stack into variable
        let top = A.pop();
        while (anotherStack.length > 0 && anotherStack[anotherStack.length - 1] > top) {
            // keep popping all the elements from anotherStack which are  > top
            // and push into input array
            A.push(anotherStack.pop());
        }
        // push top of input stack into anotherStack
        anotherStack.push(top);
    }
    return anotherStack;
}

console.log(solve([5, 17, 100, 11]));
console.log(solve([5, 4, 7, 8, 11, 32, 54, 98, 50, 13, 15, 2, 9]));