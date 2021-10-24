const reverse = (s, start, end) => {
    while (start < end) {
        let temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }

}



const reverseStringWordByWord = (A) => {
    let str = A.split('');

    // reverse entire string
    reverse(str, 0, A.length - 1);

    // reverse each word separated by space ' '
    // start and end should be same initially
    let start = 0;
    let end = 0;
    while (end < A.length) {

        // loop until end of single word
        while (str[end] != ' ' && end < A.length) {
            end++;
        }

        // reverse single word from start to end
        reverse(str, start, end - 1);

        // if there are spaces in between, increase start index until first character of word is found
        start = end + 1;
        while (str[start] === ' ') {
            start++;
        }
        // start and end should be same initially
        end = start;
    }

    console.log(str.join('').trim());
}

reverseStringWordByWord(" the sky  is blue ");
