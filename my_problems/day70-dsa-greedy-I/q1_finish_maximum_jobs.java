/* Finish Maximum Jobs */

/* Problem Description

There are N jobs to be done but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish maximum number of jobs. Return the maximum number of jobs you can finish.


Problem Constraints
1 <= N <= 10^5
1 <= A[i] < B[i] <= 10^9


Input Format
First argument is an integer array A of size N denoting the start time of the jobs.
Second argument is an integer array B of size N denoting the finish time of the jobs.

Output Format
Return an integer denoting the maximum number of jobs you can finish.

Example Input
Input 1:
 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
Input 2:
 A = [3, 2, 6]
 B = [9, 8, 9]


Example Output

Output 1:
 2
Output 2:
 1

Example Explanation

Explanation 1:
 We can finish the job in the period of time: (1, 7) and (7, 8).
Explanation 2:
 Since all three jobs collide with each other. We can do only 1 job. */

import java.util.Arrays;
import java.util.Comparator;

/* Idea: Pick a pair/job which finishes early */

class Pair {
    int startTime;
    int endTime;

    public Pair(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + startTime + ",").append(endTime + "]");
        return sb.toString();
    }
}

/* Sort in ascending order by endTime */
class EndTimeComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.endTime < o2.endTime) {
            return -1;
        } else if (o1.endTime > o2.endTime) {
            return 1;
        }
        return 0;
    }
}

public class q1_finish_maximum_jobs {

    public int completeMaxJobs(int[] A, int[] B) {

        // build all pairs
        Pair[] pairs = new Pair[A.length];
        for (int i = 0; i < A.length; i++) {
            pairs[i] = new Pair(A[i], B[i]);
        }

        // sort pairs by end time
        Arrays.sort(pairs, new EndTimeComparator());

        // pick a pair/job which finishes early
        int count = 1;
        Pair temp = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i].startTime >= temp.endTime) {
                count++;
                temp = pairs[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {

        q1_finish_maximum_jobs t1 = new q1_finish_maximum_jobs();
        int[] A = new int[] { 1, 5, 7, 1 };
        int[] B = new int[] { 7, 8, 8, 8 };
        System.out.println("answer: " + t1.completeMaxJobs(A, B));

        A = new int[] { 3, 2, 6 };
        B = new int[] { 9, 8, 9 };
        System.out.println("answer: " + t1.completeMaxJobs(A, B));

    }

}