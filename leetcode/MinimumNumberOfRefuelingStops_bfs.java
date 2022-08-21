import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops_bfs {

    public static void main(String[] args) {
        MinimumNumberOfRefuelingStops_bfs t1 = new MinimumNumberOfRefuelingStops_bfs();
        {
            int target = 1;
            int startFuel = 1;
            int[][] stations = new int[][]{};
            System.out.println(t1.minRefuelStops(target, startFuel, stations));
        }
        {
            int target = 100;
            int startFuel = 1;
            int[][] stations = new int[][]{{10, 100}};
            System.out.println(t1.minRefuelStops(target, startFuel, stations));
        }
        {
            int target = 100;
            int startFuel = 10;
            int[][] stations = new int[][]{{0, 60}, {20, 30}, {30, 30}, {60, 40}};
//            int[][] stations = new int[][]{{10, 10}, {20, 10}, {30, 30}, {60, 90}};
            System.out.println(t1.minRefuelStops(target, startFuel, stations));
        }
        {
            int target = 1000000;
            int startFuel = 796714;
            int[][] stations = new int[][]{{64884, 552396}, {90910, 178472}, {116654, 544451}, {184554, 297300}, {185647, 754697}, {191237, 672007}, {226643, 89460}, {237538, 439850}, {238381, 131944}, {266009, 692656}, {298719, 769526}, {304253, 585245}, {361379, 610887}, {499710, 141692}, {590286, 293507}, {627968, 792153}, {740695, 288304}, {753738, 647324}, {758473, 387124}, {784694, 686000}, {786179, 760641}, {912068, 674254}, {914312, 729410}, {978628, 288861}, {993107, 106321}};
            System.out.println(t1.minRefuelStops(target, startFuel, stations));
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int refill = 0, i = 0;
        int distance = startFuel;

        // refill denotes the min level by which we can reach the destination with min fuel refilling
        while (distance < target) {
            while (i < n && distance >= stations[i][0]) {
                pq.offer(stations[i]);
                i++;
            }

            if (pq.isEmpty()) return -1;

            distance += pq.remove()[1];
            refill++;
        }

        return refill;
    }
}
