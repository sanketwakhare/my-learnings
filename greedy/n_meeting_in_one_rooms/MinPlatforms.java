package n_meeting_in_one_rooms;

import java.util.Arrays;

/**
 * Minimum Number of Platforms
 *
 * <a href="https://www.codingninjas.com/studio/problems/799400">Minimum Platforms</a>
 * <a href="https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1">Minimum number of platforms required for a railway/bus station</a>
 */
public class MinPlatforms {

    public static void main(String[] args) {
        // test 1
        int[] start1 = {900, 940, 950, 1100, 1500, 1800};
        int[] end1 = {910, 1200, 1120, 1130, 1900, 2000};
        int n1 = 6;
        System.out.println(calculateMinPlatforms(start1, end1, n1)); // 3

        // test 2
        int[] start2 = {900, 940};
        int[] end2 = {910, 1200};
        int n2 = 2;
        System.out.println(calculateMinPlatforms(start2, end2, n2)); // 1
    }

    public static int calculateMinPlatforms(int at[], int dt[], int n) {

        Arrays.sort(at);
        Arrays.sort(dt);

        int i = 0;
        int j = 0;
        int curr = 0;
        int max = 0;

        while (i < n) {
            if (at[i] <= dt[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
