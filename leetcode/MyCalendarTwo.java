/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }

    List<List<Integer>> events;
    List<List<Integer>> doubleBookings;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // apply binary search
        int low = 0;
        int high = events.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            List<Integer> midEvent = events.get(mid);
            int midStart = midEvent.get(0);
            int midEnd = midEvent.get(1);

            // if new event is overlapping
            if (!(end <= midStart || start >= midEnd)) {
                // check if current event is overlapping with doubleBookings
                int ind = check(start, end, midEvent);
                if (ind == -1) {
                    return false;
                } else {
                    // add event at position low
                    List<Integer> pair = new ArrayList<>();
                    pair.add(start);
                    pair.add(end);
                    events.add(low, pair);
                    doubleBookings.add(ind, pair);
                }
            }

            if (end <= midStart) {
                // if event can be placed before mid-event
                high = mid - 1;
            } else if (start >= midEnd) {
                // if event can be placed after mid-event
                low = mid + 1;
            }
        }
        // add event at position low
        List<Integer> pair = new ArrayList<>();
        pair.add(start);
        pair.add(end);
        events.add(low, pair);
        return true;
    }

    public int check(int start, int end, List<Integer> prevMidEvent) {
        // apply binary search
        int low = 0;
        int high = doubleBookings.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            List<Integer> midEvent = doubleBookings.get(mid);
            int midStart = midEvent.get(0);
            int midEnd = midEvent.get(1);

            // if new event is overlapping
            if (!(end <= midStart || start >= midEnd)) {
                return -1;
            }

            if (end <= midStart) {
                // if event can be placed before mid event
                high = mid - 1;
            } else if (start >= midEnd) {
                // if event can be placed after mid event
                low = mid + 1;
            }
        }
        return low;
    }
}

