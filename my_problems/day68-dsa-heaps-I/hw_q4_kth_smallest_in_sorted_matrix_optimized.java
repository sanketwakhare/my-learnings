import MinHeapGenericsImpl.MinHeap;

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
 * Using MinHeap of size N.
 * As arrays are sorted this can be achieved in O(K logK)
 * TC: O(K logK)
 * SC: O(N) where N is no of rows
 */
public class hw_q4_kth_smallest_in_sorted_matrix_optimized {

	class Pair implements Comparable<Pair> {
		int key;
		int i;
		int j;

		public Pair(int key, int i, int j) {
			this.key = key;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Pair o2) {
			if (this.key > o2.key)
				return 1;
			else if (this.key < o2.key)
				return -1;
			return 0;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append('[');
			sb.append(key + ", ");
			sb.append("[" + i + ", " + j + "]");
			sb.append(']');
			return sb.toString();
		}
	}

	public int solve(int[][] A, int B) {
		int answer = -1;
		MinHeap<Pair> minHeap = new MinHeap<Pair>();
		int rowsCount = A.length;
		int colsCount = A[0].length;

		// maintain the heap of size K = no of rows
		int i = 0;
		while (i < rowsCount) {
			Pair pair = new Pair(A[i][0], i, 0);
			i++;
			minHeap.insert(pair);
		}
		// extract minimum B-1 times
		while (B > 1) {
			// find min and insert the next element from same array
			Pair currMin = minHeap.getMinimum();
			if (currMin.j == colsCount - 1) {
				// no more elements to from current row/sorted array
			} else {
				Pair nextEleInSameRow = new Pair(A[currMin.i][currMin.j + 1], currMin.i, currMin.j + 1);
				minHeap.insert(nextEleInSameRow);
			}
			B--;
		}
		// extract last element from heap which is Bth smallest
		Pair bthMin = minHeap.getMinimum();
		answer = bthMin.key;
		return answer;

	}

	public static void main(String[] args) {
		hw_q4_kth_smallest_in_sorted_matrix_optimized t1 = new hw_q4_kth_smallest_in_sorted_matrix_optimized();
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
