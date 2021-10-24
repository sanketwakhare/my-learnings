/**
 * 
 */

const longestCommonPrefix = (A) => {

    // initialize longest common prefix with first string in array
    //  longest common prefix can no exceed more than smallest string length in array
    let longestCommonPrefix = A[0];
    const N = A.length;
    for (let i = 1; i < N; i++) {

        // compare two string at a given time
        let s1 = A[i - 1];
        let s2 = A[i];

        let j = 0;
        // local variable to store the longest common prefix of s1 and s2
        let currentCommonPrefix = '';
        while (j < s1.length && j < s2.length) {
            if (s1[j] === s2[j]) {
                // if both the characters at index j are equal, add them in current common prefix
                currentCommonPrefix += s1[j];
                // go to next character in string
                j++;
            } else {
                // stop comparing 2 string
                break;
            }
        }
        // if current common prefix is less than longestCommonPrefix, update longestCommonPrefix with currentCommonPrefix
        if (currentCommonPrefix.length < longestCommonPrefix.length) {
            longestCommonPrefix = currentCommonPrefix;
        }
    }
    console.log(longestCommonPrefix);
    return longestCommonPrefix;
}

longestCommonPrefix(["abcdefgh", "aefghijk", "abcefgh"]);
longestCommonPrefix(["prashant", "pratik", "pratiksha", "prachi"]);