import java.util.*;

public class q3_Free_Cars_practise {

    public int solve(int[] A, int[] B) {

        // sort the entries in ascending order by time
        List<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < A.length; i++) {
            pairs.add(new Pair(A[i], B[i]));
        }
        Collections.sort(pairs, new TimeComparator());

        // min heap with profit to get the amx profit
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int currDay = 0;
        for (Pair pair : pairs) {
            if (pair.time > currDay) {
                currDay++;
                pq.add(pair.profit);
            } else if (pq.peek() < pair.profit) {
                pq.poll();
                pq.add(pair.profit);
            }
        }

        // calculate profit
        long m = 1000000007;
        long maxProfit = 0;
        while (!pq.isEmpty()) {
            long currProfit = (long) pq.poll();
            maxProfit = (maxProfit % m + currProfit % m) % m;
        }
        return (int) maxProfit;
    }

    // custom class pair
    class Pair {
        int time;
        int profit;

        public Pair(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }

    // custom comparator
    class TimeComparator implements Comparator<Pair> {

        public int compare(Pair o1, Pair o2) {
            return o1.time - o2.time;
        }
    }
}

