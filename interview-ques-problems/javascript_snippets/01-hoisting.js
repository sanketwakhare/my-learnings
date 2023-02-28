console.log('bar: ', bar); // undefined
bar = 15;
var foo = 1;
console.log("foo:", foo, "bar:", bar); // foo 1 bar 15
var bar;


greetings(); // second greetings
var greetings = function () {
    console.log("First greetings");
} // greetings function is now reassigned
greetings(); // First greetings
function greetings() {
    console.log("Second greetings");
}

greetings(); // First greetings