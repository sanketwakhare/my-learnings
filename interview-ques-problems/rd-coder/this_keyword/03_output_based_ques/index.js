// output based questions

const user = {
    firstName: "John",
    getName() {
        // normal function - this refers to user object
        const firstName = "Doe";
        console.log(firstName); // Doe
        console.log(this.firstName); // John
        return this.firstName;
    }
};
console.log(user.getName()); // John

// -------------------------------------------
// accessing ref

function createUser() {
    return {
        name: "John",
        // here this refers to window object
        ref: this
    };
}

let newUser = createUser();
console.log(newUser);

// fix above code so that ref refers to the new object
function createUserFix() {
    return {
        name: "John",
        ref() {
            // here this refers to new object
            return this;
        }
    };
}

let newUserFix = createUserFix();
console.log(newUserFix.ref());
// -------------------------------------------
//Q) What it the output?
const newUser1 = {
    username: "John",
    sayHello() {
        console.log(`hello ${this.username}`);
    },
    sayHi: () => {
        console.log(`hi ${this.username}`);
    }
};
newUser1.sayHello(); // hello John
newUser1.sayHi(); // hi undefined