class MaxSubarray {
    public int maxSubArray(int[] nums) {
        //Kadane's algo

        int sumFromOne[] = new int[nums.length];
        
        sumFromOne[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sumFromOne[i] = sumFromOne[i-1] + nums[i];
        }
        
        
        int globalMax = sumFromOne[0];
        int localMax = sumFromOne[0];
        
        for(int i = 1 ; i < sumFromOne.length; i++){
            localMax = Math.max(nums[i], localMax + nums[i]); 
            //WHY NOT Math.max(nums[i], sumFromOne[i-1] + nums[i]) ???????
            if(localMax > globalMax){
                globalMax = localMax;
            }
        }
        
        return globalMax;
        
    }
}