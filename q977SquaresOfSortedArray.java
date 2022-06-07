class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int elCount = 0;
        
        while(elCount < nums.length){
            int lSquare = (int)Math.pow(nums[l], 2);
            int rSquare =  (int)Math.pow(nums[r], 2);
            result[nums.length - elCount - 1] = Math.max(lSquare, rSquare);
            
            elCount++;
            if(lSquare > rSquare) l++;
            else r--;
            
        }
        return result;
    }
}