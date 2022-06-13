class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strCount = new HashMap<String, List<String>>();
        
        for(String str : strs){
            char[] sortedCharArray = str.toCharArray();
            Arrays.sort(sortedCharArray);
            String sortedStr = new String(sortedCharArray);
            List<String> existingList = strCount.getOrDefault(sortedStr, new ArrayList());
            existingList.add(str);                
            strCount.put(sortedStr, existingList);
        }
        
        return new ArrayList<>(strCount.values());
    }
}