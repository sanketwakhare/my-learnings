// polyfill for call
const item1 = {
    name: 'shirt',
    color: 'white'
}

function buyItem(price, currency) {
    console.log(`Item purchased: ${this.color} ${this.name} for ${price}${currency}`);
}

buyItem.call(item1, 500, '₹');

// call polyfill definition
Function.prototype.myCall = function (context = {}, ...args) {
    if (typeof this !== 'function') {
        throw new TypeError(`${this.name} non callable`);
    }
    // this here refer to the function to be invoked
    // copy function to current object (context)
    context.fn = this;
    context.fn(...args);
}

buyItem.myCall(item1, 300, '₹');