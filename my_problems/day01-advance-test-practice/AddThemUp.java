import java.util.ArrayList;
import java.util.List;

public class AddThemUp {
    public int[] solve(int A) {

        List<Integer> list = new ArrayList<Integer>();
        String a = String.valueOf(A);
        int temp = (a.length() - 1) * 10;

        if (temp == 0)
            temp = 1;

        int start = A - temp;
        for (int i = start; i <= A; i++) {

            int sum = sum(i);
            if ((i + sum) == A) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        int i = 0;
        for (Integer no : list) {
            answer[i++] = no;
            System.out.println(no + " ");
        }
        if (answer.length == 0) {
            return new int[] { -1 };
        }
        return answer;
    }

    public int sum(int A) {
        int sum = 0;
        while (A > 0) {
            sum += A % 10;
            A = A / 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        AddThemUp t1 = new AddThemUp();
        t1.solve(30);
        t1.solve(100);
        t1.solve(1000);
        t1.solve(2);
    }

}
