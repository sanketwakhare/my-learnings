package arrays_interview_prep;

// Find the missing number in Arithmetic Progression
/* https://www.geeksforgeeks.org/find-missing-number-arithmetic-progression/ */
public class ArithmeticProgression_NF {

    public static void main(String[] args) {
        ArithmeticProgression_NF obj = new ArithmeticProgression_NF();
        {
            System.out.println(obj.solve_n(new int[]{2, 4, 8, 10, 12, 14}));
            System.out.println(obj.solve_n(new int[]{1, 6, 11, 16, 21, 31}));
        }
        {
            System.out.println(obj.solve_logN(new int[]{2, 4, 8, 10, 12, 14}));
            System.out.println(obj.solve_logN(new int[]{1, 6, 11, 16, 21, 31}));
            System.out.println(obj.solve_logN(new int[]{1, 11, 21, 31, 51}));
        }

    }

    private int solve_n(int[] nums) {
        // Ap formula
        // sum = (firstTerm + lastTerm) * (n) / 2;

        int n = nums.length;
        int firstTerm = nums[0];
        int lastTerm = nums[n - 1];

        long sum = ((long) (firstTerm + lastTerm) * (long) (n + 1)) / 2;

        long actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return (int) (sum - actualSum);
    }

    private int solve_logN(int[] nums) {
        int n = nums.length;
        int firstTerm = nums[0];
        int lastTerm = nums[n - 1];

        int diff = (lastTerm - firstTerm) / n;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // check diff with next element of mid
            if (nums[mid + 1] - nums[mid] != diff) {
                return nums[mid] + diff;
            }
            // check diff with previous element of mid
            if (mid > 0 && nums[mid] - nums[mid - 1] != diff) {
                return nums[mid - 1] + diff;
            }
            if (nums[mid] == nums[0] + mid * diff) {
                // search on right part
                start = mid + 1;
            } else {
                // search on left part
                end = mid - 1;
            }
        }
        return -1;
    }


}
