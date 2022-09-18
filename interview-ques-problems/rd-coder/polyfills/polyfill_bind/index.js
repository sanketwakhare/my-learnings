// Polyfill for bind
const user = {
    username: "Sanket",
    age: 31
};

const getDetails = function (city, state, country) {
    console.log(`${this.username} ${this.age} ${city} ${state} ${country}`);
}

const boundFn1 = getDetails.bind(user, 'Pune', 'Maharashtra', 'India');
boundFn1();

Function.prototype.myBind = function (context = {}, ...args) {
    // make function available to current context
    context.fn = this;
    return function (...boundArgs) {
        // invoke function
        const params = [...args, ...boundArgs];
        return context.fn(...params);
        // return context.fn.call(context, ...[...args, ...boundArgs]);
        // return context.fn.apply(context, [...args, ...boundArgs]);
    }
}

const boundFn2 = getDetails.myBind(user, 'Pune', 'Maharashtra', 'India');
boundFn2();
