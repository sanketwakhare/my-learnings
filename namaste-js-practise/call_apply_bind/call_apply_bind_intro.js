function getDetails(country, age) {
    return `${this.username} ${country} ${age}`;
}

const user1 = {
    username: "John",
}

console.log(getDetails.call()); // undefined undefined undefined
console.log(getDetails.call(user1, "India", 21)); // John India 21

console.log(getDetails.apply(user1, ["India", 21])); // John India 21

const newUserDetails = getDetails.bind(user1, ["USA", 24]);
newUserDetails(); // John India 21
//----------------------------------------------
const age = 10;
var person = {
    name: "Piyush",
    age: 20,
    getAge: function () {
        return this.age;
    }
}

var person2 = {age: 24};
console.log(person.getAge.call(person2)); // show with apply and bind as well
console.log(person.getAge.apply(person2));
console.log(person.getAge.bind(person2)());
//----------------------------------------------
var status = 'global scope';

setTimeout(() => {
    const status = 'arrow fn scope';

    const data = {
        status: 'local data scope',
        getStatus() {
            return this.status;
        },
    };

    console.log(data.getStatus()); //---1? 🥑
    console.log(data.getStatus.call(this)); //---2? 😎
}, 0);


//----------------------------------------------
// 4. write printAnimals() in such a way that it prints all animals in object below.
const animals = [
    {species: 'Lion', name: 'King'},
    {species: 'Whale', name: 'Queen'}
];

function printAnimals(i) {
    this.print = function () {
        console.log('#' + i + ' ' + this.species
            + ': ' + this.name);
    }
    this.print();
}
// answer ->
for(let key in animals) {
    printAnimals.call(animals[key], key)
}

//----------------------------------------------
// 5. How to append an array to another array.
const array = ['a', 'b'];
const elements = [0, 1, 2];
array.push.call(array, ...elements);
// array.push.apply(array, elements);
console.log(array);

//----------------------------------------------
// 6. Find min/max in an array and use apply to enhance a built-in function.
const numbers = [5, 6, 2, 3, 7];

// using Math.min/Math.max apply

let max = Math.max.apply(null, numbers); // equal to Math.max

let min = Math.min.apply(null, numbers); // equal to Math.min

console.log(min, max); // 2 7
//----------------------------------------------
//----------------------------------------------
//----------------------------------------------
//----------------------------------------------