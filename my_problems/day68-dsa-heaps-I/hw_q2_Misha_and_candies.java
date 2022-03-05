/* Misha and Candies */

/* Problem Description

Misha loves eating candies. She has given N boxes of Candies.

She decides, every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?

NOTE 1: If a box has an odd number of candies then Misha will eat floor(odd/2).
NOTE 2: A same box will not be chosen again.


Problem Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^5
1 <= B <= 10^6


Input Format

The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
The second argument is B, the maximum number of candies Misha like in a box.


Output Format

Return an Integer denoting number of candies Misha will eat.



Example Input

Input 1:

 A = [3, 2, 3]
 B = 4
Input 2:

 A = [1,2,1]
 B = 2


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 She will not eat from the 3rd box as now it has candies greater than B.
 So the number of candies Misha eat is 2.
Explanation 2:

 1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
 She will not eat from the 2nd box as now it has candies greater than B.
 So the number of candies Misha eat is 1. */

public class hw_q2_Misha_and_candies {

    public int solve(int[] A, int B) {

        // build MinHeap of size N
        MinHeap heap = new MinHeap(A.length);
        for (int i = 0; i < A.length; i++) {
            heap.insert(A[i]);
        }

        int total = 0;
        while (!heap.isEmpty() && B >= heap.peekMin()) {
            int x = heap.getMinimum();
            // count candies eaten by Misha
            int candiesEaten = x / 2;
            int leftOverCandies = x - candiesEaten;
            total += candiesEaten;

            // now fetch teh box with mninimum candies and insert again with leftover cadies
            // from earlier box
            if (!heap.isEmpty()) {
                int temp = heap.getMinimum();
                heap.insert(temp + leftOverCandies);
            }
        }

        return total;
    }

    class MinHeap {
        int[] heap;
        int size;

        public MinHeap(int size) {
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
                    if (heap[i] < heap[parentIndex]) {
                        swap(i, parentIndex);
                        i = parentIndex;
                    } else {
                        return;
                    }
                }
            }
        }

        public int getMinimum() {
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
                    int min = Math.min(heap[leftChildIndex], heap[i]);
                    if (rightChildIndex < size) {
                        min = Math.min(min, heap[rightChildIndex]);
                    }

                    if (min == heap[i]) {
                        break;
                    } else if (min == heap[leftChildIndex]) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < size && min == heap[rightChildIndex]) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }

            }
            return x;
        }

        public int peekMin() {
            if (!isEmpty()) {
                return heap[0];
            }
            return -1;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public static void main(String[] args) {

        hw_q2_Misha_and_candies t1 = new hw_q2_Misha_and_candies();

        // test case 1
        int[] A = new int[] { 324, 458, 481, 167, 939, 444, 388, 612, 943, 890, 953, 403, 653, 136, 168, 163, 186,
                471 };
        int answer = t1.solve(A, 231);
        System.out.println(answer); // expected answer 244

        // test case 2
        A = new int[] { 705 };
        answer = t1.solve(A, 895);
        System.out.println(answer); // expected answer 352

        // test case 3
        A = new int[] { 3, 2, 3 };
        answer = t1.solve(A, 4);
        System.out.println(answer); // expected answer 2

        // test case 4
        A = new int[] { 1, 2, 1 };
        answer = t1.solve(A, 2);
        System.out.println(answer); // expected answer 1

    }

}
