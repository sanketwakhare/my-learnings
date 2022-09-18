// output based questions
// setTimeout and this keyword

const user = {
    name: "John Doe",
    getDetails() {
        console.log(this.name) // what is output?
    }
}
setTimeout(user.getDetails, 1000); // logs undefined or empty

// setTimeout will call getDetails as callback method
// so while calling the method it does have user context,
// instead it has window object as this

// -------------------------------------------
// Q) Fix above code to point this keyword to user name

setTimeout(
    function () {
        user.getDetails();
    }, 1000); // logs John Doe
// -------------------------------------------
