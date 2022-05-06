class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
           while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) swap(nums, nums[i]-1, i);
            //READ THIS LINE!!!!!!
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != i+1) result.add(i+1);
        }
        return result;
    }
    public void swap(int[] nums, int el1, int el2){
        int temp = nums[el2];
        nums[el2] = nums[el1];
        nums[el1] = temp;
    }
}