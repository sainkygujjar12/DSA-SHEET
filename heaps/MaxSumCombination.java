package heaps;

public class MaxSumCombination {
    public static void main(String[] args) {
        int[] A = {4, 2, 5, 1};
        int[] B = {8, 0, 3, 5};
        int K = 3;
        int[] result = maxSumCombination(A, B, K);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] maxSumCombination(int[] A, int[] B, int K) {
        int n = A.length;
        java.util.PriorityQueue<int[]> maxHeap = new java.util.PriorityQueue<>((a, b) -> b[0] - a[0]);
        java.util.Set<String> visited = new java.util.HashSet<>();

        // Sort both arrays in descending order
        java.util.Arrays.sort(A);
        java.util.Arrays.sort(B);
        reverse(A);
        reverse(B);

        // Add the largest sum combination to the heap
        maxHeap.offer(new int[]{A[0] + B[0], 0, 0});
        visited.add("0-0");

        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            int[] current = maxHeap.poll();
            result[i] = current[0];
            int indexA = current[1];
            int indexB = current[2];

            // Add the next combination from A
            if (indexA + 1 < n && !visited.contains((indexA + 1) + "-" + indexB)) {
                maxHeap.offer(new int[]{A[indexA + 1] + B[indexB], indexA + 1, indexB});
                visited.add((indexA + 1) + "-" + indexB);
            }

            // Add the next combination from B
            if (indexB + 1 < n && !visited.contains(indexA + "-" + (indexB + 1))) {
                maxHeap.offer(new int[]{A[indexA] + B[indexB + 1], indexA, indexB + 1});
                visited.add(indexA + "-" + (indexB + 1));
            }
        }

        return result;
    }

    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
