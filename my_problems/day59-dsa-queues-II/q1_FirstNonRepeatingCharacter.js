/* FirstNonRepeatingCharacter */

//param A : string
//return a strings
const firstNonRepeatingCharacter = function (A) {

    let result = [];
    let queue = [];
    let map = new Map();
    for (let i = 0; i < A.length; i++) {

        const currChar = A.charAt(i);
        if (map.has(currChar)) {
            map.set(currChar, map.get(currChar) + 1);
        } else {
            map.set(currChar, 1);
            queue.push(currChar);
        }

        while (queue.length > 0) {
            if (map.get(queue[0]) > 1) {
                queue.shift();
            } else {
                break;
            }
        }
        if (queue.length === 0) {
            result.push('#');
        } else {
            result.push(queue[0]);
        }
    }
    return result.join('');
}

console.log(firstNonRepeatingCharacter("abadbc"));
console.log(firstNonRepeatingCharacter("abcabc"));

// stream = abadbc
// ind = 0
// a

// queue d b
// map
// a = 2
// b = 2
// d = 1

// ans = aabbdd