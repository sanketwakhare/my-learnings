/* Check Palindrome - II */

const checkPalindrome = function (A) {

    // To be valid palindrome, each character should occur in multiple of 2 except one in middle
    // Approach: find frequency iof each character within string
    const array = A.split("");

    // build hashMap of <Character, frequency>
    // hashMap<String, Integer> => <Character, frequency>
    let hashMap = new Map();
    for (let i = 0; i < array.length; i++) {
        if (hashMap.has(array[i])) {
            let currentFrequency = hashMap.get(array[i]);
            hashMap.set(array[i], currentFrequency + 1);
        } else {
            hashMap.set(array[i], 1);
        }
    }

    //  only single odd frequency is allowed
    let oddFrequencyCount = 0
    const keys = hashMap.keys();
    for (let key of keys) {
        // odd frequency
        if ((hashMap.get(key) & 1) === 1) {
            oddFrequencyCount++;
            if (oddFrequencyCount > 1) {
                break;
            }
        }
    }

    if (oddFrequencyCount > 1) {
        return 0;
    }
    return 1;
}

console.log(checkPalindrome("abcde"));
console.log(checkPalindrome("abbaee"));