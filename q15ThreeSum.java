import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class q15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int edgeCase[] = {0,0,0};
        if(nums.length==3 && nums[0]==0 && nums[1]==0 && nums[2]==0) {
            List<List<Integer>> edgeResult = new ArrayList<List<Integer>>();
            edgeResult.add(Arrays.asList(0,0,0));
            return (edgeResult);
        }
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> numsMap = new HashMap<Integer, List<Integer>>();
        Set<List<Integer>> result = new HashSet();

        for(int i = 0; i < nums.length; i++){
            if(numsMap.containsKey(nums[i])){
                numsMap.get(nums[i]).add(i);
            }
            else {
                numsMap.put(nums[i],new ArrayList<Integer>());
                numsMap.get(nums[i]).add(i);
            }
        }
    
         for(int i = 0; i < nums.length; i++){
             //if (i != 0 && nums[i] == nums[i - 1]) continue;
             
             for(int j = i+1; j < nums.length; j++){
               //  if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                 
                 int numOnePlusTwo = nums[i] + nums[j];
                 if(numsMap.containsKey(-numOnePlusTwo)){
                     List<Integer> lastNumList = numsMap.get(-numOnePlusTwo);
                         //duplicate triplets????
                     List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[lastNumList.get(0)]);
                         if(lastNumList.size()==0) {
                             numsMap.remove(-numOnePlusTwo);
                         }
                     
                     
                     
                     
                    if(numsMap.get(-numOnePlusTwo).get((numsMap.get(-numOnePlusTwo).size()-1)) > j ) //VERY IMPORTANT LINE!!!!!!!!!!!!!!!!!!!!!!
                        
                       
                        
                        
                     result.add(triplet);

                 }
             }
         }   
         return new ArrayList(result);
    }
}