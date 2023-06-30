package n_meeting_in_one_rooms;

import java.util.Arrays;

/**
 * Job Sequencing Problem
 *
 * <a href="https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1">Job Sequencing Problem</a>
 */
public class JobSequencingProblem_gfg {

    public static void main(String[] args) {

        // test 1
        Job[] jobs = new Job[4];
        jobs[0] = new Job(1, 4, 20);
        jobs[1] = new Job(2, 1, 10);
        jobs[2] = new Job(3, 1, 40);
        jobs[3] = new Job(4, 1, 30);
        int n = 4;
        System.out.println(Arrays.toString(new JobSequencingProblem_gfg().JobScheduling(jobs, n)));
    }

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // sort in descending order of profits
        Arrays.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });

        // find max deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        int[] visited = new int[maxDeadline + 1];
        Arrays.fill(visited, -1);

        int maxProfit = 0;
        int taskCount = 0;
        for (int i = 0; i < n; i++) {
            int currDeadline = arr[i].deadline;
            int currProfit = arr[i].profit;

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
        return new int[]{taskCount, maxProfit};
    }

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
