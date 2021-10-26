const isPalindrome = (A, start, end) => {

    if (start >= end) {
        // base condition. This means the given string is Palindrome
        return 1;
    }
    // check start and end character
    if (A[start] === A[end]) {
        // if start and end characters are equal, increase start and decrease end and verify the subsequenct next set of characters
        return isPalindrome(A, start + 1, end - 1);
    } else {
        // if characters are not matching, the given string is not Palindrome
        return 0;
    }
}

const checkPalindromeMain = (A) => {
    const ans = isPalindrome(A, 0, A.length - 1);
    console.log(`The given string ${A} is ${ans ? 'Palindrome' : 'Not Palindrome'} `);
    return ans;
}

checkPalindromeMain("malayalam");
checkPalindromeMain("pushup");
checkPalindromeMain("strings");
checkPalindromeMain("abccba");
checkPalindromeMain("abcba");
checkPalindromeMain("abccaa");