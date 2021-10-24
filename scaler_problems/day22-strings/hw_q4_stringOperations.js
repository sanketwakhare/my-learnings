/*******
 * String operations
Problem Description

Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.

Problem Constraints
1<=N<=100000
Make sure to consider time complexity. Concatenate the string at the end to make sure operations are performed only once

Input Format
First argument is a string A of size N.

Output Format
Return the resultant string.

Example Input
A="AbcaZeoB"

Example Output
"bc###bc###"

Example Explanation
First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
Delete all the uppercase letters so string A becomes "bcaeobcaeo".
Now replace vowel with '#'.
A becomes "bc###bc###".
*/

/**
 * Iterations: 2N
 * TC: O(N)
 * SC: O(N+N)
 * Make sure to consider time complexity. Concatenate the string at the end to make sure operations are performed only once
 * 
 * Perform string operations
 * @param {String} A input string
 * @returns processed string
 */
const stringOperations = (A) => {
    let hashSet = new Set();
    hashSet.add('a');
    hashSet.add('e');
    hashSet.add('i');
    hashSet.add('o');
    hashSet.add('u');

    let input = A.split('');

    const N = input.length;
    // iterate and replace all lower case vowels with '#'
    for (let i = 0; i < N; i++) {
        if (hashSet.has(input[i])) {
            input[i] = '#';
        }
    }

    let output = '';
    // iterate and find if given character is uppercase letter
    for (let i = 0; i < N; i++) {
        const currentCharCode = input[i].charCodeAt(0);
        // update output string if current char is not uppercase
        if (currentCharCode < 65 || currentCharCode > 90) {
            output += input[i];
        }
    }
    output = output + output;

    console.log(output);
    return output;
}

stringOperations("hgUe");
stringOperations("AbcaZeoB");