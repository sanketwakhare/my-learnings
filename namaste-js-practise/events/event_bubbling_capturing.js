// By default, bubbling up . third paramter is false
// Bubbling up means event flows from bottom to top
// Capturing/ Trickling means event flows from top to bottom

let grandparent = document.querySelector("#grandparent");
grandparent.addEventListener(
  "click",
  function () {
    console.log("Grandparent clicked");
  },
  false // event bubbling
);

let parent = document.querySelector("#parent");
parent.addEventListener(
  "click",
  function () {
    console.log("Parent clicked");
  },
  false // event bubbling
);

let child = document.querySelector("#child");
child.addEventListener(
  "click",
  function (e) {
    console.log("Child clicked");
    e.stopPropagation();
  },
  false // event bubbling
);
