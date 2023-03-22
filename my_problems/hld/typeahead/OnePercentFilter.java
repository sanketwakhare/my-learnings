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
}