/**
 * Allocate Books
 * 
 * Problem Description
 * 
 * Given an array of integers A of size N and an integer B.
 * College library has N books,the ith book has A[i] number of pages.
 * You have to allocate books to B number of students so that maximum number of
 * pages alloted to a student is minimum.
 * 
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be
 * allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 * 
 * NOTE: Return -1 if a valid assignment is not possible.
 * 
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i], B <= 10^5
 * 
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * 
 * Output Format
 * Return that minimum possible number
 * 
 * Example Input
 * A = [12, 34, 67, 90]
 * B = 2
 * 
 * Example Output
 * 113
 * 
 * Example Explanation
 * There are 2 number of students. Books can be distributed in following
 * fashion:
 * 1) [12] and [34, 67, 90]
 * Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 * 2) [12, 34] and [67, 90]
 * Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 * 3) [12, 34, 67] and [90]
 * Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class hw_q1_AllocateBooks {

    // TC: O(N * logN)
    public static int allocateBooks(int[] A, int B) {

        int N = A.length;
        if (B > N) {
            // can not be allocated to B students
            return -1;
        }

        // find search space range
        // min would be max no of pages/element from array
        // max value would be sum of all pages~sum of array elements
        int max = A[0];
        int sum = A[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, A[i]);
            sum += A[i];
        }

        // initialize search space
        int answer = -1;
        int l = max;
        int r = sum;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(A, mid, B)) {
                // update possible answer
                answer = mid;
                // search of best possible answer on left side of mid as we have to find minimum
                // maxPages
                r = mid - 1;
            } else {
                // search on right side
                l = mid + 1;
            }
        }

        return answer;
    }

    // check if the books can be allocated to B students with no of books as mid
    public static boolean check(int[] A, int mid, int B) {

        // assign first book to first student
        int currentPages = A[0];
        int students = 1;

        for (int i = 1; i < A.length; i++) {
            // if no of current pages allocated are > mid, Ith can not be allocated to same
            // student
            if ((A[i] + currentPages) > mid) {
                students++;
                currentPages = A[i];
            } else {
                // if no of current pages allocated are <= mid, the book Ith can be allocated to
                // same student
                currentPages += A[i];
            }
        }
        if (students <= B) {
            // if books can be allocated to B students with mid as min no of possible pages
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // A = [12, 34, 67, 90]
        // B = 2
        int[] input1 = { 12, 34, 67, 90 };
        int output1 = allocateBooks(input1, 2); // expected output 113
        System.out.println("answer -> " + output1);

        // A : [ 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91,
        // 94, 57, 1, 53, 8, 44, 68, 90, 24 ]
        // B : 26
        int[] input2 = { 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85,
                45, 28, 91,
                94, 57, 1, 53, 8, 44, 68, 90, 24 };
        int output2 = allocateBooks(input2, 26); // expected output 97
        System.out.println("answer -> " + output2);

        // A : [ 31, 14, 19, 75 ]
        // B : 12
        int[] input3 = { 31, 14, 19, 75 };
        int output3 = allocateBooks(input3, 12); // expected output -1
        System.out.println("answer -> " + output3);
    }

}
