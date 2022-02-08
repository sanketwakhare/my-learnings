import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class q1_FirstNonRepeatingCharacter {

    public static String solve(String A) {

        // initialize HashMap
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // initialize simple Queue
        Queue<Character> queue = new LinkedList<Character>();
        // initialize output string
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {

            char currentChar = A.charAt(i);

            // step 1 : insert new character into HashMap and update frequency
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                // It means the character is repeating and can not be possible answer
                // update frequency in map
                map.put(currentChar, map.get(currentChar) + 1);
            }

            // step 2: update queue - add current character only when it's frequency is == 1
            if (map.get(currentChar) == 1) {
                queue.add(currentChar);
            }

            // step 3: remove all elements from front whose frequencey in map > 1 as these
            // can not be possible answers
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.remove();
            }

            // step 4: update answer
            if (queue.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(queue.peek());
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // test case 1
        System.out.println("answer -> " + solve("abadbc"));
        // test case 2
        System.out.println("answer -> " + solve("abcabc"));
        // test case 3
        System.out.println("answer -> " + solve("ab"));
        // test case 4
        System.out.println("answer -> " + solve("iergxwhddh"));
        // test case 5
        System.out.println("answer -> " + solve("hspkzrqozquywqsnumncuclkrrwsormkfprzotxrcotbnteiizlvt"));
        // test case 6
        System.out.println("answer -> " + solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
    }

}
