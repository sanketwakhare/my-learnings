import java.util.ArrayList;
import java.util.List;

public class q1_Subset {

    public static void main(String[] args) {

        // test case 1
        // int[] A = new int[] { 1 };
        // List<List<Integer>> subsets = solve(A);
        // printSubset(subsets);

        // test case 2
        int[] A = new int[] { 1, 2, 3 };
        List<List<Integer>> subsets = solve(A);
        printSubset(subsets);

        // test case 3
        // A = new int[] { 9, 10, 13 };
        // subsets = solve(A);
        // printSubset(subsets);
    }

    private static void printSubset(List<List<Integer>> subset) {
        for (List<Integer> currSubset : subset) {
            printList(currSubset);
        }
    }

    private static void printList(List<Integer> list) {

        StringBuilder sb = new StringBuilder();
        sb.append("{  ");
        for (Integer item : list) {
            sb.append(item + ", ");
        }
        sb.replace(sb.length() - 2, sb.length(), " ");
        sb.append("}");
        System.out.print("\n" + sb.toString());
    }

    public static List<List<Integer>> solve(int[] A) {

        int n = A.length;
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> subsetList = new ArrayList<List<Integer>>();
        subsets(0, n, A, list, subsetList);
        return subsetList;
    }

    private static void subsets(int i, int n, int[] a, List<Integer> list, List<List<Integer>> subsetList) {

        if (i == n) {
            subsetList.add(new ArrayList<Integer>(list));
            return;
        }

        list.add(a[i]);
        subsets(i + 1, n, a, list, subsetList);

        // backtrack/undo
        list.remove(list.size() - 1);
        subsets(i + 1, n, a, list, subsetList);

    }
}
