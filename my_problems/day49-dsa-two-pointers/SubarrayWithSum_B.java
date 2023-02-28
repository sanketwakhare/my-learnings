import java.util.ArrayList;
import java.util.List;

public class SubarrayWithSum_B {
    public static void main(String[] args) {
//        A : [ 1, 2, 3, 4, 5 ]
//        B : 5
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        int B = 5;
        SubarrayWithSum_B t1 = new SubarrayWithSum_B();
        System.out.println(t1.solve(A, B));

        A = new ArrayList<>();
        A.add(15);
        A.add(2);
        A.add(5);
        A.add(6);
        A.add(9);
        B = 7;
        System.out.println(t1.solve(A, B));

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        int n = A.size();
        int start = 0;
        int end = 0;
        int sum = A.get(end);
        ArrayList<Integer> result = new ArrayList<>();

        while(start <= end && start < n && end < n) {
            if(sum == B) {
                for(int i=start; i<=end; i++) {
                    result.add(A.get(i));
                }
                return result;
            } else if(sum < B) {
                end++;
                if(end < n) {
                    sum += A.get(end);
                }
            } else {
                sum -= A.get(start);
                start++;
                if(start > end) {
                    end++;
                    if(end < n) {
                        sum += A.get(end);
                    }
                }
            }
        }

        result.add(-1);
        return result;
    }
}
