const getRecipient = function (message, position) {

    let firstArray = message.split(" ");
    let array = [];
    const regex = /@[a-zA-Z0-9_-]*/g;
    for(let msg of firstArray) {
        if(!msg.startsWith("@")) continue;
        array.push(msg.match(regex)[0]);
    }
    if (!array || position > array.length) {
        return "";
    }
    return array[position -1].substring(1, array[position -1].length);
}

let out = getRecipient(' @user3 test@@User1 test, how are you. meet @user2?', 2);
console.log(out);

out = getRecipient('hello @user3 test@User1 test, how are you. meet @user2?', 1);
console.log(out);