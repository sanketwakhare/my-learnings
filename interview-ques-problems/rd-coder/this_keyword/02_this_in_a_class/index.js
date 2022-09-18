// this in a class
class User {
    type;

    constructor(name) {
        this.name = name;
        this.type = "endUser"
    }

    getName() {
        return this.name;
    }

    get() {
        return this;
    }
}

const user1 = new User("John");
console.log(user1.getName());
console.log(user1);

const user2 = new User("Doe");
console.log(user2.getName());
console.log(user2);
// -----------------------------------------------