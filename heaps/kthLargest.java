package heaps;

public class kthLargest {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 12, 2};
        int k = 3;
        int result = findKthLargest(arr, k);
        System.out.println("The " + k + "rd largest element is: " + result);
    }

    public static int findKthLargest(int[] arr, int k) {
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
