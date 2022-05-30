import java.util.HashSet;
import java.util.Set;

/* Longest Consecutive Sequence*/

/* TC: O(N)
SC: O(N) - for HashSet */
public class q3_Longest_Consecutive_Sequence {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {

        // Find out which elements can be start of the sequence

        // Build hashSet
        Set<Integer> set = new HashSet<Integer>();
        for (int ele : A) {
            set.add(ele);
        }

        int maxLength = 1;
        // iterate over HashSet and find if element can be start of the sequence
        for (int ele : set) {
            if (!set.contains(ele - 1)) {
                // ele can be start of the sequence
                int len = 1;
                while (set.contains(ele + 1)) {
                    // iterate until there are elements in increasing order within set
                    ele = ele + 1;
                    len++;
                }
                // update possible better answer
                if (len > maxLength) {
                    maxLength = len;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        q3_Longest_Consecutive_Sequence t1 = new q3_Longest_Consecutive_Sequence();
        int[] A;
        {
            A = new int[] { -1, 8, 2, 3, 7, 1, 4 };
            System.out.println(t1.longestConsecutive(A));
        }
        {
            A = new int[] { 9, 4, 8, 8, 11, 15, 13, 6, 7, 6, 12 };
            System.out.println(t1.longestConsecutive(A));
        }
        {
            A = new int[] { 19, 11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13 };
            System.out.println(t1.longestConsecutive(A));
        }
        {
            A = new int[] { 51, 34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96,
                    18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15,
                    43, 73, 68, 29 };
            System.out.println(t1.longestConsecutive(A));
        }
    }
}
