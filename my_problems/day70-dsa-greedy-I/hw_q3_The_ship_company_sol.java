import java.util.Comparator;
import java.util.PriorityQueue;

public class hw_q3_The_ship_company_sol {
    public int[] solve(int A, int B, int[] C) {

        // initialize max and min profits
        int maxProfit = 0;
        int minProfit = 0;

        // initialize min and max heaps
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int currEle : C) {
            minHeap.add(currEle);
            maxHeap.add(currEle);
        }

        // find max Profit
        int peopleCount = A;
        while (peopleCount > 0) {
            int ticketPrice = maxHeap.poll();
            maxProfit += ticketPrice;
            if (ticketPrice > 1) {
                maxHeap.add(ticketPrice - 1);
            }
            peopleCount--;
        }

        // find min Profit
        peopleCount = A;
        while (peopleCount > 0) {
            int ticketPrice = minHeap.poll();
            minProfit += ticketPrice;
            if (ticketPrice > 1) {
                minHeap.add(ticketPrice - 1);
            }
            peopleCount--;
        }

        return new int[]{maxProfit, minProfit};
    }
}
