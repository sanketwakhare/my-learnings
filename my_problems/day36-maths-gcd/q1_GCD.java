/**
 * Iterative solution
 * TC: O(log(max(a,b)))
 */
public class Solution {

    // custom function to calculate the GCD
    public int myGcd(int a, int b) {

        // make sure to maintain the value of a < b
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // repeat while a becomes 0
        while(a > 0) {
            // make to maintain a < b
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            // update value of a and b
            int temp = a;
            a = b % a;   
            b = temp;         
        }
        // return final answer
        return b;
    }

    public int gcd(int A, int B) {

        return myGcd(A,B);

    }
}
