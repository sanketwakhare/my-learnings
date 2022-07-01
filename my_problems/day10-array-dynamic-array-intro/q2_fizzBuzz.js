/**
 * FizzBuzz
Problem Description
Given a positive integer A, return an array of strings with all the integers from 1 to N. But for multiples of 3 the array should have “Fizz” instead of the number. For the multiples of 5, the array should have “Buzz” instead of the number. For numbers which are multiple of 3 and 5 both, the array should have "FizzBuzz" instead of the number.

Look at the example for more details.

Problem Constraints
1 <= A <= 500000

Input Format
The first argument has the integer A.

Output Format
Return an array of string.

Example Input
Input 1:
 A = 5

Example Output
Output 1:
 [1 2 Fizz 4 Buzz]

Example Explanation
Explanation 1:

 3 is divisible by 3 so it is replaced by "Fizz".
 Similarly, 5 is divisible by 5 so it is replaced by "Buzz".
 */

/**
 * 
 * @param {object} A integer A
 */
const fizzBuzz = (A) => {

    let outArray = [];
    for (let i = 1; i <= A; i++) {
        const divisibleByThree = i % 3 === 0;
        const divisibleByFive = i % 5 === 0;

        if (divisibleByThree && divisibleByFive) {
            outArray.push('FizzBuzz');
        } else if (divisibleByThree) {
            outArray.push('Fizz');
        } else if (divisibleByFive) {
            outArray.push('Buzz');
        }
        else {
            outArray.push(String(i));
        }
    }
    console.log(outArray);
    return outArray;

}

fizzBuzz(20);


// get nth fib number
function fizzBuzz2(A) {
    const divisibleByThree = A % 3 === 0;
    const divisibleByFive = A % 5 === 0;
    if (divisibleByThree && divisibleByFive) {
        return 'FizzBuzz';
    } else if (divisibleByThree) {
        return 'Fizz';
    } else if (divisibleByFive) {
        return 'Buzz';
    }
    return String(A);
}

fizzBuzz2(20);