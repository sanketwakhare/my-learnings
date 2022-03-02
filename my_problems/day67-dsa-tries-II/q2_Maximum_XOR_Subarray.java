import java.util.HashMap;
import java.util.Map;

/* Maximum XOR Subarray */

/* Problem Description

Given an array A of integers of size N. Find the subarray AL, AL+1, AL+2, … AR with 1<=L<=R<=N which has maximum XOR value.

NOTE: If there are multiple subarrays with same maximum value, return the subarray with minimum length. If length is same, return the subarray with minimum starting index.



Problem Constraints

1 <= N <= 100000
0 <= A[i] <= 109



Input Format

First and only argument is an integer array A.



Output Format

Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.



Example Input

Input 1:

 A = [1, 4, 3]
Input 2:

 A = [8]


Example Output

Output 1:

 [2, 3]
Output 2:

 [1, 1]


Example Explanation

Explanation 1:

 There are 6 possible subarrays of A:
 subarray            XOR value
 [1]                     1
 [4]                     4
 [3]                     3
 [1, 4]                  5 (1^4)
 [4, 3]                  7 (4^3)
 [1, 4, 3]               6 (1^4^3)

 [4, 3] subarray has maximum XOR value. So, return [2, 3].
Explanation 2:

 There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].  */
public class q2_Maximum_XOR_Subarray {

    class TrieNode {
        Character data;
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(Character data) {
            this.data = data;
            this.isEnd = false;
            this.children = new TrieNode[2];
        }
    }

    public TrieNode buildTrie(int[] pf, int maxHeight) {
        TrieNode trie = new TrieNode('$');
        for (int i = 0; i < pf.length; i++) {
            TrieNode curr = trie;
            int currEle = pf[i];
            for (int j = maxHeight; j >= 0; j--) {
                boolean isSetBit = isSetBit(currEle, j);
                int ind = isSetBit ? 1 : 0;
                Character data = isSetBit ? '1' : '0';
                if (curr.children[ind] == null) {
                    curr.children[ind] = new TrieNode(data);
                }
                curr = curr.children[ind];
            }
            curr.isEnd = true;
        }
        return trie;
    }

    public boolean isSetBit(int a, int i) {
        if (((a >> i) & 1) == 1) {
            return true;
        }
        return false;
    }

    public int[] solve(int[] A) {

        // generate prefix XOR array
        int[] pf = new int[A.length];
        Map<Integer, Integer> pfMap = new HashMap<Integer, Integer>();
        pf[0] = A[0];
        pfMap.put(pf[0], 0);
        int max = pf[0];
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i - 1] ^ A[i];
            pfMap.put(pf[i], i);
            if (pf[i] > max) {
                max = Math.max(max, pf[i]);
                maxIndex = i;
            }
        }

        // find max Height of Trie
        int maxHeight = Integer.toBinaryString(max).length();

        // build Trie with prefix array
        TrieNode trie = buildTrie(pf, maxHeight);

        int[] answer = findMaxXOR(trie, pf, maxHeight, pfMap, max, maxIndex);
        answer[0] = answer[0] + 1;
        answer[1] = answer[1] + 1;
        System.out.println(answer[0] + ", " + answer[1]);
        return answer;
    }

    private int[] findMaxXOR(TrieNode trie, int[] pf, int maxHeight, Map<Integer, Integer> pfMap, int max,
            int maxIndex) {

        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = maxIndex;
        int minLength = maxIndex - 0 + 1;
        int minStartIndex = 1;
        int maxXOR = max;

        // iterate over prefix XOR array find max XOR
        for (int i = 0; i < pf.length; i++) {
            TrieNode curr = trie;
            int currEle = pf[i];
            int retrievedNo = 0;
            for (int j = maxHeight; j >= 0; j--) {
                // check for toggled bit value
                boolean isSetBit = !isSetBit(currEle, j);
                int ind = isSetBit ? 1 : 0;
                // Character data = isSetBit ? '1' : '0';

                if (curr.children[ind] != null) {
                    curr = curr.children[ind];
                    retrievedNo += Math.pow(2, j) * ind;
                } else {
                    // toggle value
                    ind = Math.abs(ind - 1);
                    if (curr.children[ind] != null) {
                        curr = curr.children[ind];
                        retrievedNo += Math.pow(2, j) * ind;
                    }
                }
            }

            int currXOR = retrievedNo ^ currEle;
            if (currXOR >= maxXOR) {
                int indOfRetrievedEle = pfMap.get(retrievedNo);
                int currStartIndex = Math.min(indOfRetrievedEle, i) + 1;
                int currEndIndex = Math.max(i, indOfRetrievedEle);
                int currLengthOfSubarray = Math.abs(indOfRetrievedEle - i) + 1;

                if ((currXOR > maxXOR) ||
                        (currXOR == maxXOR && currLengthOfSubarray < minLength) ||
                        (currXOR == maxXOR && currLengthOfSubarray == minLength && currStartIndex < minStartIndex)) {
                    answer[0] = currStartIndex;
                    answer[1] = currEndIndex;
                    minStartIndex = currStartIndex;
                    maxXOR = currXOR;
                    minLength = currLengthOfSubarray;
                }
            }
        }
        System.out.println("max XOR -> " + maxXOR);
        return answer;
    }

    public static void main(String[] args) {
        q2_Maximum_XOR_Subarray t1 = new q2_Maximum_XOR_Subarray();
        t1.solve(new int[] { 1, 4, 3 }); // expected output [2,3]

        q2_Maximum_XOR_Subarray t2 = new q2_Maximum_XOR_Subarray();
        t2.solve(new int[] { 8 }); // expected output [1,1]

        q2_Maximum_XOR_Subarray t3 = new q2_Maximum_XOR_Subarray();
        t3.solve(new int[] { 1, 2, 3, 4, 5 }); // expected output [3,4]

        q2_Maximum_XOR_Subarray t4 = new q2_Maximum_XOR_Subarray();
        t4.solve(new int[] { 9, 7, 5, 3, 1 }); // expected output [1,2]

        q2_Maximum_XOR_Subarray t5 = new q2_Maximum_XOR_Subarray();
        t5.solve(new int[] { 5, 4, 8, 12, 6, 2, 9, 11, 13, 3 }); // expected output [7,9]

        q2_Maximum_XOR_Subarray t6 = new q2_Maximum_XOR_Subarray();
        t6.solve(new int[] { 3, 2, 4, 9, 7, 6, 5, 1 }); // expected output [2,4]

        q2_Maximum_XOR_Subarray t7 = new q2_Maximum_XOR_Subarray();
        t7.solve(new int[] { 15, 25, 23 }); // expected output [2,2]
    }

}
