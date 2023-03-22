/* 1% Sampling */
/* Your job is to write a function that does 1% sampling - this is to say the function returns true approx 1% of the time. Note that you want to keep that 1% truly random and spread out. This function could exist separately on different machines. Hence it could be initiated multiple times across machines.

Note:- An error rate of 5% is allowed. No global variables should be used. */
package typeahead;

public class  OnePercentFilter {
    Boolean filter() {
        // Complete the function
        double number = Math.random();
        int counter = (int)(number*100) + 1;
        if(counter == 50) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OnePercentFilter filter = new OnePercentFilter();

        int trueCount = 0;
        int falseCount = 0;

        // Test the filter 100,000 times
        for (int i = 0; i < 100000; i++) {
            boolean result = filter.filter();
            if (result) {
                trueCount++;
            } else {
                falseCount++;
            }
        }

        // Check that the number of true results is close to 1% of the total
        double truePercentage = ((double)trueCount / 100000) * 100;
        double error = Math.abs(truePercentage - 1.0);
        System.out.println(error); // Acceptable error rate of 0.5%
    }
}