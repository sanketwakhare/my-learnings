/*  Minimum Number of Refueling Stops - TLE */
public class MinimumNumberOfRefuelingStops_backtracking {

    public static void main(String[] args) {

        MinimumNumberOfRefuelingStops_backtracking t1 = new MinimumNumberOfRefuelingStops_backtracking();

        {
            int target = 1;
            int startFuel = 1;
            int[][] stations = new int[][]{};
            t1.minRefuelStops(target, startFuel, stations);
        }
        {
            int target = 100;
            int startFuel = 1;
            int[][] stations = new int[][]{{10, 100}};
            t1.minRefuelStops(target, startFuel, stations);
        }
        {
            int target = 100;
            int startFuel = 10;
//            int[][] stations = new int[][]{{0, 60}, {20, 30}, {30, 30}, {60, 40}};
            int[][] stations = new int[][]{{10, 10}, {20, 10}, {30, 30}, {60, 90}};
            t1.minRefuelStops(target, startFuel, stations);
        }
        {
            int target = 1000000;
            int startFuel = 796714;
            int[][] stations = new int[][]{{64884, 552396}, {90910, 178472}, {116654, 544451}, {184554, 297300}, {185647, 754697}, {191237, 672007}, {226643, 89460}, {237538, 439850}, {238381, 131944}, {266009, 692656}, {298719, 769526}, {304253, 585245}, {361379, 610887}, {499710, 141692}, {590286, 293507}, {627968, 792153}, {740695, 288304}, {753738, 647324}, {758473, 387124}, {784694, 686000}, {786179, 760641}, {912068, 674254}, {914312, 729410}, {978628, 288861}, {993107, 106321}};
            t1.minRefuelStops(target, startFuel, stations);
        }
    }

    int answer = Integer.MAX_VALUE;

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        answer = Integer.MAX_VALUE;
        backtrack(target, startFuel, stations, 0, 0);
        System.out.println(answer);
        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    public void backtrack(int target, int remFuel, int[][] stations, int index, int count) {

        if (index == stations.length) {
            if (remFuel - target < 0) {
                return;
            }
            // reached destination
            answer = Math.min(count, answer);
            return;
        }

        int currDist;
        if (index == 0) {
            currDist = stations[index][0];
        } else {
            currDist = stations[index][0] - stations[index - 1][0];
        }
        int refillBy = stations[index][1];
        remFuel = remFuel - currDist;
        if (remFuel < 0) {
            return;
        }
        // pick
        backtrack(target - currDist, remFuel + refillBy, stations, index + 1, count + 1);
        // not pick
        backtrack(target - currDist, remFuel, stations, index + 1, count);
    }
}
