/* Magician and Chocolates */

/* Problem Description

Given N bags, each bag contains Bi chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Bi chocolates, then the magician fills the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7


Problem Constraints

1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 105



Input Format

First argument is an integer A.
Second argument is an integer array B of size N.



Output Format

Return an integer denoting the maximum number of chocolates that kid can eat in A units of time.



Example Input

Input 1:

 A = 3
 B = [6, 5]
Input 2:

 A = 5
 b = [2, 4, 6, 8, 10]


Example Output

Output 1:

 14
Output 2:

 33


Example Explanation

Explanation 1:

 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
 so, total number of chocolates eaten are 6 + 5 + 3 = 14
Explanation 2:

 Maximum number of chocolates that can be eaten is 33. */
public class q2_Magician_and_Chocolates {

    class MaxHeap {
        int[] heap;
        int size;

        public MaxHeap(int size) {
            this.heap = new int[size];
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public int[] getHeap() {
            return this.heap;
        }

        public boolean isEmpty() {
            if (this.size == 0) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (this.size == heap.length) {
                return true;
            }
            return false;
        }

        public void insert(int x) {

            // insert x into last position
            if (!isFull()) {
                heap[size] = x;
                size++;

                int i = size - 1;
                while (i > 0) {
                    int parentIndex = (i - 1) / 2;
                    if (heap[i] > heap[parentIndex]) {
                        swap(i, parentIndex);
                        i = parentIndex;
                    } else {
                        return;
                    }
                }
            }
        }

        public int getMaximum() {
            int x = -1;
            if (!isEmpty()) {
                x = heap[0];
                // swap last element and x
                swap(0, size - 1);
                heap[size - 1] = -1;
                size--;

                int i = 0;

                while ((2 * i) + 1 < size) {
                    int leftChildIndex = (2 * i) + 1;
                    int rightChildIndex = (2 * i) + 2;
                    int max = Math.max(heap[leftChildIndex], heap[i]);
                    if (rightChildIndex < size) {
                        max = Math.max(max, heap[rightChildIndex]);
                    }

                    if (max == heap[i]) {
                        break;
                    } else if (max == heap[leftChildIndex]) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < size && max == heap[rightChildIndex]) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }
            }
            return x;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

    }

    public int nchoc(int A, int[] B) {

        // build MaxHeap
        MaxHeap heap = new MaxHeap(B.length);
        for (int i = 0; i < B.length; i++) {
            heap.insert(B[i]);
        }

        long total = 0;
        long m = 1000000007;
        while (A > 0) {
            int x = heap.getMaximum();
            total = ((long) x % m + total % m) % m;
            heap.insert(x / 2);
            A--;
        }
        return (int) total;
    }

    public static void main(String[] args) {
        q2_Magician_and_Chocolates t1 = new q2_Magician_and_Chocolates();
        int answer = t1.nchoc(3, new int[] { 6, 5 });
        System.out.println(answer); // expected answer 14

        t1 = new q2_Magician_and_Chocolates();
        answer = t1.nchoc(5, new int[] { 2, 4, 6, 8, 10 });
        System.out.println(answer); // expected answer 33`
    }

}
