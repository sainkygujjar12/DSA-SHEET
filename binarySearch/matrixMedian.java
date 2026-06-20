package binarySearch;

public class matrixMedian {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };

        int median = findMedian(matrix);
        System.out.println("The median is: " + median);
    }

    public static int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the minimum and maximum elements in the matrix
        for (int i = 0; i < rows; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][cols - 1]);
        }

        int desiredCount = (rows * cols + 1) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < desiredCount) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    private static int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        for (int[] row : matrix) {
            count += upperBound(row, target);
        }
        return count;
    }

    private static int upperBound(int[] row, int target) {
        int low = 0;
        int high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
