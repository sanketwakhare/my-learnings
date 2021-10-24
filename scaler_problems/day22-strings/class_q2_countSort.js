/*******
 * Given a String , which contains only lower case characters, sort the given string
 */

/**
 * TC: O(26+N)
 * SC: 26 ~ O(1)
 * @param {Array} str character array of lower case characters.
 */
const countSort = (str) => {
    console.log(str);
    // convert string to char array
    const inputCharArray = str.split('');

    // maintain the count array
    let cnt = new Array(26).fill(0);

    // push the frequency of each character in count array
    for (let j = 0; j < inputCharArray.length; j++) {
        const currentCharCode = inputCharArray[j].charCodeAt(0);
        cnt[currentCharCode - 97] += 1;
    }
    console.log(cnt);

    // build teh final sorted string from count array
    str = '';
    for (let i = 0; i < cnt.length; i++) {
        for (let j = 0; j < cnt[i]; j++) {
            str += String.fromCharCode(97 + i);
        }
    }
    console.log(str);
}

countSort('hfgrjhjeodjkdbnbavermnzmxcnznmpqoweqhrwqehbfwjhlajkfdoijfwonvdalqpaanjahurujkq');
countSort('dabaedb');