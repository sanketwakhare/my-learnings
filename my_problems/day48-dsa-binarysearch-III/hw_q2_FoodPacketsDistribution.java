/* Food Packets Distribution */

/* Problem Description

The government wants to set up B distribution offices across N cities for the distribution of food
packets. The population of the ith city is A[i]. Each city must have at least 1 office, and people can go to an office of their own city. We want to maximize the minimum number of people who can get food in any single office.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^6
1 <= B <= 5 x 10^5

Input Format
The first line of input contains an integer array A. 
The second line of input contains an integer B.

Output Format
Return one integer representing the maximum number of people who can get food in any single office.

Example Input
Input 1:
  A = [10000, 20000, 30000]
  B = 6
Input 2:
  A = [1, 1, 1]
  B = 4

Example Output
Output 1:
  10000
Output 2:
  0

Example Explanation
Explanation 1:
  1 office can be opened in the first city,
  2 offices in the second city and
  3 in the third. This way ,
  10,000 people can get food in the office in the first city, and
  10,000 people can get food in each office in the second city and
  10,000 people can get food in third city.
  We will allot 10000 people in each office in the third city. 
  Had we alloted more in some office, we had to allot lesser in some other office which will reduce the answer.
Explanation 2:
  We will have to allot 2 offices to one city. And one of these offices would give food to 0 people.  */

public class hw_q2_FoodPacketsDistribution {

  public static int foodPacketDistribution(int[] A, int B) {

    // find min
    int min = A[0];
    long sum = 0;
    for (int i = 0; i < A.length; i++) {
      min = Math.min(min, A[i]);
      sum += A[i];
    }

    // edge case when B is > sum
    if (sum < B) {
      return 0;
    }

    // define search space
    int l = 1;
    int r = min;
    // initialize answer with min value of serach space
    int answer = l;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (check(A, B, mid)) {
        // update answer when officeCount <= required no of office to set B
        answer = mid;
        // go to right as we have to find maximum min-people to server
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return answer;
  }

  public static boolean check(int[] A, int B, int mid) {

    int officesCount = 0;
    for (int i = 0; i < A.length; i++) {
      officesCount += (A[i] / mid);
    }

    if (officesCount >= B) {
      // return false when officeCount >= required no of office to set B
      return true;
    }
    // return true when officeCount < required no of office to set B
    return false;
  }

  public static void main(String[] args) {

    int[] A1 = { 10, 20, 20, 10, 30 };
    int output1 = foodPacketDistribution(A1, 5); // expected output 10
    System.out.println("answer ->" + output1);

    int[] A2 = { 10000, 20000, 30000 };
    int output2 = foodPacketDistribution(A2, 6); // expected output 10000
    System.out.println("answer ->" + output2);

    int[] A3 = { 1, 1, 1 };
    int output3 = foodPacketDistribution(A3, 4); // expected output 0
    System.out.println("answer ->" + output3);

    int[] A4 = { 2, 9, 5, 4 };
    int output4 = foodPacketDistribution(A4, 13); // expected output 1
    System.out.println("answer ->" + output4);

    int[] A5 = { 8, 7, 1, 5, 5, 10, 10, 1, 5, 3 };
    int output5 = foodPacketDistribution(A5, 17); // expected output 1
    System.out.println("answer ->" + output5);
  }

}
