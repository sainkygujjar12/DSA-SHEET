package Arrays;

public class maxConsecutiveones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        // Check at the end in case the array ends with 1s
        return Math.max(maxCount, currentCount);
    }   
}
