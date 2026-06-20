package binarySearch;

public class nthRoot {
    public static void main(String[] args) {
        int n = 27;
        int m = 3;

        int result = findNthRoot(n, m);
        System.out.println("The " + m + "th root of " + n + " is: " + result);
    }

    public static int findNthRoot(int n, int m) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long midPower = power(mid, m);

            if (midPower == n) {
                return mid;
            } else if (midPower < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // If no integer root exists
    }

    public static long power(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}
