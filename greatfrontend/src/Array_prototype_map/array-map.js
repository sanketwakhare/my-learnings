Array.prototype.myMap = function (cb, ctx) {
  const result = [];
  for (let i = 0; i < this.length; i++) {
    if (this[i]) result.push(cb.call(ctx, this[i], i, this));
    else result.push(this[i]);
  }
  return result;
};
