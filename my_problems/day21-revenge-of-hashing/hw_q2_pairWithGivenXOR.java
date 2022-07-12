import java.util.HashSet;
import java.util.Set;

public class hw_q2_pairWithGivenXOR {
    public int solve(int[] A, int B) {

        // take xor if each element with target and find if result is present in set
        Set<Integer> set = new HashSet<>();
        int count = 0;
        // find count on the fly
        for(int currEle : A) {
            if(set.contains(currEle ^ B)) {
                count++;
            }
            // add current element into set
            set.add(currEle);
        }
        return count;
    }

    public static void main(String[] args) {
        hw_q2_pairWithGivenXOR t1 = new hw_q2_pairWithGivenXOR();

        System.out.println(t1.solve(new int[] {5, 4, 10, 15, 7, 6}, 5));
        System.out.println(t1.solve(new int[] {3, 6, 8, 10, 15, 50}, 5));
        System.out.println(t1.solve(new int[] {17, 18, 5, 13, 15, 7, 11, 5, 4, 9, 12, 6, 10, 14, 16, 3}, 9));
        System.out.println(t1.solve(new int[] {24, 27, 1, 4, 6, 14, 2, 12, 13, 0, 5, 15, 3, 7, 15, 10}, 9));
    }
}
