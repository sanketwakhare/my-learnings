public class q4_AthMagicalNumber {

    // custom function to calculate the GCD
    public static long gcd(long a, long b) {

        // make sure to maintain the value of a < b
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        // repeat while a becomes 0
        while (a > 0) {
            // make to maintain a < b
            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }
            // update value of a and b
            long temp = a;
            a = b % a;
            b = temp;
        }
        // return final answer
        return b;
    }

    public static long getCountOfMultiplesTillN(long N, long A, long B) {
        long x = N;
        long a = A;
        long b = B;
        // find Ath number multiple of either B or C
        long mult = a * b;
        long lcm = mult / (long) gcd(A, B);

        long ans = (x / a) + (x / b) - (x / lcm);
        return ans;
    }

    public static long AthMagicalNumber(long N, long A, long B) {

        // define search space
        long l = Math.min(A, B);
        long r = l * N;

        long ans = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long count = getCountOfMultiplesTillN(mid, A, B);
            if (count == N) {
                // update answer and check for better answer on left
                ans = mid;
                r = mid - 1;
            } else if (count < N) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {

        // AthMagicalNumber(10, 2, 3);
        // AthMagicalNumber(2, 2, 3);
        // AthMagicalNumber(4, 2, 3);
        // AthMagicalNumber(6, 5, 7);
        AthMagicalNumber(807414236, 3788, 38141); // expected result 238134151

    }

}
