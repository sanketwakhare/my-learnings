import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QuickSorter implements Callable<List<Integer>> {

    List<Integer> numbers;

    public QuickSorter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> call() throws Exception {

        if (this.numbers.size() == 0) {
            return new ArrayList<Integer>();
        }
        if (this.numbers.size() == 1) {
            return new ArrayList<Integer>(this.numbers);
        }

        List<Integer> result = new ArrayList<Integer>();
        List<Integer> leftPart = new ArrayList<Integer>();
        List<Integer> rightPart = new ArrayList<Integer>();

        int pivot = this.numbers.get(0);
        int i = 1;
        int j = this.numbers.size() - 1;

        while (i <= j) {
            if (this.numbers.get(i) <= pivot) {
                i++;
            } else if (this.numbers.get(j) > pivot) {
                j--;
            } else {
                // swap i and j elements
                int temp = this.numbers.get(i);
                this.numbers.set(i, this.numbers.get(j));
                this.numbers.set(j, temp);
            }
        }

        // swap pivot and i-1
        if (0 != i - 1) {
            int temp = pivot;
            this.numbers.set(0, this.numbers.get(i - 1));
            this.numbers.set(i - 1, temp);
        }

        int sortedPos = i - 1;
        // prepare left and right array as sub problems to solve
        for (i = 0; i < sortedPos; i++) {
            leftPart.add(this.numbers.get(i));
        }
        for (i = sortedPos + 1; i < this.numbers.size(); i++) {
            rightPart.add(this.numbers.get(i));
        }

        QuickSorter leftSorter = new QuickSorter(leftPart);
        QuickSorter rightSorter = new QuickSorter(rightPart);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<Integer>> leftSortedFuture = executor.submit(leftSorter);
        Future<List<Integer>> rightSortedFuture = executor.submit(rightSorter);

        List<Integer> leftSorted = leftSortedFuture.get();
        List<Integer> rightSorted = rightSortedFuture.get();

        // shutdown the executor
        executor.shutdown();

        // combine lists into result
        result.addAll(leftSorted);
        result.add(pivot);
        result.addAll(rightSorted);
        return result;
    }
}