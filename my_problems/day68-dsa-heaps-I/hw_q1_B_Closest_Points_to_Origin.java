/* B Closest Points to Origin */

/* Problem Description

We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).


Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000


Input Format
The argument given is list A and an integer B.

Output Format
Return the B closest points to the origin (0, 0) in any order.


Example Input

Input 1:

 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1


Example Output

Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]


Example Explanation

Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1]. */

/**
 * TC: O(N logN) => insert operation and extract min operation for N elements
 * SC: O(N) =>space to build heap
 */
public class hw_q1_B_Closest_Points_to_Origin {

    public int[][] solve(int[][] A, int B) {

        MinHeap heap = new MinHeap(A.length);
        for (int i = 0; i < A.length; i++) {
            heap.insert(new HeapElement(A[i][0], A[i][1]));
        }

        int[][] output = new int[B][2];
        int i = 0;
        while (B > 0) {
            HeapElement minEle = heap.getMinimum();
            output[i][0] = minEle.point.x;
            output[i][1] = minEle.point.y;
            B--;
            i++;
        }
        return output;

    }

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class HeapElement {
        double distance;
        Coordinate point;

        public HeapElement(int x, int y) {
            this.point = new Coordinate(x, y);
            this.distance = Math.sqrt((x * x) + (y * y));
        }
    }

    class MinHeap {
        HeapElement[] heap;
        int size;

        public MinHeap(int size) {
            this.heap = new HeapElement[size];
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public HeapElement[] getHeap() {
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

        public void insert(HeapElement x) {

            // insert x into last position
            if (!isFull()) {
                heap[size] = x;
                size++;

                int i = size - 1;
                while (i > 0) {
                    int parentIndex = (i - 1) / 2;
                    if (heap[i].distance < heap[parentIndex].distance) {
                        swap(i, parentIndex);
                        i = parentIndex;
                    } else {
                        return;
                    }
                }
            }
        }

        public HeapElement getMinimum() {
            HeapElement x = null;
            if (!isEmpty()) {
                x = heap[0];
                // swap last element and x
                swap(0, size - 1);
                heap[size - 1] = null;
                size--;

                int i = 0;

                while ((2 * i) + 1 < size) {
                    int leftChildIndex = (2 * i) + 1;
                    int rightChildIndex = (2 * i) + 2;
                    double min = Math.min(heap[leftChildIndex].distance, heap[i].distance);
                    if (rightChildIndex < size) {
                        min = Math.min(min, heap[rightChildIndex].distance);
                    }

                    if (min == heap[i].distance) {
                        break;
                    } else if (min == heap[leftChildIndex].distance) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < size && min == heap[rightChildIndex].distance) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }

            }
            return x;
        }

        private void swap(int i, int j) {
            HeapElement temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

    }

    public static void main(String[] args) {

        // test case 1
        hw_q1_B_Closest_Points_to_Origin t1 = new hw_q1_B_Closest_Points_to_Origin();
        int[][] A = new int[][] { { 1, 3 }, { -2, 2 } };
        int[][] out = t1.solve(A, 1);
        for (int i = 0; i < out.length; i++) {
            ArrayUtils.printArray(out[i]);
        }

        // test case 2
        t1 = new hw_q1_B_Closest_Points_to_Origin();
        A = new int[][] { { 1, -1 }, { 2, -1 } };
        out = t1.solve(A, 1);
        for (int i = 0; i < out.length; i++) {
            ArrayUtils.printArray(out[i]);
        }
    }

}
