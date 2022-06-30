const getRecipient = function (message, position) {

    const regex = /[^0-9A-Za-z]@[a-zA-Z0-9_-]*/g;
    const array = message.match(regex);

    if (!array || position > array.length) {
        return "";
    }
    return array[position -1];
}

let out = getRecipient('hello @user3 test@User1 test, how are you. meet @user2?', 2);
console.log(out);

out = getRecipient('hello @user3 test@User1 test, how are you. meet @user2?', 1);
console.log(out);