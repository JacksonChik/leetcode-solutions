class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }
        return hs.size() != nums.length;
    }
}