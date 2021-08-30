var leftLight = document.querySelector("#left-light");
var rightLight = document.querySelector("#right-light");

leftLight.addEventListener("click", function (e) {
  console.log("left clicked");
  changeImages();
});

rightLight.addEventListener("click", function (e) {
  console.log("right clicked");
  changeImages();
});

var changeImages = function () {
  let leftImage = leftLight.getAttribute("src");
  let rightImage = rightLight.getAttribute("src");

  // swap
  leftLight.setAttribute("src", rightImage);
  rightLight.setAttribute("src", leftImage);
};
