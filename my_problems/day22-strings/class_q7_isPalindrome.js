/**
 * Check if given substring is palindrome or not
 * @param {String} S input string
 * @param {Number} start start index of substring
 * @param {Number} end end index of substring
 * @returns 
 */
const isPalindrome = (S, start, end) => {

    while (start < end) {
        if (S[start] === S[end]) {
            start++;
            end--;
        } else {
            return false;
        }
    }
    return true;
}

isPalindrome("malayalam", 0, 8);