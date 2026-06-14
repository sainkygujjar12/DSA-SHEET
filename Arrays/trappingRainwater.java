package Arrays;

public class trappingRainwater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int trappedWater = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += Math.max(0, leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += Math.max(0, rightMax - height[right]);
            }
        }

        return trappedWater;
    }   
}
