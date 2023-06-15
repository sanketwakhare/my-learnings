// Debouncing in Javascript
let counter = 0;
const getData = () => {
  // calls an API and gets Data
  const searchInputElement = document.getElementById('searchText');
  console.log("Fetching Data ..", counter++, searchInputElement.value);
};

const debounce = function (fn, d) {
  let timer;
  return function () {
    let context = this;
    let args = arguments;
    clearTimeout(timer);
    timer = setTimeout(() => {
      fn.apply(context, args);
    }, d);
  };
};

const betterFunction = debounce(getData, 500);

function my_debounce(func, wait = 0) {
  let timeout = null;
  return function (...args) {
    const context = this;
    clearTimeout(timeout);
    timeout = setTimeout(() => {
      timeout = null;
      func.call(context, ...args);
    }, wait);
  }
}

const my_betterFunction = my_debounce(getData, 400);