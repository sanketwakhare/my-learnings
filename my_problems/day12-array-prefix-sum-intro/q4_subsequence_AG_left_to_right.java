public class q4_subsequence_AG_left_to_right {

    public int solve(String A) {
        long countA = 0;
        long countG = 0;
        long answer = 0;
        long m = 1000000007;

        for (int i = 0; i < A.length(); i++) {
            char currChar = A.charAt(i);

            if (currChar == 'A') {
                countA++;
            } else if (currChar == 'G') {
                countG++;

                // update answer
                long subsequenceCount = ((countA % m) * (countG % m)) % m;
                answer = ((answer % m) + (subsequenceCount % m)) % m;
                // reset count g
                countG = 0;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        q4_subsequence_AG_left_to_right t1 = new q4_subsequence_AG_left_to_right();
        String A;
        {
            A = new String("ABCGAG");
            System.out.println(t1.solve(A)); // 3
        }
        {
            A = new String("GAB");
            System.out.println(t1.solve(A)); // 0
        }
        {
            A = new String("ADGAGAGFG");
            System.out.println(t1.solve(A)); // 9
        }
    }
}
