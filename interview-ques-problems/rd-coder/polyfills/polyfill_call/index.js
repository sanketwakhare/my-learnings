// Polyfill for call

const item = {
    name: "apple",
    color: "red"
};

const buyItem = function (price, currency) {
    console.log(`item purchased - ${this.color} ${this.name} for ${price} ${currency}`);
}

Function.prototype.myCall = function (context = {}, ...args) {
    context.func = this;
    context.func(...args);
}

buyItem.call(item, 200, 'rs'); // item purchased - red apple for 200 rs
buyItem.myCall(item, 200, 'rs'); // item purchased - red apple for 200 rs