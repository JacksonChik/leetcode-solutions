class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        for(int ptrR = 1; ptrR < nums.length; ptrR++){
           if(nums[ptrR - 1] > 0) nums[ptrR] += nums[ptrR - 1];
            max = nums[ptrR] > max ? nums[ptrR] : max;
        }
        return max;
    }
}