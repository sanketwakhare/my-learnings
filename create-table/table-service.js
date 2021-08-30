var btnSubmit = document.querySelector("#btnSubmit");

var rows = 0;
var cols = 0;

btnSubmit.addEventListener("click", function (e) {
  console.log("clicked");
  var tableContainer = document.querySelector("#tableContainer");
  //clear existing table
  var child = tableContainer.lastElementChild;
  while (child) {
    tableContainer.removeChild(child);
    child = tableContainer.lastElementChild;
  }

  if (rows === 0 || cols === 0) {
    alert("Please provide row value between 1 to 9");
  }

  //read rows and columns

  var table = document.createElement("table");
  for (let i = 0; i < rows; i++) {
    let tr = document.createElement("tr");
    for (let j = 0; j < cols; j++) {
      let td = document.createElement("td");
      td.innerHTML = "";
      tr.appendChild(td);
    }
    table.appendChild(tr);
  }

  tableContainer.appendChild(table);
});

var rowElement = document.querySelector("#rows");
var colElement = document.querySelector("#cols");

rowElement.addEventListener("change", function (e) {
  console.log("input changed");
  if (e.target.value) {
    rows = Number(e.target.value);
    if (rows > 9 || rows < 1) {
      alert("Please provide row value between 1 to 9");
      rows = 0;
    }
  } else {
    alert("Please provide row value between 1 to 9");
    rows = 0;
  }
});

colElement.addEventListener("change", function (e) {
  console.log("input changed");
  if (e.target.value) {
    cols = Number(e.target.value);
    if (cols > 9 || cols < 1) {
      alert("Please provide row value between 1 to 9");
      cols = 0;
    }
  } else {
    alert("Please provide row value between 1 to 9");
    cols = 0;
  }
});
