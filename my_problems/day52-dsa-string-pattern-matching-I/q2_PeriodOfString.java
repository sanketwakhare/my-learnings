public class q2_PeriodOfString {

    public static int solve(String A) {

        // Idea: to use pattern matching algorithm

        // Use z - algorithm
        int N = A.length();
        int[] zArray = new int[A.length()];
        zArray[0] = N;

        // maintain pink windows as discussed in class
        // L and R are start and end indices are second window, the first window will be
        // from 0 to L-R
        int L = 0;
        int R = 0;
        for (int i = 1; i < N; i++) {

            // Brute force code - when s[i] is outside second window
            if (i > R) {
                // update start of second window
                L = i;

                // initialize R
                R = i;
                while (R < N && A.charAt(R) == A.charAt(R - L)) {
                    // R-L will give corresponding element from first window
                    R++;
                }

                // update zArray value for ith element
                zArray[i] = R - L;
                // when brute force is finished, update end index of newly created windows
                R--;

            } else {

                int j = i - L;
                if (zArray[j] < R - i + 1) {
                    // if element zArray value is within window size-- within boundary
                    // copy the value as it is. this is the optimization with this approach
                    zArray[i] = zArray[j];
                } else {
                    // update start index of second window
                    L = i;
                    //
                    R++;
                    while (R < N && A.charAt(R) == A.charAt(R - L)) {
                        // R-L will give corresponding element from first window
                        R++;
                    }
                    // update zArray value for ith element
                    zArray[i] = R - L;
                    // set end index of second pink window
                    R--;
                }
            }
        }

        // the period of string will always lie within 1 to length
        // initialize period value as length of string
        int periodValue = A.length();
        for (int i = 1; i < A.length(); i++) {
            if (i + zArray[i] == A.length()) {
                // update period
                periodValue = i;
                break;
            }
        }

        System.out.println("period -> " + periodValue);
        return periodValue;
    }

    public static void main(String[] args) {

        solve("abababab");
        solve("aaaa");
        solve("abcdabcdab");
        solve("abcpqrdabcdab");
        solve("abcpqrdabcabcd");
        solve("abcpqrdabcabc");

    }

}
