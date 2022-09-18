// polyfill for bind
const item3 = {
    name: 'shirt',
    color: 'white'
}

function buyItem(price, currency) {
    console.log(`Item purchased: ${this.color} ${this.name} for ${price}${currency}`);
}

const boundFn = buyItem.bind(item3, 500);
boundFn('₹');

// bind polyfill definition
Function.prototype.myBind = function (context = {}, ...args) {
    if (typeof this !== 'function') {
        throw new TypeError(`${this.name} non callable`);
    }
    // this here refer to the function to be invoked
    // copy function to current object (context)
    context.fn = this;
    return function (...boundArgs) {
        // return context.fn.call(context, ...args, ...boundArgs);
        // return context.fn.apply(context, [...args, ...boundArgs]);
        return context.fn(...args, ...boundArgs);
    }
}
// practice
const myBoundFn = buyItem.myBind(item3, 300);
myBoundFn('₹');