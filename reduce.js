const users = [
  { firstName: "John", lastName: "Miller", age: 21 },
  { firstName: "Sam", lastName: "Doe", age: 40 },
  { firstName: "Simon", lastName: "Hall", age: 20 },
  { firstName: "Candy", lastName: "Stark", age: 26 },
];

const result = users.reduce((acc, currentUser) => {
  if (currentUser.age < 25) {
    acc.push(currentUser.firstName);
  }
  return acc;
}, []);

console.log(result);
