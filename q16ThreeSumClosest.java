class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int bestSum = Integer.MIN_VALUE;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int firstEl = nums[i];
            
            int ptrL = i + 1;
            int ptrR = nums.length - 1;
            while(ptrL < ptrR && ptrL < nums.length && ptrR >= 0){ //-1 ???
                int threeSum = firstEl + nums[ptrL] + nums[ptrR];
                bestSum = Math.abs(target - threeSum) < Math.abs(target - bestSum) ? threeSum
                          : bestSum;
                if(threeSum < target){
                    ptrL++;
                }
                else if(threeSum > target){
                    ptrR--;
                    if(ptrL > i) ptrL--; //ptrL--?
                }
                else if(threeSum == target){
                    return threeSum;
                }
                
            }
        }
        return bestSum;
    }
}