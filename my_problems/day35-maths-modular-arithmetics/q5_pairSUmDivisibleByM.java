/**Accepted Solution in Java */
public class Solution {
    public int solve(int[] A, int B) {

        int p = 1000000007;
        long[] freq = new long[B];

        // iterate A and populate frequency array
        for(int i=0;i<A.length;i++) {
            freq[A[i] % B]++;
        }

        long answer = 0;
        int i=1;
        int j=freq.length-1;

        // for freq[0], add it's contribution to answer
        long contribution = (freq[0] * (freq[0]-1)) / 2;
        answer = (answer%p + contribution%p)%p;

        if(B %2 == 0) {
            contribution = (freq[B/2] * (freq[B/2]-1)) / 2;
            answer = (answer%p + contribution%p)%p;
        }

        while(i < j) {
            contribution = ((freq[i]%p) * (freq[j] % p))%p;
            answer = (answer%p + contribution%p)%p;
            i++;
            j--;
        }

        return (int)answer;

    }
}
