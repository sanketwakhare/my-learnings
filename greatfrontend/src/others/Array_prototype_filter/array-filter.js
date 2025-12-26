Array.prototype.myFilter = function (cb, thisArg) {
  const result = [];
  for (let i = 0; i < this.length; i++) {
    if (this[i] && cb.call(thisArg, this[i], i, this)) {
      result.push(this[i]);
    }
  }
  return result;
};
