/**
 * Count Duplicates

Problem Description
You are given an integer array A having length N. You have to find the number of duplicate(redundant) elements in the array.

Problem Constraints
1 <= N <= 1000
-10^9 <= A[i] <= 10^9

Input Format
First and only argument is an integer array A.

Output Format
Return a single integer.

Example Input
Input 1:
 A = [1, 10, 20, 1, 25, 1, 10, 30, 25, 1] 
Input 2:
 A = [1, 2, 3] 

Example Output
Output 1:
 5 
Output 2:
 0 

Example Explanation
Explanation 1:

 1 is present 4 times in the array. So, 3 of them are redundant.
 10 is present 2 times in the array. So, 1 of them is redundant.
 25 is present 2 times in tha array. So, 1 of them is redundant.
 Total duplicates(redundants) = 3 + 1 + 1 = 5 
Explanation 2:

 There are no duplicates in the array (Each element has distinct value).
 */

const countDuplicates = (A) => {
  let set = new Set();
  A.forEach((x) => set.add(x));
  console.log(set.size);
  console.log(A.length);
  return A.length - set.size;
};

countDuplicates([1, 10, 20, 1, 25, 1, 10, 30, 25, 1]);
