/***
 * Problem Description

Mohit and Akshat are great fans of even numbers and they have A number of apples with them. They want to divide the apples in such a way that each of the two gets positive even number of apples, at the same time both should have unequal number of apples. The boys are extremely tired and want to start their meal as soon as possible, that's why you should help them and find out, if they can divide in the way they want.

Problem Constraints
0 <= A <= 103

Input Format
First argument is an integer showing number of apples.

Output Format
Return 1 if the partition is possible in the required way otherwise return 0.

Example Input
Input 1:
8
Input 2:
4
Input 3:
5

Example Output
Output 1:
1
Output 2:
0
Output 3:
0

Example Explanation
Explanation 1:
2 and 6
Explanation 2:
Only possible positive even partition is 2 and 2 but both are equal.
Explanation 2:
No possible positive even partitions.
 */

const divideApplesIntoEven = (A) => {
    // if not of apples are odd,return 0
    if (A % 2 !== 0) {
        console.log(`For Input ${A} =>0`);
        return 0;
    }

    let count1 = 2;
    let count2 = A - 2;
    // if no of apples are even, then verify if apples can be divided
    while (count2 > 0 && count1 < count2) {

        if (count1 !== count2) {
            console.log(`For Input ${A} =>1`);
            return 1;
        }

        count1 += 2;
        count2 -= 2;
    }


    console.log(`For Input ${A} =>0`);
    return 0;
}

divideApplesIntoEven(8);
divideApplesIntoEven(4);
divideApplesIntoEven(2);
divideApplesIntoEven(10);
divideApplesIntoEven(5);
divideApplesIntoEven(410);
divideApplesIntoEven(501);