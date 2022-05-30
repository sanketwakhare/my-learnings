import java.util.HashSet;
import java.util.Set;

/* use HashSet when we just have check if there exist a pair */
public class Two_Sum_app3 {

    public boolean twoSum(int[] A, int target) {
        // Build HashSet on the Fly
        boolean isPairPresent = false;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            int firstEle = A[i];
            int secondEle = target - firstEle;
            if (set.contains(secondEle)) {
                isPairPresent = true;
                break;
            }
            set.add(firstEle);
        }
        return isPairPresent;
    }

    public static void main(String[] args) {
        Two_Sum_app3 t1 = new Two_Sum_app3();
        int[] A;
        int target;
        {
            A = new int[] { 2, 7, 11, 15 };
            target = 9;
            System.out.println(t1.twoSum(A, target));
        }
        {
            A = new int[] { 3, 3 };
            target = 6;
            System.out.println(t1.twoSum(A, target));
        }
        {
            A = new int[] { 3, 3 };
            target = 5;
            System.out.println(t1.twoSum(A, target));
        }
    }
}
