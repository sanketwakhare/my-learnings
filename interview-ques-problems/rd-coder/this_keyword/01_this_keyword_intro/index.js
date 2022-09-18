// this here refers to window object
console.log(this); // window object

this.a = 5;

// normal function
function normalFunction() {
    // this here refers to parent object
    // i.e. window object
    console.log(this.a); // 5
}

normalFunction();

// arrow function
arrowFunction = () => {
    // this here refers to parent object
    // outer normal function
    // i.e. window object
    console.log(this.a);
}
arrowFunction(); // 5

// -----------------------------------------------
// Behavior of this inside object

let newUser = {
    name: "John",
    age: 21,
    child: {
        childName: "Doe",
        age: 5,
        getDetails() {
            // normal function
            // this here refers to child object
            // name property does not exist on child
            console.log(this.name, this.childName);// undefined Doe
        }
    },
    getDetails() {
        // normal function
        // this here refers to newUser object
        console.log(this.name);
        const nestedArrow = () => console.log(this.name);
        nestedArrow();
    }
}
newUser.getDetails(); // John 2 times
newUser.child.getDetails();
// -----------------------------------------------
// arrow function on objects
let newUserArr = {
    name: "John",
    age: 21,
    getDetails: () => {
        // arrow function
        // this here refers to parent object i.e. window object here
        // as it is being invoked form global scope
        console.log(this.name);
    }
}
newUserArr.getDetails(); // undefined or empty space as name does not exist on window object

function test(obj) {
    // this inside getDetails will not refer to the object obj
    obj.getDetails();
}

test(newUserArr); // undefined or empty
test(newUser); // John 2 times