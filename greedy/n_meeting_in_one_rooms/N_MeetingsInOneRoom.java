package n_meeting_in_one_rooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * N Meetings in One Room
 *
 * <a href="https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1">N Meetings in One Room</a>
 */
public class N_MeetingsInOneRoom {

    public static void main(String[] args) {
        // test 1
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        N_MeetingsInOneRoom obj = new N_MeetingsInOneRoom();
        int result = obj.maxMeetings(start, end, start.length);
        System.out.println(result);

        // test 2
        int[] start2 = {12, 10, 20};
        int[] end2 = {25, 20, 30};
        int result2 = obj.maxMeetings(start2, end2, start2.length);
        System.out.println(result2);
    }


    public int maxMeetings(int[] start, int[] end, int n) {

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            Meeting m = new Meeting(start[i], end[i], i + 1);
            meetings.add(m);
        }

        EndTimeComparator endTimeComparator = new EndTimeComparator();
        meetings.sort(endTimeComparator);

        // System.out.println(meetings);

        List<Integer> result = new ArrayList<>();
        int currEnd = 0;
        for (Meeting m : meetings) {
            if (m.start > currEnd) {
                currEnd = m.end;
                result.add(m.index);
            }
        }
        return result.size();
    }

    static class Meeting {
        int start;
        int end;
        int index;

        public Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public String toString() {
            return "[" + "start:" + this.start + " end: " + this.end + " index:" + index + "]";
        }
    }

    static class EndTimeComparator implements Comparator<Meeting> {
        public int compare(Meeting m1, Meeting m2) {
            if (m1.end < m2.end) return -1;
            if (m1.end > m2.end) return 1;
            if (m1.index < m2.index) return -1;
            return 1;
        }
    }
}

