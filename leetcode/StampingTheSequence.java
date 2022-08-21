/* Stamping The Sequence */
/*https://leetcode.com/problems/stamping-the-sequence/*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StampingTheSequence {

    public static void main(String[] args) {
        StampingTheSequence t1 = new StampingTheSequence();
        int[] result = t1.movesToStamp("abc", "ababc");
        System.out.println(Arrays.toString(result));
        result = t1.movesToStamp("abca", "aabcaca");
        System.out.println(Arrays.toString(result));
        result = t1.movesToStamp("aye", "eyeye");
        System.out.println(Arrays.toString(result));
    }

    public int[] movesToStamp(String stamp, String target) {

        int tlength = target.length();
        int slength = stamp.length();

        StringBuilder sb = new StringBuilder();
        sb.append("?".repeat(tlength));
        String targetOutput = sb.toString();

        sb = new StringBuilder();
        sb.append("?".repeat(slength));
        String alreadyStamped = sb.toString();

        List<Integer> list = new LinkedList<>();
        boolean canPerform = true;
        while (!target.equals(targetOutput) && canPerform) {
            canPerform = false;
            int ind = target.indexOf(stamp);
            if (ind != -1) {
                String temp = target.substring(ind, ind + slength);
                target = replace(temp, target, ind);
                list.add(0, ind);
                canPerform = true;
            } else {
                for (int i = 0; i <= tlength - slength; i++) {
                    String temp = target.substring(i, i + slength);
                    if (!alreadyStamped.equals(temp) && canReplace(temp, stamp)) {
                        // replace
                        target = replace(temp, target, i);
                        list.add(0, i);
                        canPerform = true;
                    }
                }
            }
        }
        if (!canPerform) return new int[]{};
        return list.stream().mapToInt(i -> i).toArray();
    }

    public boolean canReplace(String temp, String stamp) {
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != stamp.charAt(i) && temp.charAt(i) != '?') {
                return false;
            }
        }
        return true;
    }

    public String replace(String temp, String target, int index) {
        StringBuilder sb = new StringBuilder(target);
        for (int i = index; i < index + temp.length(); i++) {
            sb.setCharAt(i, '?');
        }
        return sb.toString();
    }
}
