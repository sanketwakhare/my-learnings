import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class hw_2_MaximumFrequencyStack {

    int maxFreq;
    Map<Integer, Integer> eleFreqMap;
    Map<Integer, Stack<Integer>> stackFreqMap;

    public hw_2_MaximumFrequencyStack() {
        maxFreq = 0;
        eleFreqMap = new HashMap<Integer, Integer>();
        stackFreqMap = new HashMap<Integer, Stack<Integer>>();
    }

    public int push(int x) {

        int currentFreqOfX = 1;
        // update current frequency x in eleFreqMap
        if (eleFreqMap.containsKey(x)) {
            currentFreqOfX = eleFreqMap.get(x);
            currentFreqOfX = currentFreqOfX + 1;
        }
        eleFreqMap.put(x, currentFreqOfX);

        // update maxFreq value if currentFreqOfX is > maxFreq
        maxFreq = Math.max(maxFreq, currentFreqOfX);

        // update stackFreqMap with currentFreqOfX as key and value in stack
        Stack<Integer> stack;
        if (stackFreqMap.containsKey(currentFreqOfX)) {
            stack = stackFreqMap.get(currentFreqOfX);
            stack.push(x);
        } else {
            stack = new Stack<Integer>();
            stack.push(x);
        }
        stackFreqMap.put(currentFreqOfX, stack);

        return -1;
    }

    public int pop() {

        int x = -1;
        // retrieve the stack of the current max freq element
        if (stackFreqMap.containsKey(maxFreq)) {
            Stack<Integer> stack = stackFreqMap.get(maxFreq);
            x = stack.pop();

            // if there are no more elements with max freq in stack, remove entry and
            // decrement maxFreq
            if (stack.isEmpty()) {
                stackFreqMap.remove(maxFreq);
                maxFreq--;
            }
        }

        // update eleFreqMap for current max freq element
        if (eleFreqMap.containsKey(x)) {
            int currentFreqOfX = eleFreqMap.get(x) - 1;
            if (currentFreqOfX == 0) {
                eleFreqMap.remove(x);
            } else {
                eleFreqMap.put(x, currentFreqOfX);
            }
        }
        return x;
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<Integer> outputList = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> currentRec = A.get(i);
            // System.out.println(currentRec.get(0) + " "+ currentRec.get(1));
            int operation = currentRec.get(0);
            int x = currentRec.get(1);

            int result;
            if (operation == 1) {
                result = push(x);
            } else {
                result = pop();
            }
            outputList.add(result);

        }
        return outputList;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(buildListElement(1, 5));
        A.add(buildListElement(1, 7));
        A.add(buildListElement(1, 5));
        A.add(buildListElement(1, 7));
        A.add(buildListElement(1, 4));
        A.add(buildListElement(1, 5));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));

        hw_2_MaximumFrequencyStack minFreStackMain = new hw_2_MaximumFrequencyStack();
        ArrayList<Integer> outList = minFreStackMain.solve(A);
        System.out.println();
        for (Integer result : outList) {
            System.out.print(result + " ");
        }

    }

    private static ArrayList<Integer> buildListElement(int operation, int x) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(operation);
        list.add(x);
        return list;
    }

}
