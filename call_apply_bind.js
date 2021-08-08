let name1 = {
  firstName: "Sanket",
  lastName: "Wakhare",
};

let printFullName = function (city, state) {
  console.log(this.firstName + " " + this.lastName + " " + city + " " + state);
};

printFullName.call(name1, "Yeola", "MH");

let name2 = {
  firstName: "Hiten",
  lastName: "Wakhare",
};

// function borrowing
//call
printFullName.call(name2, "Nashik", "MH");
// apply - same as call only difference is it takes array as second argument
printFullName.apply(name2, ["Nashik", "MH"]);

// bind is used when the function needs to be called later in program/ keeps copy of function
const fn = printFullName.bind(name2, "Nashik", "MH");
console.log(fn);
fn();
