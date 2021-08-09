let animal = {
  eats: true,
};

// create a new object with animal as a prototype
let rabbit = Object.create(animal);

console.log(rabbit.eats); // true

console.log(Object.getPrototypeOf(rabbit) === animal); // true

console.log(rabbit.hasOwnProperty("eats"));
console.log(animal.hasOwnProperty("eats"));

Object.setPrototypeOf(rabbit, {}); // change the prototype of rabbit to {}

const obj = {
  nameF: "test",
  innerO: {
    personal: {
      address: "test",
    },
  },
  outerO: [1, 2],
  testF: function test() {
    console.log("test");
  },
};

let clone = Object.create(
  Object.getPrototypeOf(obj),
  Object.getOwnPropertyDescriptors(obj)
);

console.log(Object.getPrototypeOf(obj));
console.log(Object.getOwnPropertyDescriptors(obj));

console.log("clone", clone);

//shallow copy
obj2 = obj;
console.log(obj2);
obj2.nameF = "nine";
console.log("updated: ", obj);
console.log("updated: ", obj2);
console.log(clone);

console.log("isFrozen: ", Object.isFrozen(obj));
console.log("isSealed: ", Object.isSealed(obj));

Object.seal(obj);
Object.freeze(obj);
obj.nameF = "newName";
obj.newProp = "newProp";
obj.outerO.push(5);
console.log("obj after seal", obj);
console.log("isSealed: ", Object.isSealed(obj));
console.log("isFrozen: ", Object.isFrozen(obj));

let newArr = Object.entries(obj);
console.log(Object.entries(obj));

console.log("newArr ", newArr);

let newObject = Object.fromEntries(newArr);
console.log("newObject ", newObject);

let o1 = new Object();

let o2 = new Object(undefined);

let o3 = new Object(null);
let o4 = new Object(true);
