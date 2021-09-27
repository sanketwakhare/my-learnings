// create event listeners at container level
document.querySelector("#container").addEventListener("click", function (e) {
  console.log(e.target.id + " clicked");
});

// use custom attribute to implement event delegation
document.querySelector("#myForm").addEventListener("keyup", function (e) {
  console.log("called");
  if (e.target.dataset.uppercase !== undefined) {
    e.target.value = e.target.value.toUpperCase();
  }
});
