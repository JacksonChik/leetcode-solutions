class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) left = mid+1;
            else if(target < nums[mid]) right = mid-1;
        }
        System.out.println(left);
        System.out.println(right);
        int result = (left + right)/2;
        if(result != nums.length && nums[result] < target) return result+1;
        else return result;
    }
}