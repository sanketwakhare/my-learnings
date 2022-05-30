import java.util.HashSet;
import java.util.Set;

/* Diff K */
/* A[i] - A[j] = K And i!=j */
public class q2_DiffK_II {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int diffPossible(final int[] A, int B) {
        // Build HashSet on the fly
        Set<Integer> set = new HashSet<Integer>();
        for (int firstEle : A) {
            // check both possibilities
            int secondEle1 = firstEle - B;
            int secondEle2 = B + firstEle;
            if (set.contains(secondEle1) || set.contains(secondEle2)) {
                return 1;
            }
            set.add(firstEle);
        }
        return 0;
    }

    public static void main(String[] args) {
        q2_DiffK_II t1 = new q2_DiffK_II();
        int[] A;
        int B;
        {
            A = new int[] { 19, 11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13 };
            B = 60;
            System.out.println(t1.diffPossible(A, B)); // 1
        }
        {
            A = new int[] { 51, 34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96,
                    18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15,
                    43, 73, 68, 29 };
            B = 97;
            System.out.println(t1.diffPossible(A, B)); // 0
        }
    }

}
