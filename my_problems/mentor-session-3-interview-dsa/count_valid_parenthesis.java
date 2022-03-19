import java.util.ArrayList;

/* https://leetcode.com/problems/generate-parentheses/ */

/**
 * 
 * n = 3
 * 
 * (( () ))
 * ())(())
 * 
 * 
 * 
 * ()()()
 * 
 * ((()))
 * 
 * ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * n =1
 * ()
 * 
 * n=2
 * ()()
 * (())
 * 
 * n=3;
 * "((()))" l = 6
 * "((()))"
 * 
 * (
 * ( )
 * ( ) ( )
 * null ) false
 * 
 * 2n = height(tree)
 **/

/*
 * 
 * (
 * (
 * )
 * ( )
 */
class TNode {

    Character c;
    TNode left;
    TNode right;

    public TNode(Character c) {
        this.c = c;
        this.left = null;
        this.right = null;
    }

    public TNode(Character c, TNode left, TNode right) {
        this.c = c;
        this.left = null;
        this.right = null;
    }
}

public class count_valid_parenthesis {

    static int count = 0;

    public static void main(String[] args) {

        int n = 3;
        ArrayList<Character> temp = new ArrayList<Character>();
        temp.add('(');
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        solve(1, n, 1, 0, temp, sb);
        System.out.println("valid parenthesis: " + count);

    }

    // ()) -> break

    private static void solve(int level, int n, int leftCount, int rightCount, ArrayList<Character> temp,
            StringBuilder sb) {

        // base condition
        if (level == 2 * n && leftCount == rightCount) {
            // valid parenthesis
            count++;
            ArrayList<Character> path = new ArrayList<Character>(temp);
            System.out.println(path);
            System.out.println(sb.toString());
        }

        if (rightCount > leftCount) {
            return;
        }
        if (leftCount > n) {
            return;
        }

        temp.add('(');
        sb.append('(');
        solve(level + 1, n, leftCount + 1, rightCount, temp, sb);
        temp.remove(temp.size() - 1);
        sb.deleteCharAt(sb.length() - 1);

        temp.add(')');
        sb.append(')');
        solve(level + 1, n, leftCount, rightCount + 1, temp, sb);
        temp.remove(temp.size() - 1);
        sb.deleteCharAt(sb.length() - 1);

    }

}