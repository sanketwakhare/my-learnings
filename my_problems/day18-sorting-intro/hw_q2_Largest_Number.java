/* Largest Number-custom sorting with String type */

import java.util.Arrays;

public class hw_q2_Largest_Number {

    class Pair implements Comparable<Pair> {
        String s;

        public Pair(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            String s1 = this.s + o.s;
            String s2 = o.s + this.s;
            return s2.compareTo(s1);
        }
    }

    public String largestNumber(final int[] A) {

        // step1: convert integer array to string array
        Pair[] stringArray = new Pair[A.length];
        for (int i = 0; i < A.length; i++) {
            stringArray[i] = new Pair(((Integer) A[i]).toString());
        }

        // sort sting array in descending order - custom sorting
        Arrays.sort(stringArray);

        // append every element of string array to answer
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            answer.append(stringArray[i].s);
        }

        // trim 0s from front - edge case
        while (answer.length() > 1 && answer.charAt(0) == '0') {
            answer.deleteCharAt(0);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        hw_q2_Largest_Number t1 = new hw_q2_Largest_Number();
        System.out.println(t1.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
        System.out.println(t1.largestNumber(new int[] { 2, 3, 9, 0 }));
        System.out.println(t1.largestNumber(new int[] { 9, 0, 9, 9 }));
        System.out.println(t1.largestNumber(new int[] { 0, 0, 0, 0 }));
        System.out.println(t1.largestNumber(new int[] { 0, 2, 0, 0 }));
        System.out.println(t1.largestNumber(new int[] { 0, 2, 1, 0 }));
    }
}
