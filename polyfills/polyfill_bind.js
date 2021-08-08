let object1 = {
  firstName: "John",
  lastName: "Doe",
};

const displayObject = function (city, state, country) {
  console.log(
    this.firstName +
      " " +
      this.lastName +
      " " +
      city +
      " " +
      state +
      " " +
      country
  );
};
displayObject.bind(object1, "Yeola")("MH", "India");

// Polyfill for bind method
Function.prototype.myBindWithApply = function (...myBindArgs) {
  let funName = this;
  let params = myBindArgs.slice(1);
  return function (...funArgs) {
    params = [...params, ...funArgs];
    funName.apply(myBindArgs[0], params);
  };
};
const myFun = displayObject.myBindWithApply(object1, "Yeola");
myFun("MH", "India");
