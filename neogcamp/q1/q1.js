/**
 * Create a web app which would take two inputs. It would also have 4 buttons: +, -, x /. Based on the button clicked perform the operation on the two inputs. You can do this in React or vanillaJS based on your choice. Your time starts now.
 */

const performOperations = (operationType) => {
  let value1 = Number(document.querySelector("#no1").value);
  let value2 = Number(document.querySelector("#no2").value);
  let result = 0;
  switch (operationType) {
    case "+":
      result = value1 + value2;
      break;
    case "-":
      result = value1 - value2;
      break;
    case "*":
      result = value1 * value2;
      break;
    case "/":
      result = value1 / value2;
      break;
  }

  document.querySelector("#output").value = result;
};

document.querySelector("#add").addEventListener("click", () => {
  console.log("Add clicked");
  performOperations("+");
});

document.querySelector("#subtract").addEventListener("click", () => {
  console.log("Subtract clicked");
  performOperations("-");
});

document.querySelector("#multiply").addEventListener("click", () => {
  console.log("Multiply clicked");
  performOperations("*");
});

document.querySelector("#divide").addEventListener("click", () => {
  console.log("Divide clicked");
  performOperations("/");
});
