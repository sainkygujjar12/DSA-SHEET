package Arrays;

public class maximumSubarray {
    public int maxSubArray(int[] nums) {
        int curr=nums[0];
        int maxSum=curr;

        for(int i=1;i<nums.length;i++){
            
            if(curr+nums[i]<=nums[i]){
                curr=nums[i];
            }else curr+=nums[i];
            maxSum=Math.max(curr,maxSum);
        }
        return maxSum;
    }
}

