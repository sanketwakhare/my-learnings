package strivers_greedy_problems;

import java.util.Arrays;

/**
 * Job Sequencing Problem
 *
 * <a href="https://www.codingninjas.com/studio/problems/job-sequencing-problem_1169460">Job Sequencing Problem</a>
 */
public class JobSequencingProblem_code_studio {

    public static void main(String[] args) {
        // test 1
        int[][] jobs1 = {{2, 40}, {2, 20,}, {1, 10}};
        System.out.println(jobScheduling(jobs1));

        // test 2
        int[][] jobs2 = {{2, 25}, {4, 40}, {1, 5}, {3, 50}, {5, 60}};
        System.out.println(jobScheduling(jobs2));
    }

    public static int jobScheduling(int[][] jobs) {
        // sort in descending order of profits
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        int n = jobs.length;

        // find max deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }

        int[] visited = new int[maxDeadline + 1];
        Arrays.fill(visited, -1);

        int maxProfit = 0;
        int taskCount = 0;
        for (int i = 0; i < n; i++) {
            int currDeadline = jobs[i][0];
            int currProfit = jobs[i][1];

            for (int vis = currDeadline; vis > 0; vis--) {
                if (visited[vis] == -1) {
                    // perform current task at as late as possible
                    visited[vis] = i;
                    maxProfit += currProfit;
                    taskCount++;
                    break;
                }
            }
        }
        return maxProfit;
    }
}
