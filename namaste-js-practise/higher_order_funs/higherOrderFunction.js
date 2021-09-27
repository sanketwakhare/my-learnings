const radiuses = [3, 2, 4, 1];

const area = (rad) => {
  return Math.PI * rad * rad;
};

const circumference = (rad) => {
  return 2 * Math.PI * rad;
};

const diameter = (rad) => {
  return 2 * rad;
};

const calculate = (rad, logic) => {
  let output = [];
  for (let i = 0; i < rad.length; i++) {
    output.push(logic(rad[i]));
  }
  return output;
};

// Arrow function does not work here
Array.prototype.myMap = function (logic) {
  let output = [];
  for (let i = 0; i < this.length; i++) {
    output.push(logic(this[i]));
  }
  return output;
};

console.log(calculate(radiuses, area));
console.log(calculate(radiuses, circumference));
console.log(calculate(radiuses, diameter));

console.log(radiuses.myMap(diameter));
