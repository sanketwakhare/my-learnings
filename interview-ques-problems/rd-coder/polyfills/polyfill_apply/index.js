// Polyfill for apply
const user = {
    username: "Sanket",
    age: 31
};

const getDetails = function (city, state, country) {
    console.log(`${this.username} ${this.age} ${city} ${state} ${country}`);
}

getDetails.apply(user, ['Pune', 'Maharashtra', 'India']);


Function.prototype.myApply = function (context = {}, args = []) {
    // make function available to current context
    context.fn = this;
    // invoke function
    context.fn(...args);
}

getDetails.myApply(user, ['Pune', 'Maharashtra', 'India']);
