class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curSum = 0;
        int curLen = 0;
        int minimalLen = Integer.MAX_VALUE;
        for(int ptrR = 0; ptrR < nums.length; ptrR++){
            curLen ++;
            curSum += nums[ptrR];

            if(curSum >= target){
                while(ptrR - (curLen -1) >= 0 && curSum - nums[ptrR - (curLen -1)] >= target){
                    curSum -= nums[ptrR - (curLen - 1)];
                    curLen--;
                }
                minimalLen = Math.min(curLen, minimalLen);
            }
        }
        if(minimalLen == Integer.MAX_VALUE) return 0;
        return minimalLen;
    }
}