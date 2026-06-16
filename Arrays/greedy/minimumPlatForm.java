// ...existing code...
package Arrays.greedy;

import java.util.Arrays;

public class minimumPlatForm {
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Minimum platforms required = " + findMinPlatforms(arrival, departure));
    }

    // Greedy two-pointer approach: sort arrivals and departures and sweep
    public static int findMinPlatforms(int[] arrival, int[] departure) {
        if (arrival == null || departure == null || arrival.length != departure.length) return 0;

        int n = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;    // a train arrives before previous departs
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
                i++;
            } else {
                platformsNeeded--;    // a train departs freeing a platform
                j++;
            }
        }
        return maxPlatforms;
    }
}
// ...existing code...