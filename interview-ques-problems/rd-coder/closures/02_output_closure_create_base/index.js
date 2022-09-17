// Create Base

// Can you create a function named createBase to show the below functionality?

// var addSix = createBase(6);
// addSix(10);// returns 16
// addSix(21);// returns 27


function createBase(num1) {
    return function (num2) {
        const result = num1 + num2;
        console.log(result);
    }
}

var addSix = createBase(6);
addSix(10);// returns 16
addSix(21);// returns 27


