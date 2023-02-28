const halliday = (message) => {
    let result = "";
    for (let i = 0; i < message.length; i++) {
        const ascii = message[i].charCodeAt(0);
        if (ascii >= 65 && ascii <= 90) {
            if (ascii <= 77) {
                result += String.fromCharCode(ascii + 13);
            } else {
                result += String.fromCharCode(ascii - 13);
            }
        } else if (ascii >= 90 && ascii <= 122) {
            if (ascii <= 108) {
                result += String.fromCharCode(ascii + 13);
            } else {
                result += String.fromCharCode(ascii - 13);
            }
        } else {
            result += String.fromCharCode(ascii);
        }
    }
    console.log(result);
    return result;
}

halliday("Crystal Key");
halliday("Orb of nuevos");