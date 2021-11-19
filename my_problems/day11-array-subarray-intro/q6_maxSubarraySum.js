/**
 * Max Sum Contiguous Subarray
Problem Description

Find the contiguous subarray within an array, A of length N which has the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000

Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.

Example Input
Input 1:

 A = [1, 2, 3, 4, -10] 
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 

Example Output
Output 1:
 10 
Output 2:
 6 

Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 
 */

const maxContiguousSubArraySum = (A) => {

    /***************O(N^3) ***************/
    // let max = A[0];
    // for (let i = 0; i < A.length; i++) {
    //     for (let j = i; j < A.length; j++) {
    //         let sum = 0;
    //         for (let k = i; k <= j; k++) {
    //             sum = sum + A[k];
    //         }
    //         if (max < sum) { max = sum; }
    //     }
    // }
    /******************************/


    /***************O(N^2) Sliding window for each length***************/
    // let max = A[0];
    //     for (let k = 1; k <= A.length; k++) {

    //         let sum = 0;
    //         for(let i=0; i<= k-1; i++) {
    //             sum = sum + A[i];
    //         }
    //         if (max < sum) { max = sum; }

    //         for(let i=1; i< A.length-k+1; i++){
    //             let j = k+i-1;
    //             sum = sum - A[i-1] + A[j];

    //             if (max < sum) { max = sum; }
    //         }

    //     }
    //     return max;
    /******************************/

    /******** O(N) solution **********************/

    let maxSum = A[0] < 0 ? A[0] : 0;
    let currentSum = 0;
    for (let i = 0; i < A.length; i++) {
        currentSum = currentSum + A[i];
        if (currentSum > maxSum) { maxSum = currentSum; }
        if (currentSum < 0) { currentSum = 0; }
    }
    console.log(maxSum);
    /******************************/

}

maxContiguousSubArraySum([1, 2, 3, 4, -10]);
maxContiguousSubArraySum([-2, 1, -3, 4, -1, 2, 1, -5, 4]);
maxContiguousSubArraySum([-500]);