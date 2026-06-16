package Arrays.greedy;

public class nMeeting {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        int maxMeetings = getMaxMeetings(start, end);
        System.out.println("Maximum number of meetings: " + maxMeetings);
    }

    public static int getMaxMeetings(int[] start, int[] end) {
        int n = start.length;
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        // Sort meetings by their end time
        java.util.Arrays.sort(meetings, (a, b) -> a.end - b.end);

        int count = 1; // At least one meeting can be held
        int lastEndTime = meetings[0].end;

        for (int i = 1; i < n; i++) {
            if (meetings[i].start >= lastEndTime) {
                count++;
                lastEndTime = meetings[i].end;
            }
        }

        return count;
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
