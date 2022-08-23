import java.util.*;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII t1 = new CombinationSumII();
        {
            List<List<Integer>> result = t1.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
            System.out.println(result);
        }
        {
            List<List<Integer>> result = t1.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
            System.out.println(result);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> set = new LinkedHashSet<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(0, candidates, target, 0, set, temp);

        return new LinkedList<>(set);
    }

    public void backtrack(int index, int[] A, int target, int sum, Set<List<Integer>> set, List<Integer> temp) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            set.add(new ArrayList<>(temp));
            return;
        }
        if (index == A.length) {
            return;
        }

        for (int i = index; i < A.length; i++) {
            // pick
            temp.add(A[i]);
            sum += A[i];
            backtrack(i + 1, A, target, sum, set, temp);
            sum -= A[i];
            temp.remove(temp.size() - 1);
        }
    }
}
