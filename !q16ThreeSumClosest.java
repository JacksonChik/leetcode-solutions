class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int bestSum = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            // nums.length-2 for the 2 other elements to be picked
            int firstEl = nums[i];
            
            int ptrL = i + 1;
            int ptrR = nums.length - 1;
            while(ptrL < ptrR){

                int threeSum = firstEl + nums[ptrL] + nums[ptrR];
                
                if (Math.abs(threeSum - target) < Math.abs(bestSum - target)) {
                    bestSum = threeSum;
                }
                // NOT Math.abs(target - threeSum) < Math.abs(target - bestSum) !!
                if(threeSum < target){
                    ptrL++;
                }
                else if(threeSum > target){
                    ptrR--;
                }
                else if(threeSum == target){
                    return threeSum;
                }
                
            }
        }
        return bestSum;
    }
}