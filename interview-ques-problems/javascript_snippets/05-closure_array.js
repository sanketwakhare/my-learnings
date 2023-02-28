function createClosureArray() {
    var badArray = [];
    for (var index = 0; index < 5; index++) {
        badArray[index] = function () {
            return "n=" + index;
        }
    }
    return badArray;
}

var badArray = createClosureArray();

for (var index in badArray) {
    console.log(badArray[index]());
}

// ------------Fix above code----------------
function createClosureArray1() {
    var badArray1 = [];
    for (var index = 0; index < 5; index++) {
        badArray1[index] = closure(index);
    }
    return badArray1;
}

function closure(index) {
    return function () {
        return "n=" + index;
    }
}

var badArray1 = createClosureArray1();

for (var index in badArray1) {
    console.log(badArray1[index]());
}