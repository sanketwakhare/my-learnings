// DOM Manipulation - function currying


const changeParagraphText = function(id) {
    let ele = document.querySelector(id);
    return function(text) {
        ele.textContent = text;
    }
}
changeParagraphText("#paragraph")("change via currying");