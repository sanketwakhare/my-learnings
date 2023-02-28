var variable = 10;
(() => {
    console.log(variable); // 10
    variable = 20;
    console.log(variable); // 20
})();

console.log(variable); // 20
var variable = 30;


var variable = 10;
(() => {
    variable_3 = 35;
    console.log(variable_3); // 35
    var variable_3 = 45;
    variable_2 = 15;
    console.log(variable); // 10
})();

console.log(variable_2); // 15
console.log(variable_3); // error
var variable = 30;