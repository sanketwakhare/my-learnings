// polyfill for apply
const item2 = {
    name: 'shirt',
    color: 'white'
}

function buyItem(price, currency) {
    console.log(`Item purchased: ${this.color} ${this.name} for ${price}${currency}`);
}

buyItem.apply(item2, [500, '₹']);

// apply polyfill definition
Function.prototype.myApply = function (context = {}, args = []) {
    if (typeof this !== 'function') {
        throw new TypeError(`${this.name} non callable`);
    }
    context.fn = this;
    context.fn(...args);
}

buyItem.myApply(item2, [300, '₹']);