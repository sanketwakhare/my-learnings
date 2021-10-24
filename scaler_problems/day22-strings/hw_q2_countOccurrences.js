const countOccurrences = (A) => {
    let count = 0;
    const N = A.length;
    const subString = 'bob';
    const subStringLength = subString.length;

    // iterate will N- subStringLength
    for (let i = 0; i <= N - subStringLength; i++) {
        // is A[i] can be start of bob
        if (A[i] === 'b') {
            let j = i;
            let k = 0;
            let isSubStringMatching = false;
            // compare current substring with target substring
            while (A[j] === subString[k] && k < subStringLength) {
                j++;
                k++;
            }
            // verify if current substring is matching with target substring
            if (j - i === subStringLength) {
                isSubStringMatching = true;
                count++;
            }
        }
    }
    console.log(count);
    return count;
}

countOccurrences("bobob");
countOccurrences("bobabtbobl");
