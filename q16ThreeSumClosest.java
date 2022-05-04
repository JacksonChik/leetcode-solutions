class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int curClosest = Integer.MIN_VALUE;
        
        int[] flattenedTwoSumArray = new int[nums.length * (nums.length - 1)];
            
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int curTwoSum = nums[i] + nums[j];
                flattenedTwoSumArray[i * (nums.length - 1) + j] = curTwoSum;
                // the i-th element's two sum with the j-th element
                // is the index here correct?
            }
        }
        // O(n^2)
        // double check this!
        
        for(int i = 0; i < nums.length; i++){
            int twoSumToSearchFor = target - nums[i];
            // then find the closest 2sum to curDiff for nums[i]
            int curThreeSum = nums[i] + bSearchClosest(flattenedTwoSumArray, twoSumToSearchFor);
            // bsearch flatten array of size n^2, time complexity = O(log(n^2)) = O(2log(n)) =               // O(log(n))
            curClosest = Math.abs(target - curThreeSum) < Math.abs(target - curClosest) ?
                         curThreeSum : curClosest;
        }
        // O(nlog(n))
        return curClosest;
    }
    
    public int bSearchClosest(int[] nums, int target, int startIndex){
        //NUMBERS CANT BE REPICKED!!! BUG!!!!
        
        
        if(target < nums[0]) {
            return nums[0];
        }
        if(target > nums[nums.length-1]) {
            return nums[nums.length-1];
        }

        
        
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(target > nums[m]) l = m + 1;
            else if(target < nums[m]) r = m - 1;
            else return nums[m];
        }
        return (nums[l] - target) < (target - nums[r]) ? nums[l] : nums[r];
    }
}