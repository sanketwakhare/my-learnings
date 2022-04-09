import java.util.LinkedList;
import java.util.Queue;

/*  Find Product for all subarray of windows of size K */
public class Solution_1 {

    public int[] solve(int[] A, int k) {
        // 10 k= 3
        int N = A.length;
        int[] ans = new int[N - k + 1];

        Queue<Integer> q = new LinkedList<Integer>();
        int prod = 1;
        // temp product without 0s
        int t_prod = 1;
        // maintain the freq of 0s in current subarray
        int count = 0;
        for (int i = 0; i < k; i++) {
            q.add(A[i]);
            prod = prod * A[i];
            if (A[i] != 0) {
                t_prod = t_prod * A[i];
            } else {
                count++;
            }
        }
        ans[0] = prod;

        int index = 1;
        for (int i = k; i < N; i++) {

            int newEle = A[i];
            if (newEle == 0) {
                // increase frequency of 0
                count++;
            }

            int oldEle = q.poll();
            if (oldEle == 0) {
                // decrement frequency of 0
                count--;
            }

            q.add(newEle);

            if (oldEle != 0) {
                prod = prod / oldEle * newEle;
                t_prod = t_prod / oldEle * newEle;
            }
            if (prod == 0 && count == 0) {
                // if there are no 0s left in current subarray, update product
                prod = t_prod * newEle;
            }

            // update answer
            ans[index++] = prod;
        }
        return ans;
    }

    public static void main(String[] args) {

        Solution_1 o = new Solution_1();

        {
            int[] A = new int[] { 3, 4, 0, 5, 1, 3, 10, 5, 0, 4, 9, 0 };
            int k = 3;
            int[] ans = o.solve(A, k);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        {
            int[] A = new int[] { 3, 6, 0, 2, 8, 2, 5, 3, 4, 2, 1, 3 };
            int k = 5;
            int[] ans = o.solve(A, k);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

    }

}
