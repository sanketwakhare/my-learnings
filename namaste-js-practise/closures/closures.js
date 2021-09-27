function outer() {
  let x = 10;
  function sayHello() {
    console.log(x, "Hello World");
  }
  sayHello();
}

outer();

// print 1,2,3,4,5 after each seconds using let
function a() {
  for (let i = 1; i <= 5; i++) {
    setTimeout(function () {
      console.log(i);
    }, i * 1000);
  }
}
a();

// print 1,2,3,4,5 after each seconds without using let
function x() {
  for (var i = 1; i <= 5; i++) {
    function t() {
      var p = i;
      setTimeout(function () {
        console.log(p);
      }, p * 1000);
    }
    t();
  }
}
x();
