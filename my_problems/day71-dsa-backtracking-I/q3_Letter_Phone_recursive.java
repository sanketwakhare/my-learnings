/* Letter Phone */

/* Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.


Problem Constraints

1 <= |A| <= 10


Input Format

The only argument is a digit string A.


Output Format

Return a string array denoting the possible letter combinations.


Example Input

Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output

Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


Example Explanation

Explanation 1:

 There are 9 possible letter combinations.
Explanation 2:

 Only 3 possible letter combinations. */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/***
 * Recursive Approach
 * TC: O(N^k) where N is no of digits and k = max no of letters in a digit
 * SC: O(N^k) to store all combinations + stack space
 */
public class q3_Letter_Phone_recursive {
    public ArrayList<String> letterCombinations(String A) {

        ArrayList<String> result = new ArrayList<String>();

        // build dictionary of characters
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(A, 0, new StringBuilder(), map, result);

        System.out.println(result);
        return result;

    }

    private void backtrack(String digits, int index, StringBuilder sb, Map<Character, String> map,
            ArrayList<String> result) {

        // base condition
        if (digits.length() == index) {
            result.add(sb.toString());
            return;
        }

        String values = map.get(digits.charAt(index));
        for (int i = 0; i < values.length(); i++) {
            // do
            sb.append(values.charAt(i));
            // recursive call
            backtrack(digits, index + 1, sb, map, result);
            // undo
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        q3_Letter_Phone_recursive t1 = new q3_Letter_Phone_recursive();
        t1.letterCombinations("23"); // [ad, ae, af, bd, be, bf, cd, ce, cf]
        t1.letterCombinations("173"); // [1pd, 1pe, 1pf, 1qd, 1qe, 1qf, 1rd, 1re, 1rf, 1sd, 1se, 1sf]
        t1.letterCombinations("432"); // [gda, gdb, gdc, gea, geb, gec, gfa, gfb, gfc, hda, hdb, hdc, hea, heb, hec,
                                      // hfa, hfb, hfc, ida, idb, idc, iea, ieb, iec, ifa, ifb, ifc]
        t1.letterCombinations("4356"); // [gdjm, gdjn, gdjo, gdkm, gdkn, gdko, gdlm, gdln, gdlo, gejm, gejn, gejo,
                                       // gekm, gekn, geko, gelm, geln, gelo, gfjm, gfjn, gfjo, gfkm, gfkn, gfko, gflm,
                                       // gfln, gflo, hdjm, hdjn, hdjo, hdkm, hdkn, hdko, hdlm, hdln, hdlo, hejm, hejn,
                                       // hejo, hekm, hekn, heko, helm, heln, helo, hfjm, hfjn, hfjo, hfkm, hfkn, hfko,
                                       // hflm, hfln, hflo, idjm, idjn, idjo, idkm, idkn, idko, idlm, idln, idlo, iejm,
                                       // iejn, iejo, iekm, iekn, ieko, ielm, ieln, ielo, ifjm, ifjn, ifjo, ifkm, ifkn,
                                       // ifko, iflm, ifln, iflo]
        t1.letterCombinations("675"); // [mpj, mpk, mpl, mqj, mqk, mql, mrj, mrk, mrl, msj, msk, msl, npj, npk, npl,
                                      // nqj, nqk, nql, nrj, nrk, nrl, nsj, nsk, nsl, opj, opk, opl, oqj, oqk, oql,
                                      // orj, ork, orl, osj, osk, osl]
        t1.letterCombinations("1612"); // [1m1a, 1m1b, 1m1c, 1n1a, 1n1b, 1n1c, 1o1a, 1o1b, 1o1c]
    }

}
