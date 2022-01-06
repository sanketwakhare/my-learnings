/**
 * Rotated Sorted Array Search
 * 
Problem Description
Given a sorted array of integers A of size N and an integer B.
array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value B to search. If found in the array, return its index, otherwise return -1.
You may assume no duplicate exists in the array.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are distinct.

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return index of B in array A, otherwise return -1

Example Input
Input 1:
A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:
A = [1]
B = 1

Example Output
Output 1:
 0
Output 2:
 0

Example Explanation
Explanation 1:

Target 4 is found at index 0 in A.
Explanation 2:
 
Target 1 is found at index 0 in A.
 */

/**
 * Using 2 passes of binary search
 * 1) To find index t -> start index of second sorted array
 * 2) To find element K
 * 
 * TC: O(logN)
 * SC: O(1)
 */
public class q2_RotatedSortedArraySearch_approach1 {

    /* Find start index of second sorted array in rotated sorted array */
    private static int findStartIndexOfSecondSortedSubArray(int[] A) {
        // t is index we hae to find
        int t = 0;

        // initialize search space
        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (A[mid] > A[0]) {
                // we are in left subArray now
                // t will be present in right part
                l = mid + 1;
            } else {
                // we are in right subArray now
                // either we found the t or check for first index of second subArray on left
                t = mid;
                r = mid - 1;
            }
        }
        return t;
    }

    /* Binary Search */
    private static int binarySearch(int[] A, int K, int l, int r) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                return mid;
            } else if (K > A[mid]) {
                // search on right part
                l = mid + 1;
            } else {
                // search on left part
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int searchKInRotatedSortedArray(int[] A, int K) {

        int N = A.length;
        int answer = -1;

        int t = findStartIndexOfSecondSortedSubArray(A);
        System.out.println("t -> " + t);

        if (K < A[N - 1]) {
            // apply Binary Search on right subArray
            answer = binarySearch(A, K, t, N - 1);
        } else {
            // apply Binary Search on left subArray
            answer = binarySearch(A, K, 0, t - 1);
        }
        // if K is not found, return -1
        return answer;
    }

    public static void main(String[] args) {
        int[] input1 = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int out = searchKInRotatedSortedArray(input1, 4);
        System.out.println("answer -> " + out);
        int[] input2 = { 1, 2, 3 };
        out = searchKInRotatedSortedArray(input2, 2);
        System.out.println("answer -> " + out);
        int[] input3 = { 24, 25, 34, 45, 46, 10, 15, 17 };
        out = searchKInRotatedSortedArray(input3, 45);
        System.out.println("answer -> " + out);
        int[] input4 = { 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
        out = searchKInRotatedSortedArray(input4, 202);
        System.out.println("answer -> " + out);
        int[] input5 = { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4,
                5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48,
                51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99,
                101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129,
                130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170,
                171, 172, 173, 174, 175, 176, 177 };
        out = searchKInRotatedSortedArray(input5, 42);
        System.out.println("answer -> " + out);
    }
}
