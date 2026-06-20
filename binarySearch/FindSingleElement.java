package binarySearch;

public class FindSingleElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int result = singleNonDuplicate(nums);
        System.out.println("The single element is: " + result);
    }

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even for comparison
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2; // Move to the right half
            } else {
                high = mid; // Move to the left half
            }
        }

        return nums[low]; // The single element
    }
}
