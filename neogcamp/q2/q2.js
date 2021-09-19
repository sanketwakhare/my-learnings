/**
 * Create a web app where I can input a text. Now create two buttons + and -. On clicking + increase the fontSize by 2px and vice versa.
 */

document.querySelector("#increase").addEventListener("click", () => {
  let textArea = document.querySelector("#text-area");
  console.log(textArea.style.fontSize);
  if (textArea.style.fontSize === "") {
    textArea.style.fontSize = "18px";
  } else {
    textArea.style.fontSize =
      Number(Number(textArea.style.fontSize.split("px")[0]) + Number(2)) + "px";
  }
  textArea.style.fontWeight = "bold";
  textArea.style.fontSize = "2em";
});

document.querySelector("#decrease").addEventListener("click", () => {
  let textArea = document.querySelector("#text-area");
  if (textArea.style.fontSize === "") {
    textArea.style.fontSize = "14px";
  } else {
    textArea.style.fontSize =
      Number(Number(textArea.style.fontSize.split("px")[0]) - Number(2)) + "px";
  }
});

document.querySelector("#h1").addEventListener("click", () => {
  let textArea = document.querySelector("#text-area");
  textArea.classList.add("h1");
  textArea.classList.remove("h2");
  textArea.classList.remove("h3");
});

document.querySelector("#h2").addEventListener("click", () => {
  let textArea = document.querySelector("#text-area");
  textArea.classList.add("h2");
  textArea.classList.remove("h1");
  textArea.classList.remove("h3");
});
document.querySelector("#h3").addEventListener("click", () => {
  let textArea = document.querySelector("#text-area");
  textArea.classList.add("h3");
  textArea.classList.remove("h1");
  textArea.classList.remove("h2");
});
