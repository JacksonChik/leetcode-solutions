class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            while(Solution.containsDuplicate(s.substring(i,j + 1)) && i <= j){
                i++;
            }
            maxLen = j - i + 1 > maxLen ? j - i + 1: maxLen;
        }
        return maxLen;
    }
    
    static public boolean containsDuplicate(String s){
        HashSet<Character> usedChar = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            if(usedChar.contains(s.charAt(i))) return true;
            usedChar.add(s.charAt(i));
        }
        return false;
    }
}