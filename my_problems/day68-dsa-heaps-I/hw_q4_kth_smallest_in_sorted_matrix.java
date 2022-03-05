import MaxHeapGenericsImpl.MaxHeap;

/*  Kth Smallest Element in a Sorted Matrix */

/* Problem Description

Given a sorted matrix of integers A of size N x M and an integer B.

Each of the rows and columns of matrix A are sorted in ascending order, find the Bth smallest element in the matrix.

NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.


Problem Constraints
1 <= N, M <= 500
1 <= A[i] <= 10^9
1 <= B <= N * M

Input Format

The first argument given is the integer matrix A.
The second argument given is an integer B.


Output Format

Return the B-th smallest element in the matrix.


Example Input

Input 1:

 A = [ [9, 11, 15],
       [10, 15, 17] ] 
 B = 6
Input 2:

 A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12

Example Output

Output 1:

 17
Output 2:

 16


Example Explanation

Explanation 1:

 6th smallest element in the sorted matrix is 17.
Explanation 2:

 12th smallest element in the sorted matrix is 16. */

/**
 * Almost Brute force
 * TC: O(N2) => traverse each element
 */
public class hw_q4_kth_smallest_in_sorted_matrix {

	public int solve(int[][] A, int B) {
		int answer = -1;
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				int currentElement = A[i][j];
				if (maxHeap.size() < B) {
					maxHeap.insert(currentElement);
				} else {
					if (maxHeap.peekMax() > currentElement) {
						maxHeap.getMaximum();
						maxHeap.insert(currentElement);
					}
				}
			}
		}
		if (maxHeap.size() > 0) {
			answer = maxHeap.peekMax();
		}
		return answer;

	}

	public static void main(String[] args) {
		hw_q4_kth_smallest_in_sorted_matrix t1 = new hw_q4_kth_smallest_in_sorted_matrix();
		int[][] A = {
				{ 5, 9, 11 },
				{ 9, 11, 13 },
				{ 10, 12, 15 },
				{ 13, 14, 16 },
				{ 16, 20, 21 } };
		int B = 12;
		System.out.println(t1.solve(A, B)); // 16

		A = new int[][] {
				{ 9, 11, 15 },
				{ 10, 15, 17 } };
		B = 6;
		System.out.println(t1.solve(A, B)); // 17

	}
}
